package LC0_200.LC150_200;

import org.junit.Test;

public class LC168_Excel_Sheet_Column_Title {

    @Test
    public void tsest() {
        System.out.println(cal(1));
        System.out.println(cal(701));
    }

    public String convertToTitle(int n) {
        return cal(n);
    }

    String cal(int i) {
        StringBuilder sb = new StringBuilder();
        int tem = i % 26;
        int times = i / 26;
        if (tem == 0)
            times--;
        if (times < 27) {
            if (times - 1 >= 0)
                sb.append((char) (times + 'A' - 1));
            if (tem >= 1)
                sb.append((char) (tem + 'A' - 1));
            else
                sb.append('Z');
        } else {
            sb.append(cal(times));
            if (tem >= 1)
                sb.append((char) (tem + 'A' - 1));
            else
                sb.append('Z');
        }
        return sb.toString();
    }


}
