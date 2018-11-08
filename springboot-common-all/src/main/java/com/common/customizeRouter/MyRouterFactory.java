package com.common.customizeRouter;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.cluster.Router;
import com.alibaba.dubbo.rpc.cluster.RouterFactory;

/**
 * @author 0217319
 * @version V1.0
 * @Description: 自定义  路由获取工厂
 * @date 2018/11/8 17:59
 */
public class MyRouterFactory implements RouterFactory {
    @Override
    public Router getRouter(URL url) {
        return null;
    }
}
