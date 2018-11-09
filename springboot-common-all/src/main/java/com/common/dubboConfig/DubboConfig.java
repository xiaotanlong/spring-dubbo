package com.common.dubboConfig;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.RegistryFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 0217319
 * @version V1.0
 * @Description: 重置 路由规则
 * @date 2018/11/8 18:48
 */
@Component
public class DubboConfig {


    static Logger logger = LoggerFactory.getLogger(DubboConfig.class);

    /**
     * 添加路由规则
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String zkServerPath = "127.0.0.1:2181";
        //String zkServerPath = "192.168.16.203:2181";
        List<String> paths = lookup(zkServerPath, "/dubbo");
        paths.forEach(System.out::println);

        paths.forEach(path -> deleteAll(zkServerPath, String.format("/dubbo/%s/routers", path)));

        register(paths, zkServerPath);
    }

    /**
     * 删除所有
     *
     * @throws Exception
     */
    public static void deleteAll(String zkServerPath, String path) {
        CuratorFramework zkClient =
                CuratorFrameworkFactory.newClient(zkServerPath, new ExponentialBackoffRetry(1000, 3));
        zkClient.start();
        try {
            zkClient.delete().guaranteed().deletingChildrenIfNeeded().forPath(path);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 检索所有服务
     *
     * @return
     * @throws Exception
     */
    public static List<String> lookup(String zkServerPath, String path) throws Exception {
        CuratorFramework zkClient =
                CuratorFrameworkFactory.newClient(zkServerPath, new ExponentialBackoffRetry(1000, 3));
        zkClient.start();
        return zkClient.getChildren().forPath(path);
    }

    /**
     * 注册规则  频繁注册  清除缓存
     *
     * @param paths
     */
    public static void register(List<String> paths, String zkServerPath) {
        RegistryFactory registryFactory =
                ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
        Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://" + zkServerPath + "?group=dubbo"));
        paths.forEach(path -> {
            registry.unregister(URL.valueOf("routers://0.0.0.0/" + path + "?name=my"
                    + "&category=routers&router=myRouter&dynamic=false&version=1.0&runtime=true"));
            registry.register(URL.valueOf("routers://0.0.0.0/" + path + "?name=my"
                    + "&category=routers&router=myRouter&dynamic=false&version=1.0&runtime=true"));
        });
    }


}
