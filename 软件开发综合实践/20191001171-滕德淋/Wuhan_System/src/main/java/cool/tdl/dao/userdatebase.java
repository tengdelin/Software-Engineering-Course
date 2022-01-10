package cool.tdl.dao;

import cool.tdl.pojo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class userdatebase {
    //用户注册函数
    public static int insert(USER_TABLE user) {
        String sql = "insert into user values(?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?)";
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
        return BaseDao.IUD(sql, params);
    }
    //用户函数登录
    public static int weblogin(USER_TABLE user) {
        String sql = "select * from user where USER_ID=? and USER_PASSWORD=?;";
        Object[] params = {
                user.getUSER_ID(),
                user.getUSER_PASSWORD(),
        };
        return BaseDao.IUD(sql, params, 1);
    }
    //修改图片
    public static int insert_icon(icon i) {
        String sql = "UPDATE icon SET iconname = ? WHERE userid=?;";
        Object[] params = {
                i.getIconname(),
                i.getUserfid()
        };
        return BaseDao.IUD(sql, params);
    }
    //选择头像图片
    public static icon select_iconname(String userid) {

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        icon u = null;
        try {
            String sql = "select * from icon where userid=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userid);
            rs = ps.executeQuery();
            rs.next();
            u = new icon(
                    rs.getString(1),
                    rs.getString(2)
            );
            return u;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }
        return u;
    }
    //管理员增加用户
    public static int admin_insert_user(USER_TABLE user) {
        String sql = "insert into user values(?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?)";
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
        return BaseDao.IUD(sql, params);
    }
    //管理员删除用户
    public static int admin_delete_user(String id) {
        String sql = "delete from user where USER_ID=? and USER_STATUS=1";
        Object[] params = {
                id
        };
        return BaseDao.IUD(sql, params);
    }
    //管理员修改用户
    public static boolean admin_update_user(USER_TABLE user) {
        String sql = "update user set USER_NAME=?,USER_PASSWORD=?,USER_SEX=?,USER_BIRTHDAY=DATE_FORMAT(?,'%y-%m-%d'),USER_IDENITY_CODE=?,USER_EMAIL=?,USER_MOBILE=?,USER_ADDRESS=?,USER_STATUS=? where USER_ID=?";
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
        int count = BaseDao.IUD(sql, params);
        if (count != 0) {
            return true;
        } else {
            return false;
        }
    }
    //管理员查找用户
    public static USER_TABLE admin_select_user(String username) {
        USER_TABLE u = null;
        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select m.*,DATE_FORMAT(m.user_birthday,'%Y-%m-%d')birthday from user m where USER_ID=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);

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
            BaseDao.closeall(rs, ps, conn);
        }
        return u;

    }
    //查询用户名，注册验证用户名不能重复
    public static int selectbyname(String id) {
        int count = 0;
        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select count(*) from user where USER_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }
        return count;
    }
    //后台登录
    public static int selectlogin(USER_TABLE user) {
        String sql = "select * from user where USER_ID=? and USER_PASSWORD=?and USER_STATUS in (2,3);";
        Object[] params = {
                user.getUSER_ID(),
                user.getUSER_PASSWORD(),
        };
        return BaseDao.IUD(sql, params, 1);
    }
    //修改函数进行查询，获得用户全部信息，显示在页面上，便于修改
    public static USER_TABLE selectbyId(String id) {
        USER_TABLE u = null;

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {

            String sql = "select m.*,DATE_FORMAT(m.user_birthday,'%Y-%m-%d')birthday from user m where USER_ID=?";

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
            BaseDao.closeall(rs, ps, conn);
        }
        return u;
    }
    //用来翻页，计算数据的
    public static int[] totalPage(int count, String keyword) {
        int arr[] = {0, 1};//总数据，总页面
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            String sql = "";
            if (keyword != null) {
                sql = "select count(*) from user where USER_NAME like ?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
            } else {
                sql = "select count(*) from user;";
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
            BaseDao.closeall(rs, ps, conn);
        }

        return arr;
    }
    //获得所有的用户，返回一个用户列表
    public static ArrayList<USER_TABLE> selectall(int cpage, int count, String keyword) {
        ArrayList<USER_TABLE> list = new ArrayList<USER_TABLE>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {

            String sql = "";
            if (keyword != null) {
                sql = "select * from user where USER_NAME like ? order by USER_BIRTHDAY desc limit ?,?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setInt(2, (cpage - 1) * count);
                ps.setInt(3, count);

            } else {

                sql = "select * from user order by USER_BIRTHDAY desc limit ?,?;";
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
            BaseDao.closeall(rs, ps, conn);
        }
        return list;
    }

}

