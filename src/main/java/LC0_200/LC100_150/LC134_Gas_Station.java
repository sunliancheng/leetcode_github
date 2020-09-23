package LC0_200.LC100_150;

/**
 *  2020-09-23 10:07 PM at Hangzhou
 */
public class LC134_Gas_Station {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = 0, filled = 0, required = 0;
        for (int i = 0; i < gas.length; ++i) {
            filled += gas[i] - cost[i];
            if (filled < 0) {
                required += filled;
                ans = i + 1;
                filled = 0;
            }
        }
        return filled >= Math.abs(required) ? ans : -1;
    }

}
