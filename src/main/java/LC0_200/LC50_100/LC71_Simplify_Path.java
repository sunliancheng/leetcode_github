package LC0_200.LC50_100;

import org.junit.Test;

import java.util.Stack;

public class LC71_Simplify_Path {

    @Test
    public void test() {
        //System.out.println(simplifyPath("/a//b////c/d//././/.."));
        //System.out.println(simplifyPath("/..hidden"));
        //System.out.println(simplifyPath("/a/./b/../../c"));
        //System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
    }

    public String simplifyPath(String path) {

        path = path.replaceAll("/+", "/");

        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        for (int i = 0; i < split.length; ++i) {
            if (split[i].equals("")) continue;
            if (split[i].equals(".")) continue;
            if (split[i].equals("..")) {
                if (stack.size() <= 0) continue;
                stack.pop();
            } else {
                stack.push("/" + split[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); ++i)
            sb.append(stack.get(i));
        if (sb.length() == 0) sb.append('/');
        return sb.toString();
    }


}
