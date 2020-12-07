package LC200_400.LC300_350;

public class LC342_Power_Of_Four {
    boolean isPowerOfFour(int num) {
        if (num == 1)
            return true;
        if ((num & 0b01010101010101010101010101010100) == num && num > 0 && (num & (num  - 1)) == 0)
            return true;
        return false;
    }
}
