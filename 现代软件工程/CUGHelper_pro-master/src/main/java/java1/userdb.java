package java1;
import java.sql.*;

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
            conn = DriverManager.getConnection("jdbc:mysql://8.129.165.170:3306/web1.0","web1.0","123456");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public static int IUD(String sql, Object[] params,int flag) {
        int loginsuccess = 0;
        int count = 0;
        userdb u = new userdb();
        Connection conn = u.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //执行
            ps = conn.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //执行嵌入sql
        for (int i = 0; i < params.length; i++) {
            try {
                ps.setObject(i + 1, params[i]);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //0注册  1登录
        if(flag==0){
            try {
                count = ps.executeUpdate();
                return count;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                userdb.closeall(null, ps, conn);
            }
        }else {
            try {
                rs=ps.executeQuery();
                if (rs.next()){
                    loginsuccess=1;
                    return loginsuccess;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                userdb.closeall(null, ps, conn);
            }
        }

        if(loginsuccess==1){
            count=loginsuccess;
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
