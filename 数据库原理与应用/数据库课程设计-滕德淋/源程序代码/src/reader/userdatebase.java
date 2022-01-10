package reader;

import infact.USER_TABLE;
import infact.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class userdatebase {

    //------------------------初始化插入数据函数
    public static int parkinsert(park user) {
        String str = user.getPoint();
        String sql = "insert into park values(?,?,?,?,?,?,?,?,?,GeomFromText('point(" + str + ")'))";
        Object[] params = {
                user.getFid(),
                user.getName(),
                user.getMaxclass(),
                user.getMidclass(),
                user.getMinclass(),
                user.getAddress(),
                user.getSheng(),
                user.getShi(),
                user.getQu()
        };
        return userdb.IUD(sql, params);
    }

    public static int shopinsert(shop user) {
        String str = user.getPoint();
        String sql = "insert into shop values(?,?,?,?,?,?,GeomFromText('point(" + str + ")'))";
        Object[] params = {
                user.getFid(),
                user.getName(),
                user.getMinclass(),
                user.getAddress(),
                user.getMidclass(),
                user.getMaxclass()
        };
        return userdb.IUD(sql, params);
    }

    public static int transportandroadinsert(transportandroad user) {
        String str = user.getPoint();
        String sql = "insert into transportandroad values(?,?,?,?,?,?,GeomFromText('point(" + str + ")'))";
        Object[] params = {
                user.getFid(),
                user.getName(),
                user.getMinclass(),
                user.getAddress(),
                user.getMidclass(),
                user.getMaxclass(),
        };
        return userdb.IUD(sql, params);
    }

    public static int schoolinsert(school user) {
        String str = user.getPoint();
        String sql = "insert into school values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,GeomFromText('point(" + str + ")'))";
        Object[] params = {
                user.getFid(),
                user.getName(),
                user.getMinclass(),
                user.getMidclass(),
                user.getMinclass(),
                user.getAddress(),
                user.getSheng(),
                user.getShi(),
                user.getQu(),
                user.getName1(),
                user.getXiaolei(),
                user.getAddress1(),
                user.getZhonglei(),
                user.getDalei()
        };
        return userdb.IUD(sql, params);
    }

    public static int hospitalinsert(hospital user) {
        String str = user.getPoint();
        String sql = "insert into hospital values(?,?,?,?,?,?,GeomFromText('point(" + str + ")'))";
        Object[] params = {
                user.getFid(),
                user.getName(),
                user.getMinclass(),
                user.getAddress(),
                user.getMidclass(),
                user.getMaxclass()
        };
        return userdb.IUD(sql, params);
    }

    public static int wuhan_projectinsert(wuhan_project user) {
        String str = user.getPolygon();
        String sql = "insert into wuhan_project values(?,?,?,?,GeomFromText('POLYGON((" + str + "))'))";
        Object[] params = {
                user.getFid(),
                user.getName(),
                user.getUid(),
                user.getCityName(),
        };
        return userdb.IUD(sql, params);
    }

    public static int wh_xzinsert(wh_xz user) {
        String str = user.getPolygon();
        String sql = "insert into wh_xz values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,GeomFromText('POLYGON((" + str + "))'))";
        Object[] params = {
                user.getFid(),
                user.getId(),
                user.getCountry(),
                user.getName(),
                user.getEnname(),
                user.getLocname(),
                user.getOffname(),
                user.getBoundary(),
                user.getAdminlevel(),
                user.getWikidata(),
                user.getWikimedia(),
                user.getTimestamp(),
                user.getNote(),
                user.getRpath()
        };
        return userdb.IUD(sql, params);
    }

    public static int roadinsert(road user) {
        String str = user.getRoad();
        String sql = "insert into road values(?,?,?,?,?,?,?,GeomFromText('LINESTRING(" + str + ")'))";
        Object[] params = {
                user.getFid(),
                user.getOsm_id(),
                user.getCode(),
                user.getFclass(),
                user.getName(),
                user.getBridge(),
                user.getTunnel(),
        };
        return userdb.IUD(sql, params);
    }

    public static int homeinsert(home user) {
        String str = user.getPoint();
        String sql = "insert into home values(?,?,?,?,?,?,?,?,GeomFromText('point(" + str + ")'))";
        Object[] params = {
                user.getFid(),
                user.getDiqu(),
                user.getName(),
                user.getSaleStatus(),
                user.getClass1(),
                user.getPrize(),
                user.getRongjiRate(),
                user.getGreenRate()
        };
        return userdb.IUD(sql, params);
    }


    //-------------------------用户注册函数
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
        return userdb.IUD(sql, params);
    }
    //-------------------------用户函数登录
    public static int weblogin(USER_TABLE user) {
        String sql = "select * from user where USER_ID=? and USER_PASSWORD=?;";
        Object[] params = {
                user.getUSER_ID(),
                user.getUSER_PASSWORD(),
        };
        return userdb.IUD(sql, params, 1);
    }



    //房源查找的函数
    public static ArrayList<home> selectall_home_key(String key) {
        ArrayList<home> list = new ArrayList<home>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
        PreparedStatement ps = null;

        try {
            String sql = "select * from home where diqu=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, key);
            rs = ps.executeQuery();

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
            userdb.closeall(rs, ps, conn);
        }
        return list;
    }
    public static ArrayList<house> selectall_home_house(String key) {
        ArrayList<house> list = new ArrayList<house>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
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
                        rs.getString("totalprize"),
                        rs.getString("avgprize"),
                        rs.getString("allarea"),
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
            userdb.closeall(rs, ps, conn);
        }
        return list;
    }
    public static house selectall_house_key_fid(String fid) {
        house u = null;
        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
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
                        rs.getString("totalprize"),
                        rs.getString("avgprize"),
                        rs.getString("allarea"),
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
            userdb.closeall(rs, ps, conn);
        }
        return u;
    }
    public static ArrayList<wh_xz> selectall_wh_xz() {
        ArrayList<wh_xz> list = new ArrayList<wh_xz>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
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
            userdb.closeall(rs, ps, conn);
        }
        return list;
    }


    //筛选房源接口
    public static ArrayList<house> selectall_house_key(int p, String f, int a, String fl) {
        ArrayList<house> list = new ArrayList<house>();
        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
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
                        rs.getString("totalprize"),
                        rs.getString("avgprize"),
                        rs.getString("allarea"),
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
            userdb.closeall(rs, ps, conn);
        }
        return list;
    }


    //-------------------------用户评论的函数
    public static int insert_com(com user) {
        String sql = "insert into com values(null,?,0,?)";
        Object[] params = {
                user.getCommend(),
                user.getHouse_fid()
        };
        return userdb.IUD(sql, params);
    }
    public static int insert_recom(com user) {
        String sql = "insert into com values(null,?,?,?)";
        Object[] params = {
                user.getCommend(),
                user.getParent_fid(),
                user.getHouse_fid()
        };
        return userdb.IUD(sql, params);
    }
    public static ArrayList<com> selectall_house_com(String key) {
        ArrayList<com> list = new ArrayList<com>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
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
            userdb.closeall(rs, ps, conn);
        }
        return list;
    }



    //周边
    public static ArrayList<home_by_park> selectall_park_distance(String home_fid) {
        ArrayList<home_by_park> list = new ArrayList<home_by_park>();
        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
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
            userdb.closeall(rs, ps, conn);
        }
        return list;
    }
    public static ArrayList<home_by_shop> selectall_shop_distance(String home_fid) {
        ArrayList<home_by_shop> list = new ArrayList<home_by_shop>();
        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
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
            userdb.closeall(rs, ps, conn);
        }
        return list;
    }
    public static ArrayList<home_by_school> selectall_school_distance(String home_fid) {
        ArrayList<home_by_school> list = new ArrayList<home_by_school>();
        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
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
            userdb.closeall(rs, ps, conn);
        }
        return list;
    }
    public static ArrayList<home_by_hospital> selectall_hospital_distance(String home_fid) {
        ArrayList<home_by_hospital> list = new ArrayList<home_by_hospital>();
        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
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
            userdb.closeall(rs, ps, conn);
        }
        return list;
    }
    public static ArrayList<home_by_transportandroad> selectall_transportandroad_distance(String home_fid) {
        ArrayList<home_by_transportandroad> list = new ArrayList<home_by_transportandroad>();
        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
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
            userdb.closeall(rs, ps, conn);
        }
        return list;
    }


    //-------------------------------管理员
    //房源
    public static int admin_insert_house(house user) {
        String sql = "insert into house values(?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {
                user.getFid(),
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
        return userdb.IUD(sql, params);
    }
    public static int admin_delete_house(String Key) {
        String sql = "delete from house where fid=?";
        Object[] params = {
                Key
        };
        return userdb.IUD(sql, params);
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
        int count = userdb.IUD(sql, params);
        if (count != 0) {
            return true;
        } else {
            return false;
        }
    }
    public static ArrayList<house> admin_select_house() {
        ArrayList<house> list = new ArrayList<house>();

        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
        PreparedStatement ps = null;

        try {
            String sql = "select * from house;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                house u = new house(
                        rs.getInt("fid"),
                        rs.getString("huxin"),
                        rs.getString("totalprize"),
                        rs.getString("avgprize"),
                        rs.getString("allarea"),
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
            userdb.closeall(rs, ps, conn);
        }
        return list;
    }
    //用户
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
        return userdb.IUD(sql, params);
    }
    public static int admin_delete_user(String id) {
        String sql = "delete from user where USER_ID=? and USER_STATUS=1";
        Object[] params = {
                id
        };
        return userdb.IUD(sql, params);
    }
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
        int count = userdb.IUD(sql, params);
        if (count != 0) {
            return true;
        } else {
            return false;
        }
    }
    public static USER_TABLE admin_select_user(String username) {
        USER_TABLE u = null;
        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
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
            userdb.closeall(rs, ps, conn);
        }
        return u;

    }

}

