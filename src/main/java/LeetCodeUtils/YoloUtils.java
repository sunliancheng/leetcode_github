package LeetCodeUtils;

import LeetCodeUtils.LeetCode.Problem;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class YoloUtils {

    public static void main(String[] args) throws IOException {

        String filePath = "./src/main/java/out.txt";
        File file = new File(filePath);

        File outputFile =new File("./src/main/java/target.txt");
        Writer out =new FileWriter(outputFile);

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String s = null;
            while((s = br.readLine())!=null){
                if (s.contains("avg"))
                    out.write(s + "\n");
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        out.close();

    }
}
