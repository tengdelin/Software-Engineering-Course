package com.example.Web03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class userdatebase {
    public static int insert(USER_TABLE user) {
        String sql = "insert into monkey_user values(?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?)";
        Object[] params = {
                user.getUSER_ID(),
                user.getUSER_NAME(),
                user.getUSER_PASSWORD(),
                user.getUSER_SEX(),
                user.getUSER_BIRTHDAY(),
                user.getUSER_IDENITY_CODE(),
                user.getUSER_EMAIL(),
                user.getUSER_MOBILE(),
                user.getUSER_ADDRESS(),
                user.getUSER_STATUS()
        };
        return userdb.IUD(sql, params);
    }

    public static ArrayList<USER_TABLE> selectall(int cpage, int count, String keyword) {
        ArrayList<USER_TABLE> list = new ArrayList<USER_TABLE>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
        PreparedStatement ps = null;

        try {

            String sql = "";
            if (keyword != null) {
                sql = "select * from monkey_user where USER_NAME like ? order by USER_BIRTHDAY desc limit ?,?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setInt(2, (cpage - 1) * count);
                ps.setInt(3, count);

            } else {

                sql = "select * from monkey_user order by USER_BIRTHDAY desc limit ?,?;";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, (cpage - 1) * count);
                ps.setInt(2, count);

            }

            rs = ps.executeQuery();

            while (rs.next()) {
                USER_TABLE u = new USER_TABLE(
                        rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_SEX"),
                        rs.getString("USER_BIRTHDAY"),
                        rs.getString("USER_IDENITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBILE"),
                        rs.getString("USER_ADDRESS"),
                        rs.getInt("USER_STATUS")
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

    //修改函数进行查询
    public static USER_TABLE selectbyId(String id) {
        USER_TABLE u = null;

        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
        PreparedStatement ps = null;

        try {

            String sql = "select m.*,DATE_FORMAT(m.user_birthday,'%Y-%m-%d')birthday from monkey_user m where USER_ID=?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, id);


            rs = ps.executeQuery();

            while (rs.next()) {
                u = new USER_TABLE(
                        rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_SEX"),
                        rs.getString("birthday"),
                        rs.getString("USER_IDENITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBILE"),
                        rs.getString("USER_ADDRESS"),
                        rs.getInt("USER_STATUS")
                );

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            userdb.closeall(rs, ps, conn);
        }
        return u;
    }


    public static int[] totalPage(int count, String keyword) {
        int arr[] = {0, 1};//总数据，总页面
        Connection conn = userdb.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            String sql = "";
            if (keyword != null) {
                sql = "select count(*) from monkey_user where USER_NAME like ?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
            } else {
                sql = "select count(*) from monkey_user;";
                ps = conn.prepareStatement(sql);
            }


            rs = ps.executeQuery();

            while (rs.next()) {
                arr[0] = rs.getInt(1);
                if ((arr[0] % count) == 0) {
                    arr[1] = arr[0] / count;
                } else {
                    arr[1] = arr[0] / count + 1;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            userdb.closeall(rs, ps, conn);
        }

        return arr;
    }

    //修改函数
    public static int update(USER_TABLE user) {
        String sql = "update monkey_user set USER_NAME=?,USER_PASSWORD=?,USER_SEX=?,USER_BIRTHDAY=DATE_FORMAT(?,'%y-%m-%d'),USER_IDENITY_CODE=?,USER_EMAIL=?,USER_MOBILE=?,USER_ADDRESS=?,USER_STATUS=? where USER_ID=?";
        Object[] params = {
                user.getUSER_NAME(),
                user.getUSER_PASSWORD(),
                user.getUSER_SEX(),
                user.getUSER_BIRTHDAY(),
                user.getUSER_IDENITY_CODE(),
                user.getUSER_EMAIL(),
                user.getUSER_MOBILE(),
                user.getUSER_ADDRESS(),
                user.getUSER_STATUS(),
                user.getUSER_ID()
        };
        return userdb.IUD(sql, params);
    }

    //删除函数
    public static int delete(String id) {
        String sql = "delete from monkey_user where USER_ID=? and USER_STATUS=1";

        Object[] params = {
               id
        };
        return userdb.IUD(sql, params);
    }

    public static int selectlogin(USER_TABLE user){
        String sql = "select * from monkey_user where USER_ID=? and USER_PASSWORD=?and USER_STATUS=2;";
        Object[] params = {
                user.getUSER_ID(),
                user.getUSER_PASSWORD(),
        };
        return userdb.IUD(sql,params,1);
    }

    //web登录
    public static int weblogin(USER_TABLE user){
        String sql = "select * from monkey_user where USER_ID=? and USER_PASSWORD=?;";
        Object[] params = {
                user.getUSER_ID(),
                user.getUSER_PASSWORD(),
        };

        return userdb.IUD(sql,params,1);
    }

    //查询用户名
    public static int  selectbyname(String id) {
        int count = 0;
        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select count(*) from monkey_user m where USER_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            userdb.closeall(rs, ps, conn);
        }
        return count;
    }

    //修改函数进行查询
    public static USER_TABLE selectadmin(String username,String pwd) {
        USER_TABLE u = null;

        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
        PreparedStatement ps = null;

        try {

            String sql = "select m.*,DATE_FORMAT(m.user_birthday,'%Y-%m-%d')birthday from monkey_user m where USER_ID=? and USER_PASSWORD=?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, pwd);



            rs = ps.executeQuery();

            while (rs.next()) {
                u = new USER_TABLE(
                        rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_SEX"),
                        rs.getString("birthday"),
                        rs.getString("USER_IDENITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBILE"),
                        rs.getString("USER_ADDRESS"),
                        rs.getInt("USER_STATUS")
                );

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            userdb.closeall(rs, ps, conn);
        }
        return u;
    }
}
