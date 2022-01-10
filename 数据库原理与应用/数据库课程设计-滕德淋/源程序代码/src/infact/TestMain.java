package infact;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import reader.*;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {
    static String username = "";
    static String password = "";

    public static void main(String[] args) {
        //1、-----------------------------------------登录注册模块
        boolean loginflag = false;
        boolean regflag = false;
        Scanner scanner = new Scanner(System.in);
        String cmd = "";
        while (!loginflag) {
            System.out.println("----------------------房源查找系统------------------------");
            System.out.println("1、登录");
            //注册之后就不显示注册了
            if (!regflag) {
                System.out.println("2、注册");
            }
            cmd = scanner.nextLine();
            //防止注册之后再输入2进行注册
            if (cmd.equals("2") && regflag == true) {
                System.out.println("请选择登录！");
                continue;
            }
            switch (cmd) {
                case "1":
                    if (user_login()) {
                        System.out.println("登录成功！");
                        loginflag = true;
                    } else {
                        System.out.println("登录失败");
                    }
                    break;
                case "2":
                    if (uesr_register()) {
                        System.out.println("注册成功");
                        regflag = true;
                    } else {
                        System.out.println("注册失败");
                    }
                    break;
                default:
                    System.out.println("请选择登录或注册！");
                    break;
            }
        }

        //2、-----------------------------------------查找房源模块
        Scanner scanner1 = new Scanner(System.in);
        String cmd1 = "";
        while (true) {
            System.out.println("------------------房源查找系统欢迎您！------------------");
            System.out.println("1、查看房源");
            System.out.println("2、筛选房源");
            System.out.println("3、查看个人信息");
            System.out.println("4、修改个人信息");
            System.out.println("5、退出系统");
            cmd1 = scanner1.nextLine();
            switch (cmd1) {
                case "1":
                    System.out.println("请问您要在哪个区买房呀？");
                    //如果输出行政区成功，则进入选择行政区
                    if (select_wh_xz()) {
                        String selected_xz = scanner1.nextLine();
                        //选择了行政区，进行输出行政区中的小区，输出成功，则进入选择
                        if (select_home_Key(selected_xz)) {
                            boolean selected_home_flag = true;//用来结束选择小区循环
                            while (selected_home_flag) {
                                System.out.println("请选择小区：");
                                String selected_home = scanner1.nextLine();
                                System.out.println("1、查看小区房源");
                                System.out.println("2、查看小区周边");
                                System.out.println("3、返回");
                                String s = scanner1.nextLine();
                                switch (s) {
                                    case "1":
                                        if (select_home_house(selected_home)) {
                                            System.out.println("以上是" + selected_home + "小区的所有房源信息");
                                            boolean selected_house_flag = true;//用来结束选择小区循环
                                            while (selected_house_flag) {
                                                System.out.println("请选择房源：");
                                                String selected_house = scanner1.next();
                                                if (selected_house.equals("q")) {
                                                    selected_house_flag = false;
                                                    break;
                                                }
                                                if (select_fid_house(selected_house)) {//根据小区的fid查找该小区的房源
                                                    select_house_com(selected_house);
                                                    System.out.println("房源详细信息如上");
                                                    System.out.println("请评论：");
                                                    Scanner scanner2 = new Scanner(System.in);
                                                    String com = scanner2.nextLine();
                                                    if (com.equals("q")) {
                                                        break;
                                                    }
                                                    insert_com(com, selected_house);
                                                    //管理员回复评论
                                                    String com_fid = scanner2.nextLine();
                                                    String recom = scanner2.nextLine();
                                                    insert_recom(com_fid, recom, selected_house);
                                                    //
                                                } else {
                                                    System.out.println("没有这套房！");
                                                }
                                            }
                                        } else {
                                            System.out.println("请选择正确的房源");
                                        }
                                        break;

                                    case "2"://查看小区周边
                                        boolean selected_zhoubian_flag = true;//用来结束查找周边循环
                                        while (selected_zhoubian_flag) {
                                            System.out.println("1、公园");
                                            System.out.println("2、购物中心");
                                            System.out.println("3、学校");
                                            System.out.println("4、医院");
                                            System.out.println("5、交通");
                                            System.out.println("6、返回");
                                            String selected_zhoubian = scanner1.nextLine();
                                            switch (selected_zhoubian) {
                                                case "1":
                                                    select_park(selected_home);
                                                    break;
                                                case "2":
                                                    select_shop(selected_home);
                                                    break;
                                                case "3":
                                                    select_school(selected_home);
                                                    break;
                                                case "4":
                                                    select_hospital(selected_home);
                                                    break;
                                                case "5":
                                                    select_transportandroad(selected_home);
                                                    break;
                                                case "6":
                                                    selected_zhoubian_flag = false;
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }
                                        break;
                                    case "3"://返回
                                        selected_home_flag = false;
                                        break;
                                    default:
                                        break;
                                }
                            }//查询小区成功
                        } else {
                            System.out.println(selected_xz + "的小区信息查询失败");
                        }
                    } else {
                        System.out.println("行政区查询失败");
                    }
                    break;
                case "2":
                    int arr_prize[] = {50, 100, 150, 200, 9999};
                    String arr_fangxin[] = {"1室1厅1卫", "2室1厅1卫", "3室1厅1卫", "2室2厅1卫", "其他"};
                    int arr_area[] = {50, 100, 150, 500, 9999};
                    String arr_floor[] = {"低楼层", "中楼层", "低楼层","",""};
                    System.out.println("价格: 1:50以下  2:50-100  3:100-150  4:150-200  5:200以上  0：不选择");
                    System.out.println("房型: 1:1室1厅1卫  2:2室1厅1卫  3:3室1厅1卫  4：2室2厅1卫  5：其他  0：不选择");
                    System.out.println("面积: 1:50以下  2:50-100  3:100-150  4:150-200  5:200以上  0：不选择");
                    System.out.println("楼层: 1:5以下  2:6-10  3:11-15  4:16-20  5:20以上  0：不选择");
                    System.out.println("请依次输入：");
                    int selected_prize = scanner1.nextInt();
                    int selected_fangxin = scanner1.nextInt();
                    int selected_area = scanner1.nextInt();
                    int selected_floor = scanner1.nextInt();
                    int selected[] = {selected_prize, selected_fangxin, selected_area, selected_floor};
                    if (select_keyValue_house(selected, arr_prize, arr_fangxin, arr_area, arr_floor)) {
                        boolean selected_house_flag = true;//用来结束选择小区循环
                        while (selected_house_flag) {
                            System.out.println("请选择房源：");
                            String selected_house = scanner1.next();
                            if (selected_house.equals("q")) {
                                selected_house_flag = false;
                                break;
                            }
                            if (select_fid_house(selected_house)) {
                                System.out.println("房源详细信息如上");
                            } else {
                                System.out.println("没有这套房！");
                            }
                        }
                    }
                    break;
                case "3":
                    USER_TABLE user_table = select_Myself_info(username, password);
                    System.out.println("用户名\t真实姓名\t密码\t\t性别\t\t出生日期\t\t邮箱\t\t\t电话\t\t地址\t\t权限");
                    System.out.print(user_table.getUSER_ID() + "\t\t");
                    System.out.print(user_table.getUSER_NAME() + "\t\t");
                    System.out.print(user_table.getUSER_PASSWORD() + "\t\t");
                    System.out.print(user_table.getUSER_SEX() + "\t\t");
                    System.out.print(user_table.getUSER_BIRTHDAY() + "\t");
                    System.out.print(user_table.getUSER_EMAIL() + "\t\t");
                    System.out.print(user_table.getUSER_MOBILE() + "\t");
                    System.out.print(user_table.getUSER_ADDRESS() + "\t");
                    System.out.print(user_table.getUSER_STATUS() + "\t");
                    System.out.println();
                    break;
                case "4":
                    System.out.print("修改真实姓名：");
                    String name = scanner1.nextLine();
                    System.out.print("修改密码：");
                    String password1 = scanner1.nextLine();
                    System.out.print("修改性别：");
                    String sex = scanner1.nextLine();
                    System.out.print("修改生日：");
                    String birthday = scanner1.nextLine();
                    System.out.print("修改电子邮箱：");
                    String email = scanner1.nextLine();
                    System.out.print("修改电话：");
                    String phone = scanner1.nextLine();
                    System.out.print("修改地址：");
                    String address = scanner1.nextLine();
                    //创建实例化对象
                    USER_TABLE user = new USER_TABLE(username, name, password1, sex, birthday, null, email, phone, address, 1);
                    if (update_Myself_info(user)) {
                        password = password1;//必须修改密码，不然再查个人信息就会出错
                        System.out.println("修改成功！");
                    } else {
                        System.out.println("修改失败！");
                    }
                    break;
                case "5":
                    System.out.println("欢迎下次光临！");
                    System.exit(1);
                    break;
                default:
                    System.out.println("请输入正确的选择");
                    break;
            }
        }

    }




    //登录注册
    /***
     * 用户注册函数，需要按照规定的规则进行注册，否则注册失败，其中生日的格式为 YYYY-MM-DD
     * @return
     */
    public static boolean uesr_register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("用户名：");
        String username = scanner.nextLine();
        System.out.print("真实姓名：");
        String name = scanner.nextLine();
        System.out.print("密码：");
        String password = scanner.nextLine();
        System.out.print("重复密码：");
        String repassword = scanner.nextLine();
        System.out.print("性别：");
        String sex = scanner.nextLine();
        System.out.print("生日：");
        String birthday = scanner.nextLine();
        System.out.print("电子邮箱：");
        String email = scanner.nextLine();
        System.out.print("电话：");
        String phone = scanner.nextLine();
        System.out.print("地址：");
        String address = scanner.nextLine();

        //创建实例化对象
        USER_TABLE user = new USER_TABLE(username, name, password, sex, birthday, null, email, phone, address, 1);
        int count = userdatebase.insert(user);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }
    /***
     * 用户登录函数，只需要输入用户名和密码即可
     * @return
     */
    public static boolean user_login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("用户名：");
        username = scanner.nextLine();
        System.out.print("密码：");
        password = scanner.nextLine();

        USER_TABLE user = new USER_TABLE(username, password);//初始化对象
        int count = userdatebase.weblogin(user);//查找对象
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }









    //查房源
    /***
     * 查看所有的小区信息，就是所有行政区的都输出
     * @return
     */
//    public static boolean select_home() {
//        ArrayList<home> arrayList = userdatebase.selectall_home();
//        System.out.println("fid\t\t地区\t\t小区名\t\t销售状态\t\t类型\t\t价格\t\t容积率\t\t绿化率\t\t");
//        int i = 0;
//        for (i = 0; i < arrayList.size(); i++) {
//            System.out.print(arrayList.get(i).getFid() + "\t\t");
//            System.out.print(arrayList.get(i).getDiqu() + "\t\t");
//            System.out.print(arrayList.get(i).getName() + "\t\t");
//            System.out.print(arrayList.get(i).getSaleStatus() + "\t\t");
//            System.out.print(arrayList.get(i).getClass1() + "\t\t");
//            System.out.print(arrayList.get(i).getPrize() + "\t\t");
//            System.out.print(arrayList.get(i).getRongjiRate() + "\t\t");
//            System.out.print(arrayList.get(i).getGreenRate() + "\t\t");
//            // System.out.print(arrayList.get(i).getPoint()+"\t");
//            System.out.println();
//        }
//        System.out.println("一共有" + i + "条数据");
//        return true;
//    }
    /***
     * 根据用户筛选过后的条件查询房源(存在问题，当没有勾选的选择还没处理)
     * @param selected
     * @param arr_prize
     * @param arr_fangxin
     * @param arr_area
     * @param arr_floor
     * @return
     */
    public static boolean select_keyValue_house(int selected[], int arr_prize[], String arr_fangxin[], int arr_area[], String arr_floor[]) {
        ArrayList<String> s = new ArrayList<>();
        int p = 0;
        int a = 0;
        String fl = "";
        String f = "";
        if (selected[0] != 0) {
            p = arr_prize[selected[0] - 1];
        }
        if (selected[1] != 0) {
            f = arr_fangxin[selected[1] - 1];
        }
        if (selected[2] != 0) {
            a = arr_area[selected[2] - 1];
        }
        if (selected[3] != 0) {
            fl = arr_floor[selected[3] - 1];
        }
//        System.out.println(p + " " + f + " " + a + " " + fl);//测试输出
        ArrayList<house> arrayList = userdatebase.selectall_house_key(p, f, a, fl);
        int i = 0;
        for (i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i).getFid() + "  ");
            System.out.print(arrayList.get(i).getHuxin() + "  ");
            System.out.print(arrayList.get(i).getTotalprize() + "  ");
            System.out.print(arrayList.get(i).getAvgprize() + "  ");
            System.out.print(arrayList.get(i).getAllarea() + "  ");
            System.out.print(arrayList.get(i).getInnerarea() + "  ");
            System.out.print(arrayList.get(i).getChaoxiang() + "  ");
            System.out.print(arrayList.get(i).getName() + "  ");
            System.out.print(arrayList.get(i).getFloor() + "  ");
            System.out.print(arrayList.get(i).getAllfloor() + "  ");
            System.out.print(arrayList.get(i).getYear() + "  ");
            System.out.print(arrayList.get(i).getNeixin() + "  ");
            System.out.println();
        }
        System.out.println("一共有" + i + "条数据");
        if (arrayList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    /***
     * 根据用户输入的fid进行查询房源，这里有一个问题就是，当用户筛选了之后，需要用其他的函数进行筛选
     * @param fid
     * @return
     */
    public static boolean select_fid_house(String fid) {
        house h = userdatebase.selectall_house_key_fid(fid);
        if (h == null) {
            return false;
        }
        System.out.print(h.getFid() + "  ");
        System.out.print(h.getHuxin() + "  ");
        System.out.print(h.getTotalprize() + "  ");
        System.out.print(h.getAvgprize() + "  ");
        System.out.print(h.getAllarea() + "  ");
        System.out.print(h.getInnerarea() + "  ");
        System.out.print(h.getChaoxiang() + "  ");
        System.out.print(h.getName() + "  ");
        System.out.print(h.getFloor() + "  ");
        System.out.print(h.getAllfloor() + "  ");
        System.out.print(h.getYear() + "  ");
        System.out.print(h.getNeixin() + "  ");
        System.out.println();

        if (String.valueOf(h.getFid()).equals(fid)) {
            return true;
        } else {
            return false;
        }
    }
    /***
     * 查找武汉行政区有多少个，并显示出来
     * @return
     */
    public static boolean select_wh_xz() {
        ArrayList<wh_xz> arrayList = userdatebase.selectall_wh_xz();
        if (arrayList == null) {
            return false;
        }
        System.out.println("行政区");
        int i = 0;
        for (i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).getLocname());
        }
        System.out.println("一共有" + i + "个行政区");
        if (arrayList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    /***
     * 用户输入输出的行政区，进行选择行政区中的小区信息
     * @param key
     * @return
     */
    public static boolean select_home_Key(String key) {
        ArrayList<home> arrayList = userdatebase.selectall_home_key(key);
        if (arrayList == null) {
            return false;
        }
        System.out.println("fid\t\t地区\t\t小区名\t\t销售状态\t\t类型\t\t价格\t\t容积率\t\t绿化率\t\t");
        int i = 0;
        for (i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i).getFid() + "\t\t");
            System.out.print(arrayList.get(i).getDiqu() + "\t\t");
            System.out.print(arrayList.get(i).getName() + "\t\t");
            System.out.print(arrayList.get(i).getSaleStatus() + "\t\t");
            System.out.print(arrayList.get(i).getClass1() + "\t\t");
            System.out.print(arrayList.get(i).getPrize() + "\t\t");
            System.out.print(arrayList.get(i).getRongjiRate() + "\t\t");
            System.out.print(arrayList.get(i).getGreenRate() + "\t\t");
            // System.out.print(arrayList.get(i).getPoint()+"\t");
            System.out.println();
        }
        System.out.println("一共有" + i + "条数据");
        if (arrayList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    /***
     * 查找小区里面的房源，根据小区的名字相同进行连接，然后小区的fid用来确定小区
     * @param selected_home
     * @return
     */
    public static boolean select_home_house(String selected_home) {
        ArrayList<house> arrayList = userdatebase.selectall_home_house(selected_home);
        if (arrayList == null) {
            return false;
        }
        int i = 0;
        for (i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i).getFid() + "  ");
            System.out.print(arrayList.get(i).getHuxin() + "  ");
            System.out.print(arrayList.get(i).getTotalprize() + "  ");
            System.out.print(arrayList.get(i).getAvgprize() + "  ");
            System.out.print(arrayList.get(i).getAllarea() + "  ");
            System.out.print(arrayList.get(i).getInnerarea() + "  ");
            System.out.print(arrayList.get(i).getChaoxiang() + "  ");
            System.out.print(arrayList.get(i).getName() + "  ");
            System.out.print(arrayList.get(i).getFloor() + "  ");
            System.out.print(arrayList.get(i).getAllfloor() + "  ");
            System.out.print(arrayList.get(i).getYear() + "  ");
            System.out.print(arrayList.get(i).getNeixin() + "  ");
            System.out.println();
        }
        System.out.println("一共有" + i + "条数据");
        if (arrayList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }



    //查找小区周边 公园 医院 学校 交通 购物中心
    public static boolean select_park(String home_fid) {
        ArrayList<home_by_park> arrayList = userdatebase.selectall_park_distance(home_fid);
        if (arrayList == null) {
            return false;
        }
        int i = 0;
        for (i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i).getHome_fid()+ "\t\t");
            System.out.print(arrayList.get(i).getPark_name() + "\t\t");
            System.out.print(arrayList.get(i).getPoint() + "\t\t");
            System.out.println();
        }
        System.out.println("一共有" + i + "条数据");
        if (arrayList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean select_shop(String home_fid) {
        ArrayList<home_by_shop> arrayList = userdatebase.selectall_shop_distance(home_fid);
        if (arrayList == null) {
            return false;
        }
        int i = 0;
        for (i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i).getHome_fid()+ "\t\t");
            System.out.print(arrayList.get(i).getShop_name() + "\t\t");
            System.out.print(arrayList.get(i).getPoint() + "\t\t");
            System.out.println();
        }
        System.out.println("一共有" + i + "条数据");
        if (arrayList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean select_school(String home_fid) {
        ArrayList<home_by_school> arrayList = userdatebase.selectall_school_distance(home_fid);
        if (arrayList == null) {
            return false;
        }
        int i = 0;
        for (i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i).getHome_fid()+ "\t\t");
            System.out.print(arrayList.get(i).getSchool_name() + "\t\t");
            System.out.print(arrayList.get(i).getPoint() + "\t\t");
            System.out.println();
        }
        System.out.println("一共有" + i + "条数据");
        if (arrayList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean select_hospital(String home_fid) {
        ArrayList<home_by_hospital> arrayList = userdatebase.selectall_hospital_distance(home_fid);
        if (arrayList == null) {
            return false;
        }
        int i = 0;
        for (i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i).getHome_fid()+ "\t\t");
            System.out.print(arrayList.get(i).getHospital_name() + "\t\t");
            System.out.print(arrayList.get(i).getPoint() + "\t\t");
            System.out.println();
        }
        System.out.println("一共有" + i + "条数据");
        if (arrayList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean select_transportandroad(String home_fid) {
        ArrayList<home_by_transportandroad> arrayList = userdatebase.selectall_transportandroad_distance(home_fid);
        if (arrayList == null) {
            return false;
        }
        int i = 0;
        for (i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i).getHome_fid()+ "\t\t");
            System.out.print(arrayList.get(i).getTransportandroad_name() + "\t\t");
            System.out.print(arrayList.get(i).getPoint() + "\t\t");
            System.out.println();
        }
        System.out.println("一共有" + i + "条数据");
        if (arrayList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }






    //评论
    /***
     * 用户评论，提供评论和房源的fid，由于是用户评论的所以没有父亲fid，只有当管理员回复是才有父亲fid
     * @param com
     * @param house_fid
     * @return
     */
    public static boolean insert_com(String com, String house_fid) {

        //创建实例化对象
        com c = new com(0, com, 0, Integer.valueOf(house_fid));
        int count = userdatebase.insert_com(c);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }
    /***
     * 查找房源的评论，提供房源的fid，输出评论
     * @param house_fid
     * @return
     */
    public static boolean select_house_com(String house_fid) {
        ArrayList<com> arrayList = userdatebase.selectall_house_com(house_fid);
        if (arrayList == null) {
            return false;
        }
        int i = 0;
        int count=0;
        for (i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getParent_fid() == 0) {
                System.out.println(arrayList.get(i).getFid() + ": " + arrayList.get(i).getCommend());
                count++;
            }
        }
        System.out.println("一共有" + count + "条评论");
        if (arrayList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    /***
     * 管理员看到有评论，可以对其进行回复，需要选择到该评论的fid，然后回复内容，然后房源fid
     * @param com_fid
     * @param recom
     * @param house_fid
     * @return
     */
    public static boolean insert_recom(String com_fid, String recom, String house_fid) {

        //创建实例化对象
        com c = new com(0, recom, Integer.valueOf(com_fid), Integer.valueOf(house_fid));
        int count = userdatebase.insert_recom(c);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }





    //个人信息
    /***
     * 查找用户自己的信息,根据用户名和密码
     * @param username
     * @param password
     * @return 返回用户对象
     */
    public static USER_TABLE select_Myself_info(String username, String password) {
        USER_TABLE u = null;
        //声明结果集
        ResultSet rs = null;
        Connection conn = userdb.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "select m.*,DATE_FORMAT(m.user_birthday,'%Y-%m-%d')birthday from user m where USER_ID=? and USER_PASSWORD=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
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
    /***
     * 修改用户信息，根据用户的id，然后传入一个用户对象，id必须在数据库中存在，然后再进行更新操作
     * @param user
     * @return 返回是否修改成功
     */
    public static boolean update_Myself_info(USER_TABLE user) {
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

}
