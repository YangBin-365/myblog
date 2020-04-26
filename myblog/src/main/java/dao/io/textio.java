package dao.io;

import java.io.*;

/**v
 * @Author: 杨斌
 * @Date: 2020/3/22 0022 9:59
 */
public class textio {
    private static String path;
    public static String readText(String filename) {
        StringBuffer sb = new StringBuffer();
        try (
                BufferedReader br=new BufferedReader(new InputStreamReader(new
                        FileInputStream(filename),"utf-8"));
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                sb.append(line);
            }
        } catch (IOException e) {

        }
        return sb.toString();
    }

    public static boolean writeText(String title,String main) {
        try {
            File writeName = new File(getPath()+"\\text\\"+title+".txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
//            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (
                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writeName),"UTF-8"))

            ) {
                out.write(main);
                out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        textio.path = path;
    }
}
