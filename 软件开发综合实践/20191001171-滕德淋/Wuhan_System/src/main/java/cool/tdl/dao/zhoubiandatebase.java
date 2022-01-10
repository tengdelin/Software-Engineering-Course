package cool.tdl.dao;

import cool.tdl.pojo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class zhoubiandatebase {
    //周边
    public static ArrayList<home_by_park> selectall_park_distance(String home_fid) {
        ArrayList<home_by_park> list = new ArrayList<home_by_park>();
        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            String sql = "SELECT * FROM home_by_park where home_fid=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, home_fid);
            rs = ps.executeQuery();

            while (rs.next()) {
                home_by_park u = new home_by_park(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
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

    public static ArrayList<home_by_shop> selectall_shop_distance(String home_fid) {
        ArrayList<home_by_shop> list = new ArrayList<home_by_shop>();
        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            String sql = "SELECT * FROM home_by_shop where home_fid=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, home_fid);
            rs = ps.executeQuery();

            while (rs.next()) {
                home_by_shop u = new home_by_shop(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
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

    public static ArrayList<home_by_school> selectall_school_distance(String home_fid) {
        ArrayList<home_by_school> list = new ArrayList<home_by_school>();
        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            String sql = "SELECT * FROM home_by_school where home_fid=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, home_fid);
            rs = ps.executeQuery();

            while (rs.next()) {
                home_by_school u = new home_by_school(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
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

    public static ArrayList<home_by_hospital> selectall_hospital_distance(String home_fid) {
        ArrayList<home_by_hospital> list = new ArrayList<home_by_hospital>();
        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            String sql = "SELECT * FROM home_by_hospital where home_fid=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, home_fid);
            rs = ps.executeQuery();

            while (rs.next()) {
                home_by_hospital u = new home_by_hospital(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
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

    public static ArrayList<home_by_transportandroad> selectall_transportandroad_distance(String home_fid) {
        ArrayList<home_by_transportandroad> list = new ArrayList<home_by_transportandroad>();
        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            String sql = "SELECT * FROM home_by_transportandroad where home_fid=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, home_fid);
            rs = ps.executeQuery();

            while (rs.next()) {
                home_by_transportandroad u = new home_by_transportandroad(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
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
