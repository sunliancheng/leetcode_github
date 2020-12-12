package LeetCodeUtils.MySort;

public class MainTestSort {
    public static void main(String[] args) {
        int[] res = new int[]{4,7,5,1,0,9,3,8};
        Sort.insertionSort(res, res.length);
        for (int i : res)
            System.out.print(i);
    }
}
