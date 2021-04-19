package LeetCodeUtils.utils;

import LeetCodeUtils.utils.FileUtils.FileUtils;


/**
 * 这是一个 封装 FileUtils 方法的 api 类
 */
public class FileUtilsFacade {

    public static void generateCodeFromTable() {
        FileUtils.writeEntity("User");
        FileUtils.writeMPMapper("User");
        FileUtils.writeService("User");
    }

}
