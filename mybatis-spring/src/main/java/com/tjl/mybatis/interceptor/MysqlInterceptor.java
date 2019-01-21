package com.tjl.mybatis.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @author 0217319
 * @version V1.0
 * @Description: mybatis
 * @date 2018/12/19 11:30
 * 这个拦截器拦截Executor接口的update方法（其实也就是SqlSession的新增，删除，修改操作），
 *              所有执行executor的update方法都会被该拦截器拦截到。
 */
@Intercepts({@Signature(method = "query",type = Executor.class,
        args = {MappedStatement.class,Object.class,RowBounds.class, ResultHandler.class})})
public class MysqlInterceptor implements Interceptor {
    public void init(){
        System.out.println("MysqlInterceptor is init -----");
    }
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("MysqlInterceptor is intercept -----  intercept");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("MysqlInterceptor is intercept -----  properties");
    }
}
