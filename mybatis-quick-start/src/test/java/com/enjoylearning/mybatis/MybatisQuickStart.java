package com.enjoylearning.mybatis;

import java.io.IOException;
import java.io.InputStream;

import com.enjoylearning.mybatis.entity.TUser;
import com.enjoylearning.mybatis.mapper.TUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * SqlSessionFactoryBuilder：读取配置信息创建SqlSessionFactory，建造者模式，方法级别生命周期；
  SqlSessionFactory：创建Sqlsession，工厂单例模式，存在于程序的整个生命周期；
  SqlSession：代表一次数据库连接，可以直接发送SQL执行，也可以通过调用Mapper访问数据库；线程不安全，
 	要保证线程独享（方法级）；
  SQL Mapper：由一个Java接口和XML文件组成，包含了要执行的SQL语句和结果集映射规则。方法级别生命周期；
 */
public class MybatisQuickStart {

	private SqlSessionFactory sqlSessionFactory;

	//执行测试方法前执行
	@Before
	public void init() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 1.读取mybatis配置文件创SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		inputStream.close();
	}

	@Test
	// 快速入门
	public void quickStart() throws IOException {
		// 2.获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//自定提交事务
		SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
		//Executor  类型选择使用批量处理   and   z自动提交事务
		SqlSession sqlSession2 = sqlSessionFactory.openSession(ExecutorType.BATCH,true);
		// 3.获取对应mapper
		TUserMapper mapper = sqlSession.getMapper(TUserMapper.class);
		// 4.执行查询语句并返回结果
		TUser user = mapper.selectByPrimaryKey(1);

		System.out.println(user.toString());

	}
	
}
