package LC1000_1200.LC1000_1050;

import LeetCodeUtils.Vector;
import org.junit.Test;

public class LC1041_Robot_Bounded_In_Circle {

    private double[] direction = new double[]{0, 1};
    private int[] pos = new int[]{0, 0};

    public boolean isRobotBounded(String instructions) {
        getFinalPos(instructions);
        if (((int) direction[0] == 0 && ((int) direction[1] == 1) ||  (int) direction[1] == -1)) {
            if (pos[0] == 0 && pos[1] == 0)
                return true;
            else if (direction[1] < 0)
                return true;
            else
                return false;
        } else
            return true;
    }

    public void getFinalPos(String s) {
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'G') {
                pos[0] += direction[0];
                pos[1] += direction[1];
            } else if (s.charAt(i) == 'L') {
                Vector.rotateVector(direction, -90);
            } else if (s.charAt(i) == 'R') {
                Vector.rotateVector(direction, 90);
            }
        }
    }

    @Test
    public void test() {
        System.out.println(isRobotBounded("RLLGLRRRRGGRRRGLLRRR"));
    }





}
