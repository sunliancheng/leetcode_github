package LeetCodeUtils.Experience.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SortUtils {

    private static final Logger logger = LoggerFactory.getLogger(SortUtils.class);

    public static Map<Integer, int[][]> sortData = new HashMap<>();

    public static boolean checkSortResult(Class clazz, Method sortfunc) throws Exception {
        init();
        for (int i = 0; i < sortData.size(); ++i) {
            sortfunc.invoke(clazz.newInstance(), sortData.get(i)[0]);
            for (int j = 0; j < sortData.get(i)[0].length; ++j) {
                if (sortData.get(i)[0][j] != sortData.get(i)[1][j]) {
                    logger.error("sort error");
                    return false;
                }
            }
        }
        return true;
    }

    public static void init() {
        sortData.put(0, new int[][]{{3,2,1,5,6,2}, {1,2,2,3,5,6}});
        sortData.put(1, new int[][]{{-1,2,3,5,1,2}, {-1,1,2,2,3,5}});
        sortData.put(2, new int[][]{{1,2,3}, {1,2,3}});
    }
}
