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
 * @author 0217319
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2018/11/8 18:02
 */
public class MyRouter implements Router {
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
