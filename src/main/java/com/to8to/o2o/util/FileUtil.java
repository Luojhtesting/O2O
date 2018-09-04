package com.to8to.o2o.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {

    /**
     * 读取文件内容
     * @param file
     * @return str
     */
    public static String fileReadData(File file) {
        try {
            FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
            BufferedReader bReader = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
            String s = "";
            while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
                sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
            }
            bReader.close();
            String str = sb.toString();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "读取文件失败";
        }

    }
}
