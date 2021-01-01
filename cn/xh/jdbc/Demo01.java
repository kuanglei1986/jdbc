package cn.xh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) {
        Statement st=null;
        Connection conn=null;
        try {
            //1.加载mysql数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建连接
            conn =  DriverManager.getConnection("jdbc:mysql://106.52.26.197:3306/test?useUnicode=true&characterEncoding=utf8","root","jz3917JZC!");
            //3.创建statement
            st = conn.createStatement();
            //4.执行sql语句
            int count =  st.executeUpdate("insert into account(id,name,money) values(1,'老王',1000)");
            System.out.println(count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(st!=null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
