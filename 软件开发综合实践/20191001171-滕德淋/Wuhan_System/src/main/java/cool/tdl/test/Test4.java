package cool.tdl.test;



public class Test4 {

    static MapSubject x0y0 = new MapSubject(25.974999999999998, 119.21166666666667,
            25.9776145157, 119.2230386554);
    static MapSubject x1y0 = new MapSubject(26.105833333333333, 119.21166666666667,
            26.1083582702, 119.2230388300);
    static MapSubject x1y1 = new MapSubject(26.105833333333333, 119.36166666666666,
            26.1087320550, 119.3731015851);
    static MapSubject x0y1 = new MapSubject(25.974999999999998, 119.36166666666666,
            25.9779880657, 119.3731014562);

    /**
     *
     * @param tGpsLat 目标gps纬度
     * @param tGpsLng 目标gps经度
     * @param realBaidu 从百度api获取的坐标
     * @return
     */
    public static MapSubject gpsToBaidu(double tGpsLat, double tGpsLng, String realBaidu) {

        System.out.println("targetGps: " + tGpsLat + "," + tGpsLng);
        System.out.println("Real targetBaidu: " + realBaidu);

        // 计算纠偏影响系数
        double param0 = (tGpsLat - x0y0.getBdLat())	* (tGpsLng - x0y0.getBdLng());
        double param1 = (x0y1.getBdLat() - tGpsLat)	* (tGpsLng - x0y1.getBdLng());
        double param2 = (x1y1.getBdLat() - tGpsLat)	* (x1y1.getBdLng() - tGpsLng);
        double param3 = (tGpsLat - x1y0.getBdLat())	* (x1y0.getBdLng() - tGpsLng);

        double tOffsetLat = x0y0.getOffsetLat() * param0 + x0y1.getOffsetLat() * param1
                + x1y1.getOffsetLat() * param2 + x1y0.getOffsetLat() * param3;
        double tOffsetLng = x0y0.getOffsetLng() * param0 + x0y1.getOffsetLng() * param1
                + x1y1.getOffsetLng() * param2 + x1y0.getOffsetLng() * param3;

        double tBdLat = tGpsLat + tOffsetLat + 0.003; //0.003 修正值.为多次测试比较后得到的一个近似的常量值
        double tBdLng = tGpsLng + tOffsetLng + 0.011; //同上

        System.out.println("Calc targetBaidu: " + tBdLat + "," + tBdLng);
        System.out.println("---------------------------");

        return new MapSubject(tGpsLat, tGpsLng, tBdLat, tBdLng);

    }

    public static class MapSubject {
        double gpsLng;	//gps经度
        double gpsLat;	//gps纬度
        double bdLng;	//百度经度
        double bdLat;	//百度纬度
        double offsetLng; //经度纠偏值 = 百度经度 - gps经度
        double offsetLat; //纬度纠偏值 = 百度纬度 - gps纬度

        public MapSubject() {
        }

        public MapSubject(double gpsLat, double gpsLng, double bdLat, double bdLng) {
            this.gpsLat = gpsLat;
            this.gpsLng = gpsLng;
            this.bdLat = bdLat;
            this.bdLng = bdLng;
            this.offsetLat = bdLat - gpsLat;
            this.offsetLng = bdLng - gpsLng;
        }

        public double getGpsLng() {
            return gpsLng;
        }

        public void setGpsLng(double gpsLng) {
            this.gpsLng = gpsLng;
        }

        public double getGpsLat() {
            return gpsLat;
        }

        public void setGpsLat(double gpsLat) {
            this.gpsLat = gpsLat;
        }

        public double getBdLng() {
            return bdLng;
        }

        public void setBdLng(double bdLng) {
            this.bdLng = bdLng;
        }

        public double getBdLat() {
            return bdLat;
        }

        public void setBdLat(double bdLat) {
            this.bdLat = bdLat;
        }

        public double getOffsetLng() {
            return offsetLng;
        }

        public void setOffsetLng(double offsetLng) {
            this.offsetLng = offsetLng;
        }

        public double getOffsetLat() {
            return offsetLat;
        }

        public void setOffsetLat(double offsetLat) {
            this.offsetLat = offsetLat;
        }
    }
    public static void main(String[] args) {

        gpsToBaidu(26.1100000000, 119.2700000000, "26.1131933362,119.2811939364");

        gpsToBaidu(26.0697361026, 119.3022537231, "26.0725808678,119.3136200409");

        gpsToBaidu(26.0481851155, 119.2573320865, "26.0513207295,119.2685508427");

        gpsToBaidu(26.0135952280, 119.2724275589, "26.0168640068,119.2836105099");

        gpsToBaidu(26.0163287437, 119.3032836914, "26.0192058631,119.3146067513");

        gpsToBaidu(26.0888307969, 119.3262434006, "26.0914428213,119.3376982627");

        gpsToBaidu(25.974999999999998, 119.21166666666667, "25.9776145157,119.2230386554");
    }

}
