package LC0_200.LC0_50;

public class LC11_Container_With_Most_Water {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0 || height.length == 1) {
            return 0;
        }
        int low = 0, high = height.length - 1;
        int max = 0;
        while (low < high) {
            if (height[low] >= height[high]) {
                max = max > (high - low) * height[high] ? max : (high - low) * height[high];
                high--;
            } else {
                max = max > (high - low) * height[low] ? max : (high - low) * height[low];
                low++;
            }
        }
        return max;
    }

}
