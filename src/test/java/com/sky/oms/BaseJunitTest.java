package com.sky.oms;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration  //调用javaWEB的组件，比如自动注入
@ContextConfiguration(locations = {"classpath*:spring-mvc.xml","classpath*:spring-mybatis.xml"})
//当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否
//@TransactionConfiguration( transactionManager = "transactionManager",defaultRollback = true)
//@Transactional
public class BaseJunitTest {
}
