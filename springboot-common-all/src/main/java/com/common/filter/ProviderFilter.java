package com.common.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.common.session.UserSession;

/**
 * @author xiaotantjl@163.com
 * @version V1.0
 * @Description: dubbo 提供者  filters
 * @date 2018/10/26 11:38
 */
@Activate(group = { Constants.PROVIDER})
public class ProviderFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("ProviderFilter set info -----------");
        String msg = RpcContext.getContext().getAttachment("usersession");
        System.out.println("msg is + " + msg);
        UserSession.set("usersession",msg);
        return invoker.invoke(invocation);
    }
}
