package LC200_400.LC250_300;

public class LC258_Add_Digits {
    public int addDigits(int num) {

        if (num < 10 && num >= 0)
            return num;
        int result = 0;
        while (true) {
            int tem = num % 10;
            result += tem;
            if (num < 10 && num >= 0)
                break;
            num = num / 10;
        }
        return addDigits(result);

    }
}
