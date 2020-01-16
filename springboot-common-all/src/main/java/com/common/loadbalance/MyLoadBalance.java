package com.common.loadbalance;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.cluster.loadbalance.AbstractLoadBalance;
import com.alibaba.dubbo.rpc.cluster.loadbalance.RandomLoadBalance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author xiaotantjl@163.com
 * @version V1.0
 * @Description: 自定义负载均衡测试
 * @date 2018/12/7 17:09
 */
public class MyLoadBalance extends AbstractLoadBalance {
    public static final String NAME = "group";
    private static final RandomLoadBalance randomLoadBalance = new RandomLoadBalance();

    private static Logger logger = LoggerFactory.getLogger(MyLoadBalance.class);
    @Override
    protected <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation) {
        logger.info("MyLoadBalance is select --------------");
        int length = invokers.size();
        int index = invokers.size()%length;
        return invokers.get(index);
    }


}
