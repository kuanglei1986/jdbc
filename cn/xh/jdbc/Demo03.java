package cn.xh.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo03 {
    public static void main(String[] args) {
        Connection  conn=null;
        Statement st=null;
        ResultSet rs = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建连接
            conn =  DriverManager.getConnection("jdbc:mysql://106.52.26.197:3306/test?useUnicode=true&characterEncoding=utf8","root","jz3917JZC!");
            //3.创建statement
            st = conn.createStatement();
            //4.执行sql语句
            rs = st.executeQuery("select * from account");
            //5.创建list集合
            List<Account> lst = new ArrayList<Account>();
            //6.将rs里面的数据封装到lst
            while(rs.next()){
                Account a = new Account();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setMoney(rs.getDouble("money"));
                lst.add(a);
            }
            System.out.println(lst.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(st!=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
