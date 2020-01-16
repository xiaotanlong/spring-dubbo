package com.tjl.mybatis.objectfactory;

import com.tjl.mybatis.entity.TUser;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.Collection;
import java.util.List;
import java.util.Properties;
/**
 * @author xiaotantjl@163.com
 * @version V1.0
 * @Description: MyBatis 每次创建结果对象实例时,它使用一个 ObjectFactory 实例来完成。
 * @date 2018/12/20 16:53
 */
public class ExampleObjectFactory extends DefaultObjectFactory {
    //使用默认构造方法创建对象实例
    public Object create(Class type) {
        return super.create(type);
    }

/*    //有构造参数列表和构造参数值列表的创建对象实例的方式
    public Object create(Class type, List<Class> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }*/
    //为自定义ObjectFactory设置配置参数
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    public <T> boolean isCollection(Class<T> type) {
        return Collection.class.isAssignableFrom(type);
    }

    @Override
    //注意，在DefaultObjectFactory的create(Class type)方法中调用的是
    //create(Class,List<Class> constructorArgTypes,List<Object> constructorArgs)方法，
    //所以，只需要在这个方法中完成自定义初始化逻辑即可。
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes,List<Object> constructorArgs){
        T ret= super.create(type, constructorArgTypes, constructorArgs);
        //判断接口类型和执行接口方法。
        if(TUser.class.isAssignableFrom(type)){
            TUser tUser=(TUser)ret;
            System.out.println(tUser.toString());
        }
        return ret;
    }
}
