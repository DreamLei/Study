/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: TestSql
 * Author:   tell
 * Date:     2018/6/22 19:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.smart4j.chapter1;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author tell
 * @create 2018/6/22
 * @since 1.0.0
 */
import java.sql.*;
public class TestSql {
    public static void main(String[] args) {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver="com.mysql.jdbc.Driver";
        //URL指向对象
        String url="jdbc:mysql://localhost:3306/test";
        //MySQL配置时的用户名
        String user="root";
        String password="990213";
        try {
            //加载驱动
            Class.forName(driver);
            //第一步：.getConnection(url,user,password)方法——连接MySQL数据库
            con=DriverManager.getConnection(url,user,password);
            if(!con.isClosed()){
                System.out.println("Succeeded connecting to the DataBase!");
            }
            //第二步：创建statement类对象，用来执行SQL语句
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from fruits";
            //第三步：ResultSet类，用来存放获取结果
            ResultSet rs = statement.executeQuery(sql);
          //  System.out.println("------------------------------------------");
        //    System.out.println("姓名"+"\t"+"年龄"+"\t"+"性别");
          //  System.out.println("------------------------------------------");
            String name = null;
            int age = 0;
            String sex = null;
            while(rs.next()){
                name = rs.getString("name");
                age = rs.getInt("age");
                sex = rs.getString("sex");
                System.out.println(name+"\t"+age+"\t"+sex);
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can't find the Driver");
            e.printStackTrace();
        } catch (SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        } finally{
            System.out.println("数据库数据成功获取！");
        }
    }
}