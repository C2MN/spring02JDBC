package com.srx.service.impl;

import com.srx.dao.IAccountDao;
import com.srx.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *账户的业务实现类
 *
 * 曾经xml的配置
 * <bean id="accountService" class="com.srx.service.impl.AccountServiceImpl"
 *  scope="" init-method="" destroy-method="">
 *      <property name="" value=""/ref=""></property>
 *  </bean>
 *
 * 注解的分类：
 * 1.用于创建对象的注解
 *      作用相当于在xml配置文件中编写bean标签实现的功能一样
 *      @Component
 *          作用：用于把当前类对象存入Spring容器中,参数：value：用于指定bean的id
 *          @Repository @Service @Controller
 * 2.用于注入数据
 *      作用相当于在xml配置文件中的bean标签中写一个<property></property>标签的作用是一样
 *      @Autowired
 *          作用：自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型配皮，就可以注入成功。
 *               如果IOC容器中没有任何bean的类型和要注入的变量类型匹配，则报错。
 *               如果IOC容器中有多个类型匹配时
 *          出现位置：该注解可以是类成员变量、方法及构造方法进行标注，完成自动装配的工作。
 *          细节：在使用该注解注入时可以不用写set方法
 *      @Qualifier(不能独立使用)
 *          作用：在按照类中注入的基础之上在按照名称注入。它在给类成员注入时不能单独使用。但是在给方法参数注入时可以。
 *              该注解与@Autowired注解配合使用。当@Autowired注解需要按照名称来装配注入时需要和该注解一起使用，Bean的实例名称由@Qualifier
 *          注解的参数指定。
 *          属性：value：用于指定注入bean的id；
 *      @Resource
 *          作用：该注解与@Autowired的功能一样，区别在于该注解默认时按照名称来装配注入的，只有当找不到与名称匹配的Bean时才会按照类型来装配
 *              注入；而@Autowired默认按照Bean的类型进行装配，如果想按照名称来装配注入，则需要和@Qualifier注解一起使用。
 *          属性：name属性指定Bean实例名称，即按照名称来装配注入；
 *               type属性指定Bean类型，即按照Bean的类型进行装配。
 *      以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
 *      另外，集合类型的注入只能通过xml来实现
 *      @Value
 *          作用：用于注入基本类型和String类型的数据
 *          属性：value：用于指定数据类型，它可以使用spring中SpEL(spring的el表达式)
 *                      SpEL的写法：${表达式}
 * 3.用于改变作用范围
 *      作用相当于在xml配置文件中的bean标签中的scope属性实现的功能一样
 *      @Scope
 *          作用：用于指定bean的作用范围
 *          属性：value，指定范围的取值。常用取值：singLeton prototype
 * 4.和生命周期相关
 *      作用相当于xml配置文件中的bean标签中使用的init-method和destroy-method的作用一样的
 *      PreDestroy:用于指定销毁方法
 *      PostConstruct：用于指定初始化方法
 */
@Service("accountServiceImpl")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    @Qualifier("accountDaoImpl1")
    private IAccountDao accountDao;

    public AccountServiceImpl(){
        System.out.println("对象创建了！！！");
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println("service中的saveAccount方法执行了！！！");
    }
}
