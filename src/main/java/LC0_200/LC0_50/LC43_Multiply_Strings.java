package LC0_200.LC0_50;

public class LC43_Multiply_Strings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        String result = "0";
        for (int i = num1.length() - 1; i >= 0; --i) {
            StringBuilder temp = new StringBuilder(mutil(num2, num1.charAt(i))); int flag = 0;
            for (int j = num1.length() - 1; j > i; --j)
                temp.append("0");
            if (result.length() > temp.length())
                result = add(result, temp.toString());
            else
                result = add(temp.toString(), result);
        }
        return result;
    }

    public String mutil(String num, Character c) {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for (int i = num.length() - 1; i >= 0; --i) {
            int re = flag + (num.charAt(i) - '0') * (c - '0');
            if (re >= 10) {
                flag = re / 10;
                re %= 10;
            } else {
                flag = 0;
            }
            sb.append(re);
        }
        if (flag > 0)
            sb.append(flag);
        return sb.reverse().toString();

    }

    public String add(String n1, String n2) {
        StringBuilder sb = new StringBuilder();

        // assume n1 is larger than n2
        StringBuilder s1 = new StringBuilder(n1);
        StringBuilder s2 = new StringBuilder(n2);
//        if (n2.length() > n1.length()) {
//            StringBuilder tem = s2;
//            s2 = s1;
//            s1 = tem;
//        }
        s1 = s1.reverse();
        s2 = s2.reverse();
        int moreThan10 = 0;
        for (int i = 0; i < s1.length(); ++i) {

            if (i < s2.length()) {
                int re = moreThan10 + s1.charAt(i) + s2.charAt(i) - '0' - '0';
                if (re > 9) {
                    re = re - 10;
                    moreThan10 = 1;
                } else {
                    moreThan10 = 0;
                }
                sb.append(re);
            } else {
                int re = moreThan10 + s1.charAt(i) - '0';
                if (re > 9) {
                    re = re - 10;
                    moreThan10 = 1;
                } else {
                    moreThan10 = 0;
                }
                sb.append(re);
            }
        }
        if (moreThan10 == 1)
            sb.append(moreThan10);
        return sb.reverse().toString();
    }
}
