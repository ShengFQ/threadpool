package com.shengfq.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: TestBaseDao
 * Description: 批量插入百万数据
 *
 * @author shengfq
 * @date: 2023/1/4 5:56 下午
 */
public class TestBaseDao {
    private static final String SELECT="select * from user";
    private static final String INSERT_STATEMENT="insert into user(id,name,age,email) values(?,?,?,?)";
    public static void main(String[] args) {
        testInsert();
    }
    /**
     *方案一.使用配置项一次性插入100万条,耗时14秒.
     * rewriteBatchedStatements=true,一次插入多条数据，只插入一次
     * */
    private static void testInsert(){
        long start=System.currentTimeMillis();
        Connection conn=BaseDao.getConn("test","root","1qazXSW@");
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=conn.prepareStatement(INSERT_STATEMENT);
            for (int i = 0; i < 100*10000; i++) {
                ps.setInt(1,i);
                ps.setString(2,"shengfq");
                ps.setInt(3,20);
                ps.setString(4,"shengfu.qiang@163.com");
                ps.addBatch();
            }
            int[] ints=ps.executeBatch();
            if(ints.length>0){
                System.out.println("complete!!!");
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,ps,rs);
        }
        long end=System.currentTimeMillis();
        System.out.println("time:"+(end-start)/1000);
    }
    /**
     * 验证查询
     * */
    private static void testQuery(){
        Connection conn=BaseDao.getConn("test","root","1qazXSW@");
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            ps=conn.prepareStatement(SELECT);
            rs=ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(2));
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,ps,rs);
        }
    }
}
