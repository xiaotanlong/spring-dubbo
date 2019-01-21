package mybatis;

import com.tjl.mybatis.entity.TUser;
import com.tjl.mybatis.mapper.TUserMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 0217319
 * @version V1.0
 * @Description:
 * @date 2018/12/18 17:35
 */
public class MybatisSpringTest {

    private TUserMapper tUserMapper;

    private ApplicationContext applicationContext;
    @Before
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TUserMapper tUserMapper = applicationContext.getBean(TUserMapper.class);
        this.tUserMapper = tUserMapper;
    }

    @Test
    public void test01(){
        TUser tUser = tUserMapper.selectByPrimaryKey(2);
        System.out.println(tUser);
    }
}
