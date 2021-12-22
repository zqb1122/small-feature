package com.h2o.small.feature.common.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class JsonUtil {

    /**
     * 读取JSON文件转换为字符串
     *
     * @param filePath
     * @return
     */
    public static String readJsonFile(String filePath) {
        String jsonStr = "";
        InputStream inputStream = JsonUtil.class.getClassLoader().getResourceAsStream(filePath);
        try {
            Reader reader = new InputStreamReader(inputStream, "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}