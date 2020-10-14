package LC0_200.LC150_200;

/**
 * 2020-09-24 11:03 PM at Hangzhou
 * By using double pointer pointing respectively at start and end, you can quickly solve the problem
 */
public class LC167_Two_Sum2 {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int temp = numbers[low] + numbers[high];
            if (temp > target) {
                high--;
            } else if (temp < target) {
                low++;
            } else
                break;
        }
        result[0] = ++low;
        result[1] = ++high;
        return result;
    }

}
