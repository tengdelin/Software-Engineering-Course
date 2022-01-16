package cool.tdl.Test;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/build.json";
        String jsonContent = FileUtil(filePath);
        List<Build> list = JSON.parseArray(jsonContent, Build.class);
        for (int i = 0; i < list.size(); i++) {
            List<Imglist> imglist = list.get(i).getImglist();
            for (Imglist img : imglist) {
                System.out.println(img.getUrl());
            }

//            System.out.println();
//            System.out.println(list.get(i).getTitle());

        }
    }

    public static String FileUtil(String Path) {
        BufferedReader reader = null;
        String laststr = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }
}
