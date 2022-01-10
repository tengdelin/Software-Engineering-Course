package cool.tdl.dao;

import cool.tdl.pojo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class housedatebase {
    //房源查找的函数
    public static ArrayList<home> selectall_home_key(String key) {
        ArrayList<home> list = new ArrayList<home>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        String sql = "";
        try {
            if (key != null) {
                sql = "select DISTINCT * from home where diqu=?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, key);
                rs = ps.executeQuery();
            } else {
                sql = "select DISTINCT * from home where diqu='洪山区';";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
            }

            while (rs.next()) {
                home u = new home(
                        rs.getString("fid"),
                        rs.getString("diqu"),
                        rs.getString("name"),
                        rs.getString("SaleStatus"),
                        rs.getString("class"),
                        rs.getString("prize"),
                        rs.getString("RongjiRate"),
                        rs.getString("greenRate"),
                        rs.getString("point")
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
    public static ArrayList<house> selectall_home_house(String key) {
        ArrayList<house> list = new ArrayList<house>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            String sql = "select * from house,home where house.name=home.name and home.fid=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                house u = new house(
                        rs.getInt("fid"),
                        rs.getString("huxin"),
                        rs.getInt("totalprize"),
                        rs.getInt("avgprize"),
                        rs.getInt("allarea"),
                        rs.getString("innerarea"),
                        rs.getString("chaoxiang"),
                        rs.getString("name"),
                        rs.getString("floor"),
                        rs.getString("allfloor"),
                        rs.getString("year"),
                        rs.getString("neixin")
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
    public static house selectall_house_key_fid(String fid) {
        house u = null;
        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            String sql = "select * from house where fid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, fid);
            rs = ps.executeQuery();

            while (rs.next()) {
                u = new house(
                        rs.getInt("fid"),
                        rs.getString("huxin"),
                        rs.getInt("totalprize"),
                        rs.getInt("avgprize"),
                        rs.getInt("allarea"),
                        rs.getString("innerarea"),
                        rs.getString("chaoxiang"),
                        rs.getString("name"),
                        rs.getString("floor"),
                        rs.getString("allfloor"),
                        rs.getString("year"),
                        rs.getString("neixin")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }
        return u;
    }
    public static ArrayList<wh_xz> selectall_wh_xz() {
        ArrayList<wh_xz> list = new ArrayList<wh_xz>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            String sql = "select * from wh_xz;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                wh_xz u = new wh_xz(
                        rs.getInt("fid"),
                        rs.getInt("id"),
                        rs.getString("country"),
                        rs.getString("name"),
                        rs.getString("enname"),
                        rs.getString("locname"),
                        rs.getString("offname"),
                        rs.getString("boundary"),
                        rs.getString("adminlevel"),
                        rs.getString("wikidata"),
                        rs.getString("wikimedia"),
                        rs.getString("timestamp"),
                        rs.getString("note"),
                        rs.getString("rpath"),
                        rs.getString("Polygon")
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
    //显示在select里面的小区
    public static ArrayList<option_home> selectall_home() {
        ArrayList<option_home> list = new ArrayList<option_home>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        String sql = "";
        try {
            sql = "SELECT DISTINCT name from house;;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();


            while (rs.next()) {
                option_home u = new option_home(
                        rs.getString("name")
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
    //显示在select里面的户型
    public static ArrayList<huxin> selectall_huxin() {
        ArrayList<huxin> list = new ArrayList<huxin>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        String sql = "";
        try {
            sql = "SELECT DISTINCT huxin from house;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                huxin u = new huxin(
                        rs.getString("huxin")
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
    //筛选房源接口
    public static ArrayList<house> selectall_house_key(int p, String f, int a, String fl) {
        ArrayList<house> list = new ArrayList<house>();
        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select * from house where totalprize<=? and huxin=? and allarea<=? and floor=? ;";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, p);
            ps.setString(2, f);
            ps.setString(3, String.valueOf(a));
            ps.setString(4, String.valueOf(fl));
            rs = ps.executeQuery();
            while (rs.next()) {
                house u = new house(
                        rs.getInt("fid"),
                        rs.getString("huxin"),
                        rs.getInt("totalprize"),
                        rs.getInt("avgprize"),
                        rs.getInt("allarea"),
                        rs.getString("innerarea"),
                        rs.getString("chaoxiang"),
                        rs.getString("name"),
                        rs.getString("floor"),
                        rs.getString("allfloor"),
                        rs.getString("year"),
                        rs.getString("neixin")
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
    //房源
    public static int admin_insert_house(house user) {
        String sql = "insert into house values(null,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {
                user.getHuxin(),
                user.getTotalprize(),
                user.getAvgprize(),
                user.getAllarea(),
                user.getInnerarea(),
                user.getChaoxiang(),
                user.getName(),
                user.getFloor(),
                user.getAllfloor(),
                user.getYear(),
                user.getNeixin()
        };
        return BaseDao.IUD(sql, params);
    }
    public static int admin_delete_house(String Key) {
        String sql = "delete from house where fid=?";
        Object[] params = {
                Key
        };
        return BaseDao.IUD(sql, params);
    }
    public static boolean admin_update_house(house user) {
        String sql = "update house set huxin=?,totalprize=?,avgprize=?,allarea=?,innerarea=?,chaoxiang=?,name=?,floor=?,allfloor=?,year=?,neixin=? where fid=? ";
        Object[] params = {
                user.getHuxin(),
                user.getTotalprize(),
                user.getAvgprize(),
                user.getAllarea(),
                user.getInnerarea(),
                user.getChaoxiang(),
                user.getName(),
                user.getFloor(),
                user.getAllfloor(),
                user.getYear(),
                user.getNeixin(),
                user.getFid()
        };
        int count = BaseDao.IUD(sql, params);
        if (count != 0) {
            return true;
        } else {
            return false;
        }
    }
    public static ArrayList<house> admin_select_house(String housename) {
        ArrayList<house> list = new ArrayList<house>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            String sql = "select * from house where name like ?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + housename + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                house u = new house(
                        rs.getInt("fid"),
                        rs.getString("huxin"),
                        rs.getInt("totalprize"),
                        rs.getInt("avgprize"),
                        rs.getInt("allarea"),
                        rs.getString("innerarea"),
                        rs.getString("chaoxiang"),
                        rs.getString("name"),
                        rs.getString("floor"),
                        rs.getString("allfloor"),
                        rs.getString("year"),
                        rs.getString("neixin")
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

    //用来翻页，计算数据的,house页面的
    public static int[] totalPage_house(int count, String keyword) {
        int arr[] = {0, 1};//总数据，总页面
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            String sql = "";
            if (keyword != null) {
                sql = "select count(*) from house where name like ?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
            } else {
                sql = "select count(*) from house;";
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

    //获得所有的house，返回一个house列表
    public static ArrayList<house> selectall_house(int cpage, int count, String keyword) {
        ArrayList<house> list = new ArrayList<house>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {

            String sql = "";
            if (keyword != null) {
                sql = "select * from house where name like ? order by fid ASC limit ?,?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setInt(2, (cpage - 1) * count);
                ps.setInt(3, count);

            } else {

                sql = "select * from house order by fid ASC limit ?,?;";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, (cpage - 1) * count);
                ps.setInt(2, count);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                house u = new house(
                        rs.getInt("fid"),
                        rs.getString("huxin"),
                        rs.getInt("totalprize"),
                        rs.getInt("avgprize"),
                        rs.getInt("allarea"),
                        rs.getString("innerarea"),
                        rs.getString("chaoxiang"),
                        rs.getString("name"),
                        rs.getString("floor"),
                        rs.getString("allfloor"),
                        rs.getString("year"),
                        rs.getString("neixin")
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

    //获得所有的house，返回一个house列表,根据小区
    public static ArrayList<house> selectall_house_homefid(int cpage, int count, String keyword, String homefid) {
        ArrayList<house> list = new ArrayList<house>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            //String sql = "select * from house,home where house.name=home.name and home.fid=?;";
            String sql = "";
            if (keyword != null) {
                sql = "select * from house where name like ? order by fid ASC limit ?,?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setInt(2, (cpage - 1) * count);
                ps.setInt(3, count);

            } else {
                count = 50;
                sql = "select * from house where house.name=? limit ?,?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, homefid);
                ps.setInt(2, (cpage - 1) * count);
                ps.setInt(3, count);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                house u = new house(
                        rs.getInt("fid"),
                        rs.getString("huxin"),
                        rs.getInt("totalprize"),
                        rs.getInt("avgprize"),
                        rs.getInt("allarea"),
                        rs.getString("innerarea"),
                        rs.getString("chaoxiang"),
                        rs.getString("name"),
                        rs.getString("floor"),
                        rs.getString("allfloor"),
                        rs.getString("year"),
                        rs.getString("neixin")
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

    //获得所有的house，返回一个house列表，根据行政区
    public static ArrayList<house> selectall_house_xz(int cpage, int count, String keyword, String homefid) {
        ArrayList<house> list = new ArrayList<house>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            //String sql = "select * from house,home where house.name=home.name and home.fid=?;";
            String sql = "";
            if (keyword != null) {
                sql = "select * from house where name like ? order by fid ASC limit ?,?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setInt(2, (cpage - 1) * count);
                ps.setInt(3, count);

            } else {
                //count=50;
                sql = "SELECT * from house,home where home.diqu=? and home.`name`=house.`name`;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, homefid);
//                ps.setInt(2, (cpage - 1) * count);
//                ps.setInt(3, count);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                house u = new house(
                        rs.getInt("fid"),
                        rs.getString("huxin"),
                        rs.getInt("totalprize"),
                        rs.getInt("avgprize"),
                        rs.getInt("allarea"),
                        rs.getString("innerarea"),
                        rs.getString("chaoxiang"),
                        rs.getString("name"),
                        rs.getString("floor"),
                        rs.getString("allfloor"),
                        rs.getString("year"),
                        rs.getString("neixin")
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

    //获得所有的house，返回一个house列表，根据总价格
    public static ArrayList<house> selectall_house_totalprize(int cpage, int count, String keyword, String prize) {
        ArrayList<house> list = new ArrayList<house>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            //String sql = "select * from house,home where house.name=home.name and home.fid=?;";
            String sql = "";
            if (keyword != null) {
                sql = "select * from house where name like ? order by fid ASC limit ?,?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setInt(2, (cpage - 1) * count);
                ps.setInt(3, count);

            } else {
                //count=50;
                sql = "SELECT * from house where totalprize> ? and totalprize<" + (Integer.valueOf(prize) + 50) + ";";
                ps = conn.prepareStatement(sql);
                ps.setString(1, prize);
//                ps.setInt(2, (cpage - 1) * count);
//                ps.setInt(3, count);
            }
            rs = ps.executeQuery();

            while (rs.next()) {
                house u = new house(
                        rs.getInt("fid"),
                        rs.getString("huxin"),
                        rs.getInt("totalprize"),
                        rs.getInt("avgprize"),
                        rs.getInt("allarea"),
                        rs.getString("innerarea"),
                        rs.getString("chaoxiang"),
                        rs.getString("name"),
                        rs.getString("floor"),
                        rs.getString("allfloor"),
                        rs.getString("year"),
                        rs.getString("neixin")
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

    //获得所有的house，返回一个house列表，根据户型
    public static ArrayList<house> selectall_house_huxin(int cpage, int count, String keyword, String huxin) {
        ArrayList<house> list = new ArrayList<house>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            //String sql = "select * from house,home where house.name=home.name and home.fid=?;";
            String sql = "";
            if (keyword != null) {
                sql = "select * from house where name like ? order by fid ASC limit ?,?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setInt(2, (cpage - 1) * count);
                ps.setInt(3, count);

            } else {
                //count=50;
                sql = "SELECT * from house where huxin=?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, huxin);
//                ps.setInt(2, (cpage - 1) * count);
//                ps.setInt(3, count);
            }
            rs = ps.executeQuery();

            while (rs.next()) {
                house u = new house(
                        rs.getInt("fid"),
                        rs.getString("huxin"),
                        rs.getInt("totalprize"),
                        rs.getInt("avgprize"),
                        rs.getInt("allarea"),
                        rs.getString("innerarea"),
                        rs.getString("chaoxiang"),
                        rs.getString("name"),
                        rs.getString("floor"),
                        rs.getString("allfloor"),
                        rs.getString("year"),
                        rs.getString("neixin")
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

    //获得所有的house，返回一个house列表，根据房屋面积
    public static ArrayList<house> selectall_house_area(int cpage, int count, String keyword, String area) {
        ArrayList<house> list = new ArrayList<house>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            //String sql = "select * from house,home where house.name=home.name and home.fid=?;";
            String sql = "";
            if (keyword != null) {
                sql = "select * from house where name like ? order by fid ASC limit ?,?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setInt(2, (cpage - 1) * count);
                ps.setInt(3, count);

            } else {
                //count=50;
                sql = "SELECT * from house where allarea > ? and allarea<" + (Integer.valueOf(area) + 50) + " ;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, area);
//                ps.setInt(2, (cpage - 1) * count);
//                ps.setInt(3, count);
            }
            rs = ps.executeQuery();

            while (rs.next()) {
                house u = new house(
                        rs.getInt("fid"),
                        rs.getString("huxin"),
                        rs.getInt("totalprize"),
                        rs.getInt("avgprize"),
                        rs.getInt("allarea"),
                        rs.getString("innerarea"),
                        rs.getString("chaoxiang"),
                        rs.getString("name"),
                        rs.getString("floor"),
                        rs.getString("allfloor"),
                        rs.getString("year"),
                        rs.getString("neixin")
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

    //count
    //行政区获取房屋数量
    public static String[] select_xzcount(String[] xzname) {
        String[] num = new String[13];
        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;

        try {
            String sql = "SELECT count(*) count from house,home where home.diqu=? and home.`name`=house.`name`;";
            for (int i = 0; i < xzname.length; i++) {
                ps = conn.prepareStatement(sql);
                ps.setString(1, xzname[i]);
                rs = ps.executeQuery();
                rs.next();
                num[i] = rs.getString("count");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }

        return num;
    }

    //获取小区名字和经纬度  SELECT fid,name,ASTEXT(POINT) FROM home_by_park where fid=?;
    public static ArrayList<home> select_home_info() {
        ArrayList<home> list = new ArrayList<home>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        String sql = "";
        try {


            sql = "select fid, name,ASTEXT(POINT) FROM home ;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                home u = new home(
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

    public static String[] select_house_home_count(ArrayList<home> hlist) {
        String[] num = new String[hlist.size()];
        //声明结果集
        ResultSet rs = null;
        Connection conn = BaseDao.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "SELECT count(*) count FROM house WHERE house.`name`=?;";
            for (int i = 0; i < hlist.size(); i++) {
                ps = conn.prepareStatement(sql);
                ps.setString(1, hlist.get(i).getName());
                rs = ps.executeQuery();
                rs.next();
                num[i] = rs.getString("count");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeall(rs, ps, conn);
        }

        return num;
    }

}
