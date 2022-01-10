package com.example.Web03;

import java.sql.*;
import java.util.ResourceBundle;

public class userdb {
    static {
        try {
            //注册
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getconn() {
        Connection conn=null;
        try {
            //连接
            conn = DriverManager.getConnection("jdbc:mysql://8.129.165.170:3306/monkey","monkey","123456");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static int IUD(String sql, Object[] params) {
        int count = 0;
        Connection conn = userdb.getconn();
        PreparedStatement ps = null;
        try {
            //执行
            ps = conn.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (int i = 0; i < params.length; i++) {
            try {
                ps.setObject(i + 1, params[i]);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        try {
            count = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            userdb.closeall(null, ps, conn);
        }
        return count;
    }
    public static int IUD(String sql, Object[] params,int flag) {
        int count = 0;
        Connection conn = userdb.getconn();
        PreparedStatement ps = null;
        ResultSet res=null;
        try {
            //执行
            ps = conn.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (int i = 0; i < params.length; i++) {
            try {
                ps.setObject(i + 1, params[i]);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        try {
            res = ps.executeQuery();
            while (res.next()){
                count++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            userdb.closeall(null, ps, conn);
        }
        return count;
    }

    public static void closeall(ResultSet rs, PreparedStatement ps, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
