package LeetCodeUtils;

import LeetCodeUtils.LeetCode.Problem;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {

    private static int count = 0;

    private static Set<Integer> set = new HashSet();

    /**
     *  find out all the files in the folder ---- "./src/main/java"
     */
    public void findAllFiles() {
        //读取目录
        String filePath = "./src/main/java";
        File file=new File(filePath);
        File[] tempList = file.listFiles();

        for (File f : tempList)
            if (f.getName().startsWith("LC"))
                findFiles(f);
    }

    public void findFiles(File file) {
        if (file.isFile()) {
            if (file.getName().startsWith("LC")) {
                count++;
                set.add(Integer.valueOf(file.getName().split("_")[0].substring(2)));
            }
        }
        else {
            File[] tempList = file.listFiles();
            for (File tem : tempList)
                findFiles(tem);
        }
    }

    /**
     *  modify the list file and then output to a new file
     */
    @Test
    public void modifyListFile() throws IOException {
        String filePath = "./src/main/java/list";
        File file = new File(filePath);
        findAllFiles();
        List<Problem> problemList = new ArrayList();

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String s = null;
            while((s = br.readLine())!=null){
                Problem problem = Problem.generate(s);
                if (set.contains(problem.getId()))
                    problem.setAnswered(true);
                problemList.add(problem);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        File outputFile =new File("./src/main/java/outputProblemsList");
        Writer out =new FileWriter(outputFile);
        for (Problem problem : problemList) {
            out.write(problem.toString());
            out.write("\n");
        }
        out.close();
        System.out.println("all number of solved problems here is : " + count);
    }

}
