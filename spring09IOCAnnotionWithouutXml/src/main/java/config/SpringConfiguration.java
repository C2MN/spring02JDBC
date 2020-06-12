package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 该类是一个配置类。用于取代bean.xml的作用
 * spring的新注解
 *      @Configuration
 *         作用：指定当前类是一个配置类
 *         细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写。
 *      @ComponentScan
 *         作用：用于通过注解指定spring在创建容器时要扫描的包
 *         属性：value它和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包。
 *                  使用此注解就等于在xml中配置了：<context:component-scan base-package="com.srx"></context:component-scan>
 *      @Bean
 *         作用：用于把当前方法的返回值作为bean对象存入spring容器中
 *         属性：name用于指定bean的id，默认值是当前方法的名称
 *         细节：当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。
 *              查找的方式和Autowired注解的作用是一样的
 *      @Import
 *          作用：用于导入其他的配置类，在引入其他的配置类时，可以不用再写@Configuration注解；
 *          属性：value{}：用于指定其他配置类的字节码。有Import注解的类就是父配置类，而导入的都是子配置类；
 *      @property
 *          作用：用于加载.properties文件中的配置，例如我们在配置数据库数据源时，可以把连接数据库的信息写入到.properties配置文件中，就可已使用此注解指定properties文件的位置。
 *          属性：value[]：用于指定 properties 文件位置。如果是在类路径下，需要写上 classpath:
 */
@Configuration
@ComponentScan(basePackages = "com.srx")
@Import({JdbcConfig.class})
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {

}
