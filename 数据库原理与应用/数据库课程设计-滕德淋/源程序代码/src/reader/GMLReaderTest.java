package reader;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class GMLReaderTest {
    public static void main(String[] args) {
        //导入数据函数
//        inserthome();
//        insertpark();
//        insertshop();
//        inserttransportandroad();
//        insertschool();
//        inserthospital();
//        insertwuhan_project();
//        insertwh_xz();
//        insertroad();
    }


    /**
     * 读取Excel的内容，第一维数组存储的是一行中格列的值，二维数组存储的是多少个行
     *
     * @param file       读取数据的源Excel
     * @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @return 读出的Excel中数据的内容
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String[][] getData(File file, int ignoreRows) throws FileNotFoundException, IOException {
        List<String[]> result = new ArrayList<String[]>();
        int rowSize = 0;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        // 打开HSSFWorkbook
        POIFSFileSystem fs = new POIFSFileSystem(in);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFCell cell = null;
        for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
            HSSFSheet st = wb.getSheetAt(sheetIndex);
            // 第一行为标题，不取
            for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {
                HSSFRow row = st.getRow(rowIndex);
                if (row == null) {
                    continue;
                }
                int tempRowSize = row.getLastCellNum() + 1;
                if (tempRowSize > rowSize) {
                    rowSize = tempRowSize;
                }
                String[] values = new String[rowSize];
                Arrays.fill(values, "");
                boolean hasValue = false;
                for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
                    String value = "";
                    cell = row.getCell(columnIndex);
                    if (cell != null) {
                        // 注意：一定要设成这个，否则可能会出现乱码
                        cell.setEncoding(HSSFCell.ENCODING_UTF_16);
                        switch (cell.getCellType()) {
                            case HSSFCell.CELL_TYPE_STRING:
                                value = cell.getStringCellValue();
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                    Date date = cell.getDateCellValue();
                                    if (date != null) {
                                        value = new SimpleDateFormat("yyyy-MM-dd").format(date);
                                    } else {
                                        value = "";
                                    }
                                } else {
                                    value = String.valueOf(cell.getNumericCellValue());
                                    //value = new DecimalFormat("0").format(cell.getNumericCellValue());
                                }
                                break;
                            case HSSFCell.CELL_TYPE_FORMULA:
                                // 导入时如果为公式生成的数据则无值
                                if (!cell.getStringCellValue().equals("")) {
                                    value = cell.getStringCellValue();
                                } else {
                                    value = cell.getNumericCellValue() + "";
                                }
                                break;
                            case HSSFCell.CELL_TYPE_BLANK:
                                break;
                            case HSSFCell.CELL_TYPE_ERROR:
                                value = "";
                                break;
                            case HSSFCell.CELL_TYPE_BOOLEAN:
                                value = (cell.getBooleanCellValue() ? "Y" : "N");
                                break;
                            default:
                                value = "";
                        }
                    }
                    if (columnIndex == 0 && value.trim().equals("")) {
                        break;
                    }
                    values[columnIndex] = rightTrim(value);
                    hasValue = true;
                }
                if (hasValue) {
                    result.add(values);
                }
            }
        }
        in.close();
        String[][] returnArray = new String[result.size()][rowSize];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = (String[]) result.get(i);
        }
        return returnArray;
    }
    /***
     * 读Excel单元格的时候，有空格情况，进行删除空格信息
     * @param str
     * @return
     */
    public static String rightTrim(String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i) != 0x20) {
                break;
            }
            length--;
        }
        return str.substring(0, length);
    }
    /***
     * 插入home数据，从Excel中导入数据，返回的是一个二维数组
     */
    public static void inserthome() {
        File file = new File("C:\\Users\\滕德淋\\Desktop\\数据库原理与应用实习数据\\04-链家数据_武汉小区-实习.xls");
        String[][] result = new String[0][];
        try {
            result = getData(file, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fid = "";
        String diqu = "";
        String name = "";
        String SaleStaus = "";
        String class1 = "";
        String greenRate = "";
        String prize = "";
        String RongjiRate = "";
        String Point = "";
        for (int i = 0; i < result.length; i++) {
            fid = result[i][0];
            diqu = result[i][3];
            name = result[i][4];
            SaleStaus = result[i][5];
            class1 = result[i][6];
            prize = result[i][7];
            RongjiRate = result[i][8];
            greenRate = result[i][9];
            Point = result[i][1] + " " + result[i][2];
            home h = new home(fid, diqu, name, SaleStaus, class1, prize, RongjiRate, greenRate, Point);
            int count = userdatebase.homeinsert(h);
            if (count == 1) {
                System.out.println("插入数据成功！");
            } else {
                System.out.println("插入数据失败！");
            }
        }

//        for (String[] strings : result) {
//            for (String string : strings) {
//                System.out.print(string + "\t\t");
//            }
//            System.out.println();
//        }
    }
    /***
     * 插入公园数据，其中跳过了经纬度的单属性
     */
    public static void insertpark() {
        GMLReader reader = null;
        Record s = null;
        reader = new GMLReader("C:\\Users\\滕德淋\\Desktop\\数据库原理与应用实习数据\\01-武汉 POI - 筛选\\公园.gml");
        try {
            s = reader.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Feature> list = s.getFeatures();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> l = new ArrayList<>();
            for (int j = 0; j < list.get(i).getAttributes().size(); j++) {
                String temp = list.get(i).getAttributes().get(j).getValue();
                l.add(temp);
            }
            String str = list.get(i).getGeometry();
            str = str.replaceAll(",", " ");
            l.add(str);

            int fid = Integer.parseInt(l.get(0));
            String name = l.get(1);
            String maxclass = l.get(2);
            String midclass = l.get(3);
            String minclass = l.get(4);
            String address = l.get(5);
            String sheng = l.get(6);
            String shi = l.get(7);
            String qu = l.get(8);
            //9,10是经纬度
            String point = l.get(11);

            park p = new park(fid, name, maxclass, midclass, minclass, address, sheng, shi, qu, point);
            int count = userdatebase.parkinsert(p);
            if (count == 1) {
                System.out.println("插入数据成功！");
            } else {
                System.out.println("插入数据失败！");
            }
        }
    }
    /***
     * 插入购物中心，其中数据量很大，需要手动回收内存，但是很慢
     */
    public static void insertshop() {
        GMLReader reader = null;
        Record s = null;
        reader = new GMLReader("C:\\Users\\滕德淋\\Desktop\\数据库原理与应用实习数据\\01-武汉 POI - 筛选\\购物.gml");
        try {
            s = reader.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Feature> list = s.getFeatures();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> l = new ArrayList<>();
            for (int j = 0; j < list.get(i).getAttributes().size(); j++) {
                String temp = list.get(i).getAttributes().get(j).getValue();
                l.add(temp);
            }
            String str = list.get(i).getGeometry();
            str = str.replaceAll(",", " ");
            l.add(str);

            int fid = Integer.parseInt(l.get(0));
            String name = l.get(1);
            String minclass = l.get(2);
            String address = l.get(3);
            String midclass = l.get(4);
            String maxclass = l.get(5);
            String point = l.get(6);

            shop s1 = new shop(fid, name, minclass, address, midclass, maxclass, point);
            int count = userdatebase.shopinsert(s1);
            //                Thread.sleep(1);
            if (count == 1) {
                System.out.println(i);
            } else {
                System.out.println("插入数据失败！");
            }

        }
    }
    /***
     * 插入交通道路数据，
     */
    public static void inserttransportandroad() {
        GMLReader reader = null;
        Record s = null;
        reader = new GMLReader("C:\\Users\\滕德淋\\Desktop\\数据库原理与应用实习数据\\01-武汉 POI - 筛选\\交通与道路设施用地.gml");
        try {
            s = reader.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Feature> list = s.getFeatures();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> l = new ArrayList<>();
            for (int j = 0; j < list.get(i).getAttributes().size(); j++) {
                String temp = list.get(i).getAttributes().get(j).getValue();
                l.add(temp);
            }
            String str = list.get(i).getGeometry();
            str = str.replaceAll(",", " ");
            l.add(str);
//            String jindu0 = "";
//            String weidu0 = "";
//            boolean flag = true;
//            for (int k = 0; k < str.length(); k++) {
//                if (str.charAt(k) == ',') {
//                    flag = false;
//                    continue;
//                }
//                if (flag == true) {
//                    jindu0 += str.charAt(k);
//                } else {
//                    weidu0 += str.charAt(k);
//                }
//            }
//            l.add(jindu0);
//            l.add(weidu0);

            int fid = Integer.parseInt(l.get(0));
            String name = l.get(1);
            String minclass = l.get(2);
            String address = l.get(3);
            String midclass = l.get(4);
            String maxclass = l.get(5);
            String point = l.get(6);

            transportandroad r = new transportandroad(fid, name, minclass, address, midclass, maxclass, point);
            int count = userdatebase.transportandroadinsert(r);
            //                Thread.sleep(1);
            if (count == 1) {
                System.out.println(i);
            } else {
                System.out.println("插入数据失败！");
            }
        }
    }
    /***
     * 插入学校数据，其中因为数据给的很错误，所以很多空值
     */
    public static void insertschool() {
        GMLReader reader = null;
        Record s = null;
        reader = new GMLReader("C:\\Users\\滕德淋\\Desktop\\数据库原理与应用实习数据\\01-武汉 POI - 筛选\\学校教育类.gml");
        try {
            s = reader.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Feature> list = s.getFeatures();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> l = new ArrayList<>();
            for (int j = 0; j < list.get(i).getAttributes().size(); j++) {
                if (j == 9 || j == 10) {
                    continue;
                }
                String temp = list.get(i).getAttributes().get(j).getValue();
                l.add(temp);
            }
            String str = list.get(i).getGeometry();
            str = str.replaceAll(",", " ");
            l.add(str);
//            String jindu0 = "";
//            String weidu0 = "";
//            boolean flag = true;
//            for (int k = 0; k < str.length(); k++) {
//                if (str.charAt(k) == ',') {
//                    flag = false;
//                    continue;
//                }
//                if (flag == true) {
//                    jindu0 += str.charAt(k);
//                } else {
//                    weidu0 += str.charAt(k);
//                }
//            }
//            l.add(jindu0);
//            l.add(weidu0);

            int fid = Integer.parseInt(l.get(0));
            String name = l.get(1);
            String maxclass = l.get(2);
            String midclass = l.get(3);
            String minclass = l.get(4);
            String address = l.get(5);
            String sheng = l.get(6);
            String shi = l.get(7);
            String qu = l.get(8);
            String name1 = l.get(9);
            String xiaolei = l.get(10);
            String address1 = l.get(11);
            String zhonglei = l.get(12);
            String dalei = l.get(13);
            String point = l.get(14);


            school r = new school(fid, name, maxclass, midclass, minclass, address, sheng, shi, qu, name1, xiaolei, address1, zhonglei, dalei, point);
            int count = userdatebase.schoolinsert(r);
            //                Thread.sleep(1);
            if (count == 1) {
                System.out.println(i);
            } else {
                System.out.println("插入数据失败！");
            }
        }
    }
    /***
     * 插入医院信息
     */
    public static void inserthospital() {
        GMLReader reader = null;
        Record s = null;
        reader = new GMLReader("C:\\Users\\滕德淋\\Desktop\\数据库原理与应用实习数据\\01-武汉 POI - 筛选\\医院.gml");
        try {
            s = reader.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Feature> list = s.getFeatures();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> l = new ArrayList<>();
            for (int j = 0; j < list.get(i).getAttributes().size(); j++) {
                String temp = list.get(i).getAttributes().get(j).getValue();
                l.add(temp);
            }
            String str = list.get(i).getGeometry();
            str = str.replaceAll(",", " ");
            l.add(str);
//            String jindu0 = "";
//            String weidu0 = "";
//            boolean flag = true;
//            for (int k = 0; k < str.length(); k++) {
//                if (str.charAt(k) == ',') {
//                    flag = false;
//                    continue;
//                }
//                if (flag == true) {
//                    jindu0 += str.charAt(k);
//                } else {
//                    weidu0 += str.charAt(k);
//                }
//            }
//            l.add(jindu0);
//            l.add(weidu0);

            int fid = Integer.parseInt(l.get(0));
            String name = l.get(1);
            String minclass = l.get(2);
            String address = l.get(3);
            String midclass = l.get(4);
            String maxclass = l.get(5);
            String point = l.get(6);


            hospital s1 = new hospital(fid, name, minclass, address, midclass, maxclass, point);
            int count = userdatebase.hospitalinsert(s1);
            //                Thread.sleep(1);
            if (count == 1) {
                System.out.println(i);
            } else {
                System.out.println("插入数据失败！");
            }
        }
    }
    /***
     * 插入小区区信息，其中str的逗号和空格需要进行转换之后才能插入
     */
    public static void insertwuhan_project() {
        GMLReader reader = null;
        Record s = null;
        reader = new GMLReader("C:\\Users\\滕德淋\\Desktop\\数据库原理与应用实习数据\\02-武汉市18年小区边界1\\wuhan_project.gml");
        try {
            s = reader.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Feature> list = s.getFeatures();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> l = new ArrayList<>();
            for (int j = 0; j < list.get(i).getAttributes().size(); j++) {
                String temp = list.get(i).getAttributes().get(j).getValue();
                l.add(temp);
            }
            String str = list.get(i).getGeometry();
            //String temp="";
            str = str.replaceAll(" ", "T");
            str = str.replaceAll(",", " ");
            str = str.replaceAll("T", ",");

            l.add(str);

            int fid = Integer.parseInt(l.get(0));
            String name = l.get(1);
            String Uid = l.get(2);
            String CityName = l.get(3);
            String Polygon = l.get(4);


            wuhan_project s1 = new wuhan_project(fid, name, Uid, CityName, Polygon);
            int count = userdatebase.wuhan_projectinsert(s1);
            //                Thread.sleep(1);
            if (count == 1) {
                System.out.println(i);
            } else {
                System.out.println("插入数据失败！");
            }
        }
    }
    /***
     * 插入行政区信息
     */
    public static void insertwh_xz() {
        GMLReader reader = null;
        Record s = null;
        reader = new GMLReader("C:\\Users\\滕德淋\\Desktop\\数据库原理与应用实习数据\\03-武汉行政区\\wh_xz.gml");
        try {
            s = reader.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Feature> list = s.getFeatures();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> l = new ArrayList<>();
            for (int j = 0; j < list.get(i).getAttributes().size(); j++) {
                String temp = list.get(i).getAttributes().get(j).getValue();
                l.add(temp);
            }
            String str = list.get(i).getGeometry();
            //String temp="";
            str = str.replaceAll(" ", "T");
            str = str.replaceAll(",", " ");
            str = str.replaceAll("T", ",");
            l.add(str);

            int fid = Integer.parseInt(l.get(0));
            int id = Integer.parseInt(l.get(1));
            String country = l.get(2);
            String name = l.get(3);
            String enname = l.get(4);
            String locname = l.get(5);
            String offname = l.get(6);
            String boundary = l.get(7);
            String adminlevel = l.get(8);
            String wikidata = l.get(9);
            String wikimedia = l.get(10);
            String timestamp = l.get(11);
            String note = l.get(12);
            String rpath = l.get(13);
            String Polygon = l.get(14);


            wh_xz s1 = new wh_xz(fid, id, country, name, enname, locname, offname, boundary, adminlevel, wikidata, wikimedia, timestamp, note, rpath, Polygon);
            int count = userdatebase.wh_xzinsert(s1);
            //                Thread.sleep(1);
            if (count == 1) {
                System.out.println(i);
            } else {
                System.out.println("插入数据失败！");
            }
        }
    }
    /***
     * 插入道路数据
     */
    public static void insertroad() {
        GMLReader reader = null;
        Record s = null;
        reader = new GMLReader("C:\\Users\\滕德淋\\Desktop\\数据库原理与应用实习数据\\05-道路数据\\road.gml");
        try {
            s = reader.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Feature> list = s.getFeatures();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> l = new ArrayList<>();
            for (int j = 0; j < list.get(i).getAttributes().size(); j++) {
                String temp = list.get(i).getAttributes().get(j).getValue();
                l.add(temp);
            }
            String str = list.get(i).getGeometry();
            //String temp="";
            str = str.replaceAll(" ", "T");
            str = str.replaceAll(",", " ");
            str = str.replaceAll("T", ",");
            l.add(str);

            int fid = Integer.parseInt(l.get(0));
            String osm_id = l.get(1);
            String code = l.get(2);
            String fclass = l.get(3);
            String name = l.get(4);
            String bridge = l.get(5);
            String tunnel = l.get(6);
            String road = l.get(7);


            road s1 = new road(fid, osm_id, code, fclass, name, bridge, tunnel, road);
            int count = userdatebase.roadinsert(s1);
            //                Thread.sleep(1);
            if (count == 1) {
                System.out.println(i);
            } else {
                System.out.println("插入数据失败！");
            }
        }
    }

}
