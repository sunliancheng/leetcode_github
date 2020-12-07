package LC0_200.LC100_150;

import LeetCodeUtils.TreeNode;

public class LC108_Convert_Sorted_Array_To_Binary_Search_Tree {

    private int i = 0;
    public TreeNode sortedArrayToBST(int[] nums) {


        return create(0, nums.length - 1, nums);
    }

    public TreeNode create(int low, int high, int[] nums){
        if(low > high) return null;

        int mid = (low + high) / 2;
        TreeNode left = create(low, mid - 1, nums);

        TreeNode node = new TreeNode(nums[i]);
        node.left = left;

        ++i;
        node.right = create(mid + 1, high, nums);
        return node;
    }
}
