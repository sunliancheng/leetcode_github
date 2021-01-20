package LeetCodeUtils.Experience.sortBean;

import LeetCodeUtils.Experience.annotations.Component;
import LeetCodeUtils.Experience.annotations.Sort;
import LeetCodeUtils.Experience.api.MySort;

@Sort
@Component("")
public class BubbleSort implements MySort {

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr.length - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tem;
                }
            }
        }
    }
}
