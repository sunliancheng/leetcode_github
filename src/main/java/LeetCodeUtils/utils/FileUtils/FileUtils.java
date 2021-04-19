package LeetCodeUtils.utils.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class FileUtils {

    public static String packagePath = "./src/main/java/com/xxx/mp/";

    public static void writeEntity(String type) {
        // to-do

    }

    /**
     * 把java文件写入com.xxx.mp下面的某个包中
     * @param calzz
     * @param fileName
     * @param path
     */
    public static void writeJavaClass(String clazz, String fileName, String path) {
        try {
            File file = new File(packagePath + path + fileName + ".java");
            Writer writer = new FileWriter(file);
            writer.write(clazz);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 自动写入 mybatis plus 的 mapper
     * @param type class类型
     * @param fileName
     */
    public static void writeMPMapper(String type) {
        String clazz = "package com.xxx.mp.mapper;\n" +
                "\n" +
                "import com.baomidou.mybatisplus.core.mapper.BaseMapper;\n" +
                "import com.xxx.mp.entity.*;\n" +
                "\n" +
                "public interface "  + type + "Mapper extends BaseMapper<" + type + "> {\n" +
                "    \n" +
                "}\n";
        writeJavaClass(clazz, type + "Mapper", "mapper/");
    }

    /**
     * 自动生成service层
     * @param type
     */
    public static void writeService(String type) {
        StringBuilder sb = new StringBuilder();

        String mapper = type.substring(0,1).toLowerCase() + type.substring(1) + "Mapper";
        /**
         * generate package
         */
        sb.append(SBHelper.PACKAGE + SBHelper.SPACE + "com.xxx.mp.service" + SBHelper.SEMICOLON + SBHelper.NEXTLINE);
        sb.append(SBHelper.NEXTLINE);

        /**
         * generate import
         */
        sb.append("import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;\n" +
                "import com.xxx.mp.entity.*;\n" +
                "import com.xxx.mp.mapper.*;\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.stereotype.*;\n" +
                "import java.util.*; \n");

        sb.append(SBHelper.NEXTLINE + SBHelper.COMPONENT);

        /**
         * generate class name
         */
        sb.append(SBHelper.PUBLIC + SBHelper.SPACE + SBHelper.CLASS + SBHelper.SPACE + type + "Service " + SBHelper.LEFTBIGBRACKETS + SBHelper.NEXTLINE + SBHelper.NEXTLINE);

        /**
         * generate mapper
         */
        sb.append(SBHelper.getNSpaceChar(4) + SBHelper.AUTOWIRED);
        sb.append(SBHelper.getNSpaceChar(4) + SBHelper.PRIVATE + SBHelper.SPACE + type + "Mapper " + mapper + SBHelper.SEMICOLON + SBHelper.NEXTLINE + SBHelper.NEXTLINE);

        /**
         * generate select function
         */
        sb.append(geneSelectFunc("select", "List<" + type + SBHelper.BIGGER, "QueryWrapper<" + type + "> queryWrapper", mapper));

        /**
         * generate delete function
         */
        sb.append(geneDeleteFunc("delete", "int", "QueryWrapper<" + type + "> queryWrapper", mapper));

        /**
         * generate update function
         */
        sb.append(geneUpdateFunc("update", "int", type + SBHelper.SPACE + type.substring(0,1).toLowerCase() + type.substring(1) + ", QueryWrapper<" + type + "> queryWrapper", mapper));

        /**
         * generate insert function
         */
        sb.append(geneInsertFunc("insert", "int", type + SBHelper.SPACE + type.substring(0,1).toLowerCase() + type.substring(1), mapper));

        /**
         * generate final character
         */
        sb.append(SBHelper.NEXTLINE + SBHelper.RIGHTBIGBRACKETS + SBHelper.NEXTLINE);



        writeJavaClass(sb.toString(), type + "Service", "service/");
    }

    public static String geneSelectFunc(String funName, String returnType, String args, String mapper) {
        StringBuilder sb = new StringBuilder();
        sb.append(SBHelper.NEXTLINE);
        sb.append(SBHelper.getNSpaceChar(4) + SBHelper.PUBLIC + SBHelper.SPACE + returnType + SBHelper.SPACE + funName + SBHelper.LEFTSMALLBRACKETS + args + SBHelper.RIGHTSMALLBRACKETS + SBHelper.SPACE + SBHelper.LEFTBIGBRACKETS);
        sb.append(SBHelper.NEXTLINE);
        sb.append(SBHelper.getNSpaceChar(8) + SBHelper.RETURN + SBHelper.SPACE + mapper + SBHelper.POINT + "selectList(" + args.split(" ")[1] + SBHelper.RIGHTSMALLBRACKETS + SBHelper.SEMICOLON);
        sb.append(SBHelper.NEXTLINE);
        sb.append(SBHelper.getNSpaceChar(4) + SBHelper.RIGHTBIGBRACKETS + SBHelper.NEXTLINE);
        return sb.toString();
    }

    public static String geneDeleteFunc(String funName, String returnType, String args, String mapper) {
        StringBuilder sb = new StringBuilder();
        sb.append(SBHelper.NEXTLINE);
        sb.append(SBHelper.getNSpaceChar(4) + SBHelper.PUBLIC + SBHelper.SPACE + returnType + SBHelper.SPACE + funName + SBHelper.LEFTSMALLBRACKETS + args + SBHelper.RIGHTSMALLBRACKETS + SBHelper.SPACE + SBHelper.LEFTBIGBRACKETS);
        sb.append(SBHelper.NEXTLINE);
        sb.append(SBHelper.getNSpaceChar(8) + SBHelper.RETURN + SBHelper.SPACE + mapper + SBHelper.POINT + "delete(" + args.split(" ")[1] + SBHelper.RIGHTSMALLBRACKETS + SBHelper.SEMICOLON);
        sb.append(SBHelper.NEXTLINE);
        sb.append(SBHelper.getNSpaceChar(4) + SBHelper.RIGHTBIGBRACKETS + SBHelper.NEXTLINE);
        return sb.toString();
    }

    public static String geneUpdateFunc(String funName, String returnType, String args, String mapper) {
        String[] splits = args.split(",");
        StringBuilder sb = new StringBuilder();
        sb.append(SBHelper.NEXTLINE);
        sb.append(SBHelper.getNSpaceChar(4) + SBHelper.PUBLIC + SBHelper.SPACE + returnType + SBHelper.SPACE + funName + SBHelper.LEFTSMALLBRACKETS + args + SBHelper.RIGHTSMALLBRACKETS + SBHelper.SPACE + SBHelper.LEFTBIGBRACKETS);
        sb.append(SBHelper.NEXTLINE);
        sb.append(SBHelper.getNSpaceChar(8) + SBHelper.RETURN + SBHelper.SPACE + mapper + SBHelper.POINT + "update(" + splits[0].split(" ")[1] + SBHelper.COMMA + SBHelper.SPACE + splits[1].split(" ")[2] + SBHelper.RIGHTSMALLBRACKETS + SBHelper.SEMICOLON);
        sb.append(SBHelper.NEXTLINE);
        sb.append(SBHelper.getNSpaceChar(4) + SBHelper.RIGHTBIGBRACKETS + SBHelper.NEXTLINE);
        return sb.toString();
    }

    public static String geneInsertFunc(String funName, String returnType, String args, String mapper) {
        StringBuilder sb = new StringBuilder();
        sb.append(SBHelper.NEXTLINE);
        sb.append(SBHelper.getNSpaceChar(4) + SBHelper.PUBLIC + SBHelper.SPACE + returnType + SBHelper.SPACE + funName + SBHelper.LEFTSMALLBRACKETS + args + SBHelper.RIGHTSMALLBRACKETS + SBHelper.SPACE + SBHelper.LEFTBIGBRACKETS);
        sb.append(SBHelper.NEXTLINE);
        sb.append(SBHelper.getNSpaceChar(8) + SBHelper.RETURN + SBHelper.SPACE + mapper + SBHelper.POINT + "insert(" + args.split(" ")[1] + SBHelper.RIGHTSMALLBRACKETS + SBHelper.SEMICOLON);
        sb.append(SBHelper.NEXTLINE);
        sb.append(SBHelper.getNSpaceChar(4) + SBHelper.RIGHTBIGBRACKETS + SBHelper.NEXTLINE);
        return sb.toString();
    }
}