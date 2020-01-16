package com.common.customizeRouter;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.Router;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaotantjl@163.com
 * @version V1.0
 * @Description: 自定义的路由规则  也可以通过自定义负载规则  来实现指定服务选举
 *
 * 读写分离思想  拦截rpc请求 根据方法名  指定到不同的ip服务
 * 注：另外还有两点需要注意
    1. 如果有多条routers规则，那么会根据每一条routers来过滤出可调用的provider列表
    2. 针对条件路由，当经过某条路由规则路由后，没有一个符合规则的Provider，
    那么此次路由失败，会直接返回路由本条规则前的所有Provider，也就是相当于没有经过该路由的结果。
 * @date 2018/11/8 18:02
 */
public class MyRouter implements Router,Comparable<Router> {
    private URL url;

    public MyRouter(URL url){
        this.url = url;
    }
    @Override
    public URL getUrl() {
        return this.url;
    }

    @Override
    public <T> List<Invoker<T>> route(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {
        String ip = RpcContext.getContext().getAttachment("client_ip");
        //dubbo.protocol.host  自己服务启动后  需要自己想自己的ip注册到zk容器中
        //如果没有 则代表不是本地调试  保证测试服务  正常获取 rpc调用
        if (ip == null) {
            ip = System.getProperty("dubbo.protocol.host");
        }
        System.out.println("自定义的路由==================");
        if(ip == null){
            return excludeLocalService(invokers);
        }else{
            RpcContext.getContext().setAttachment("client_ip", ip);
        }
        List<Invoker<T>> result = new ArrayList<Invoker<T>>();
        for (Invoker<T> invoker : invokers) {
            if (ip.equals(invoker.getUrl().getIp())) {
                result.add(invoker);
            }
        }
        //当自己本地没有启动服务的时候，排除和自己本地开发同网段的其他服务
        //如果自己本地注册了服务  result  里会只有自己的本地服务ip  会调用自己本地的服务
        if (result.isEmpty()) {
            return excludeLocalService(invokers);
        }
        return result;
    }

    @Override
    public int compareTo(Router o) {
        return 1;
    }

    /**
     * 排除本地服务  配置本地开发的  ip网段  进行排除  保证  自己本地调用的  rpc接口只调到自己本地的服务
     * @param invokers
     * @return
     */
    private <T> List<Invoker<T>> excludeLocalService(List<Invoker<T>> invokers){
        List<Invoker<T>> result = new ArrayList<Invoker<T>>();
        invokers.forEach(invoker -> {
            String serviceIp = invoker.getUrl().getIp();
            if(!serviceIp.startsWith("10.")){
                result.add(invoker);
            }
        });
        return result;
    }
}
