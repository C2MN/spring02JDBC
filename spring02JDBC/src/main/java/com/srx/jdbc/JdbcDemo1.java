package com.srx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 程序的耦合
 *  耦合：简单的指程序间的依赖关系
 *       分类：
 *             类之间的依赖
 *             方法之间的依赖
 *  解耦：降低程序间的依赖关系；
 *  实际开发的时候应该避免编译期间不依赖，运行期间才依赖
 *  解耦的思路：
 *      第一步：在创建对象的时候使用放射的机制来创建对象，而避免使用new关键字
 *      第二步：通过读取配置文件来获取要创建的对象全限定类名，然后通过放射来创建对象
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());//避免直接new 这样的结果就是依赖一个具体的驱动类
        Class.forName("com.mysql.jdbc.Driver");//使用放射的机制来注册驱动 com.mysql.jdbc.Driver只是一个字符串，不是类
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db01","root","root");
        //3.获取数据库的预处理操作
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //4.执行SQL语句，得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
