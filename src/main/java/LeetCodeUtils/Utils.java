package LeetCodeUtils;

import LeetCodeUtils.LeetCode.Problem;
import org.junit.Test;


import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Utils {

    private static long count = 0;

    private static Set<Integer> set = new HashSet();
    private static List<Problem> proList = new ArrayList<>();
    /**
     *  find out all the files in the folder ---- "./src/main/java"
     */
    public void findAllFiles(String fileP) {
        //读取目录
        String filePath = fileP == null ? "./src/main/java" : fileP;
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
                //System.out.println(file.getName());
                set.add(Integer.valueOf(file.getName().split("_")[0].substring(2)));
                StringBuilder sb = new StringBuilder();
                String[] ss = file.getName().split("_");
                for (int i = 1; i < ss.length; ++i) {
                    sb.append(ss[i]);
                    if (i != ss.length - 1)
                        sb.append(" ");
                }
                Problem problem = new Problem();
                problem.setId(Integer.valueOf(ss[0].substring(2)));
                problem.setName(sb.toString().substring(0, sb.length() - 5));
                proList.add(problem);
            }
        }
        else {
            File[] tempList = file.listFiles();
            for (File tem : tempList)
                findFiles(tem);
        }
    }

    public void findFiles2(File file) {
        if (file.isFile()) {
            if (true) {
                try{
                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                    String s = null;
                    while((s = br.readLine())!=null){
                        count++;
                    }
                    br.close();
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        }
        else {
            File[] tempList = file.listFiles();
            for (File tem : tempList)
                findFiles2(tem);
        }
    }

    /**
     *  modify the list file and then output to a new file
     */
    @Test
    public void modifyListFile() throws IOException {
        String filePath = "./src/main/java";
        File file = new File(filePath);
        findAllFiles(null);
        List<Problem> problemList = new ArrayList();
        File outputFile =new File("./src/main/java/outputProblemsList.md");
        Writer out =new FileWriter(outputFile);
        int i = 0;

        Collections.sort(proList, new MyComparator());
        out.write("| 序号 | 题目  |\n" +
                "| :-----| :---- |\n");

        for (Problem problem : proList) {
            out.write("|" + problem.getId() + "|" + problem.getName() + "|");
            out.write("\n");
        }
        out.close();
        System.out.println("all number of solved problems here is : " + count);
    }

    @Test
    public void ttt() throws IOException {
        String filePath = "/Users/wangsimin/Desktop/leetcode_github/src/main/java";
        File file = new File(filePath);
        //读取目录
        findFiles2(file);

        System.out.println(count);
    }

    public class MyComparator implements Comparator<Problem> {

        @Override
        public int compare(Problem o1, Problem o2) {
            return o1.getId() > o2.getId() ? 1 : o1.getId() == o2.getId() ? 0 : -1;
        }
    }

    /**
     * make a plan for this year's leetcode submission
     * calculate the daily task
     */
    @Test
    public void testtt() {
        int current = 200, target = 450;
        int dis = target - current;

        String starTime = "2020-10-19";
        String endTime =  "2020-12-31";
        int i = - MyDate.caculateTotalTime(starTime, endTime);
        //System.out.println(dis / Double.valueOf(i));
        double per = (3 * 5 + 2 * 5) / 7.0;
        System.out.println(i + " " + dis / per);
    }
}
