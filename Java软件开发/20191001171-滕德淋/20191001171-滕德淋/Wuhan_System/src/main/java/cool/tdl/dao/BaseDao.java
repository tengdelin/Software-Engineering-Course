package cool.tdl.dao;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        InputStream resource = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(resource);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getconn() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn=null;
        try {
            //连接
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public static int IUD(String sql, Object[] params) {
        int count = 0;
        Connection conn = BaseDao.getconn();
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
            BaseDao.closeall(null, ps, conn);
        }
        return count;
    }
    public static int IUD(String sql, Object[] params,int flag) {
        int count = 0;
        Connection conn = BaseDao.getconn();
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
            res = ps.executeQuery();//区别在这里
            while (res.next()){
                count++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeall(null, ps, conn);
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