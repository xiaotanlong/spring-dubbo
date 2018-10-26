package com.dubbo.com.dubbo.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.dubbo.session.UserSession;

/**
 * @author xiaotantjl@163.com
 * @version V1.0
 * @Description: Dubbo Filter
 * RpcContext 这个类似javaWeb的  ThreadLocal   需要自己能隐式传递变量
 *
 * com.alibaba.dubbo.rpc.cluster.Cluster
 * Directory
        Directory继承node，主要是invocation找到invoker的list。
        Class<T> getInterface();
        接口类的type
        List<Invoker<T>> list(Invocation invocation) throws RpcException;
        根据Invocation找到Invoker的list
 *
 * invoker：指服务提供着provider列表
 * invocation：指服务rpc调用相关参数信息
 *
 * 整体概念
    Invocation，一次具体的调用，包含方法名、参数类型、参数
    Result，一次调用结果，包含value和exception
    Invoker，调用者，对应一个服务接口，通过invoke方法执行调用，参数为Invocation，返回值为Result
 */
@Activate(group = { Constants.CONSUMER })
public class ConsumerFilter implements Filter{
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            System.out.println("ConsumerFilter set info ----------");
            String msg = (String) UserSession.get("usersession");
            System.out.println("msg is + " + msg);
            //提供者 实例 名称
            String invoker_CanonicalName = invoker.getInterface().getCanonicalName();
            //invocation 调用者的方法名
            String invocation_MethodName = invocation.getMethodName();
            System.out.println("invoker_CanonicalName is :" + invoker_CanonicalName);
            System.out.println("invocation_MethodName is :" + invocation_MethodName);
            RpcContext.getContext().setAttachment("usersession",msg);
            return invoker.invoke(invocation);
        } finally {
            RpcContext.getContext().removeAttachment("usersession");
        }
    }
}
