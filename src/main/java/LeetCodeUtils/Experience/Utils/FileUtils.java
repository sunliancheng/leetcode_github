package LeetCodeUtils.Experience.Utils;

import LeetCodeUtils.Experience.annotations.Component;
import LeetCodeUtils.Experience.annotations.Sort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;


public class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    private static LinkedList<String> path = new LinkedList<>();

    public static void scanAllFiles(Map<String, Object> container) {
        //读取目录
        String filePath = "./src/main/java";
        File file = new File(filePath);
        File[] tempList = file.listFiles();
        for (File f : tempList) {
            path.addLast(f.getName());
            findFiles(f, container);
            path.removeLast();
        }
    }

    public static void findFiles(File file, Map<String, Object> container) {
        if (file.isFile()) {
            if (file.getName().contains(".java")) {
                StringBuilder className = new StringBuilder();
                for (String s : path) {
                    className.append(s);
                    className.append(".");
                }
                String name = className.substring(0, className.length() - 6);
                try {
                    Class clazz = null;
                    clazz = Class.forName(name);
                    clazz.getAnnotations();
                    String beanName = clazz.getName().substring(clazz.getName().lastIndexOf('.') + 1);
                    Annotation[] annotations = clazz.getAnnotations();
                    for (Annotation anno : annotations) {
                        compareAndDealAnnotations(anno, beanName, clazz, container);
                    }
            } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            File[] tempList = file.listFiles();
            for (File tem : tempList) {
                path.addLast(tem.getName());
                findFiles(tem, container);
                path.removeLast();
            }
        }
    }

    private static void compareAndDealAnnotations(Annotation anno, String beanName, Class clazz, Map<String, Object> container) {

        String actualName = beanName.substring(0, 1).toLowerCase() + beanName.substring(1);

        try {
            if (anno.annotationType() == Component.class) {
                container.putIfAbsent(actualName, clazz.newInstance());
            } else if (anno.annotationType() == Sort.class) {
                container.putIfAbsent(actualName, clazz.newInstance());
                Method[] declaredMethods = clazz.getDeclaredMethods();
                for (Method method : declaredMethods) {
                    if (method.getName().equals("sort")) {
                        if (SortUtils.checkSortResult(clazz, method)) {
                            logger.warn("排序成功");
                        } else {
                            logger.error("排序结果校验失败： ");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
