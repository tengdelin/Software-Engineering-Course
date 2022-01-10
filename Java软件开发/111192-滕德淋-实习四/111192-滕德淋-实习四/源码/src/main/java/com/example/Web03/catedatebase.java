package com.example.Web03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class catedatebase {
    /***
     * 获取所有分类
     * @return
     */
    public static ArrayList<CATE_TABLE> selectall() {
        ArrayList<CATE_TABLE> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select * from monkey_category;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CATE_TABLE u = new CATE_TABLE(
                        rs.getInt("CATE_ID"),
                        rs.getString("CATE_NAME"),
                        rs.getInt("CATE_PARENT_ID")
                );
                list.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            userdb.closeall(rs, ps, conn);
        }
        return list;
    }

    /***
     * 增加分类
     * @param c c是传入要插入的对象
     * @return
     */
    public static int insert(CATE_TABLE c) {
        String sql = "insert into monkey_category values(null,?,?)";
        Object[] params = {
                c.getCATE_NAME(),
                c.getCATE_PARENT_ID()
        };
        return userdb.IUD(sql, params);
    }


    public static ArrayList<CATE_TABLE> selectCat(String flag) {
        ArrayList<CATE_TABLE> list = new ArrayList<>();
        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
        PreparedStatement ps = null;

        try {
            String sql ="";
            if (flag!=null&&flag.equals("father")){
                sql = "select * from monkey_category where CATE_PARENT_ID=0;";
            }else {
                sql = "select * from monkey_category where CATE_PARENT_ID!=0;";
            }
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CATE_TABLE u = new CATE_TABLE(
                        rs.getInt("CATE_ID"),
                        rs.getString("CATE_NAME"),
                        rs.getInt("CATE_PARENT_ID")
                );
                list.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            userdb.closeall(rs, ps, conn);
        }
        return list;
    }

}
