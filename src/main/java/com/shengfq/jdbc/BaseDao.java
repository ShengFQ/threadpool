package com.shengfq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {  //  静态工具类，用于创建数据库连接对象和释放资源，方便调用
    //    导入驱动jar包或添加Maven依赖（这里使用的是Maven，Maven依赖代码附在文末）
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //  获取数据库连接对象
    public static Connection getConn(String database, String username, String password) {
        //  rewriteBatchedStatements=true,一次插入多条数据，只插入一次
        Connection conn = null;
        try {
            //  useUnicode=true&characterEncoding=utf-8
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database + "?rewriteBatchedStatements=true", username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    //  释放资源
    public static void closeAll(AutoCloseable... autoCloseables) {
        for (AutoCloseable autoCloseable : autoCloseables) {
            if (autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
