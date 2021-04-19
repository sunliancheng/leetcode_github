package LeetCodeUtils.utils.FileUtils;

public class SBHelper {

    public static String PACKAGE = "package";

    public static char POINT = '.';

    public static String CLASS = "class";

    public static String RETURN = "return";

    public static String LEFTBIGBRACKETS = "{";

    public static String RIGHTBIGBRACKETS = "}";

    public static String LEFTSMALLBRACKETS = "(";

    public static String RIGHTSMALLBRACKETS = ")";

    public static char SPACE = ' ';

    public static char COMMA = ',';

    public static String SEMICOLON = ";";

    public static String IMPORT = "import ";

    public static char NEXTLINE = '\n';

    public static String AUTOWIRED = "@Autowired\n";

    public static String SERVICE = "@Service\n";

    public static String COMPONENT = "@Component\n";

    public static String PUBLIC = "public";

    public static String PRIVATE = "private";

    public static String STRING = "String";

    public static String INTEGER = "Integer";

    public static String LIST = "List";

    public static char SMALLER = '<';

    public static char BIGGER = '>';

    public static String getNSpaceChar(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; ++i) sb.append(" ");
        return sb.toString();
    }
}
