package cool.tdl.dao;

import cool.tdl.pojo.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class comdatebase {
    //-------------------------用户评论的函数
    public static int insert_com(com user) {
        String sql = "insert into com values(null,?,0,?)";
        Object[] params = {
                user.getCommend(),
                user.getHouse_fid()
        };
        return BaseDao.IUD(sql, params);
    }
    public static int insert_recom(com user) {
        String sql = "insert into com values(null,?,?,?)";
        Object[] params = {
                user.getCommend(),
                user.getParent_fid(),
                user.getHouse_fid()
        };
        return BaseDao.IUD(sql, params);
    }
    public static ArrayList<com> selectall_house_com(String key) {
        ArrayList<com> list = new ArrayList<com>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            String sql = "select * from com where house_fid=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, key);
            rs = ps.executeQuery();

            while (rs.next()) {
                com u = new com(
                        rs.getInt("fid"),
                        rs.getString("commend"),
                        rs.getInt("parent_fid"),
                        rs.getInt("house_fid")
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
    //用来翻页，计算数据的,com页面的
    public static int[] totalPage_com(int count, String keyword) {
        int arr[] = {0, 1};//总数据，总页面
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            String sql = "";
            if (keyword != null) {
                sql = "select count(*) from com where house_fid = ?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
            } else {
                sql = "select count(*) from com;";
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
    //获得所有的评论，返回一个评论列表
    public static ArrayList<com> selectall_com(int cpage, int count, String keyword) {
        ArrayList<com> list = new ArrayList<com>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {

            String sql = "";
            if (keyword != null) {
                sql = "select * from com where house_fid= ? order by fid ASC limit ?,?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, keyword);
                ps.setInt(2, (cpage - 1) * count);
                ps.setInt(3, count);

            } else {

                sql = "select * from com order by fid ASC limit ?,?;";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, (cpage - 1) * count);
                ps.setInt(2, count);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                com u = new com(
                        rs.getInt("fid"),
                        rs.getString("commend"),
                        rs.getInt("parent_fid"),
                        rs.getInt("house_fid")
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
    //查找评论，修改评论的时候使用
    public static com selectall_com_key_fid(String fid) {
        com u = null;
        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            String sql = "select * from com where fid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, fid);
            rs = ps.executeQuery();

            while (rs.next()) {
                u = new com(
                        rs.getInt("fid"),
                        rs.getString("commend"),
                        rs.getInt("parent_fid"),
                        rs.getInt("house_fid")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }
        return u;
    }
    //更新评论
    public static boolean admin_update_com(com user) {
        String sql = "update com set commend=?,parent_fid=?,house_fid=? where fid=? ";
        Object[] params = {

                user.getCommend(),
                user.getParent_fid(),
                user.getHouse_fid(),
                user.getFid()
        };
        int count = BaseDao.IUD(sql, params);
        if (count != 0) {
            return true;
        } else {
            return false;
        }
    }
    //删除评论
    public static int admin_delete_com(String Key) {
        String sql = "delete from com where fid=?";
        Object[] params = {
                Key
        };
        return BaseDao.IUD(sql, params);
    }
}
