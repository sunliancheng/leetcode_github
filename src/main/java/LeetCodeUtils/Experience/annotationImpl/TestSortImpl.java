package LeetCodeUtils.Experience.annotationImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class TestSortImpl {

    public static Object getClass(String className) {
        Object obj = null;

        try {
            Class clazz = Class.forName(className);
            Constructor con = clazz.getConstructor();
            // 必须要有无参构造器
            obj = con.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
            for (Annotation ano : declaredAnnotations) {
                System.out.println(ano);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }
}
