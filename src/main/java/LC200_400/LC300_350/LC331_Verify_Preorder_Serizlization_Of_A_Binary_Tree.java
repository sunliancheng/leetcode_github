package LC200_400.LC300_350;

import org.junit.Test;

import java.util.Stack;

public class LC331_Verify_Preorder_Serizlization_Of_A_Binary_Tree {

    @Test
    public void test() {
        System.out.println(isValidSerialization("9,#"));
    }

    public boolean isValidSerialization(String preorder) {
        String[] split = preorder.split(",");
        dfs(split);
        System.out.println(idx == split.length - 1);
        System.out.println(split[idx].equals("#"));
        return idx == split.length - 1 && split[idx].equals("#");
    }

    int idx = 0;

    private void dfs(String[] preOrder) {
        if (idx >= preOrder.length - 1 || preOrder[idx].equals("#")) return;
        for (int i = 0; i < 2; ++i) {
            idx++;
            dfs(preOrder);
        }
    }

}
