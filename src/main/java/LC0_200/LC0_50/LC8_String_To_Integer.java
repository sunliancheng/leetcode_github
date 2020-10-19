package LC0_200.LC0_50;

public class LC8_String_To_Integer {

    public int myAtoi(String str) {

        // remove the first white-space character
        str = deleteFirstWS(str);

        // start with + or -, followed by as many as numerical digits
        if (str.length() == 0)
            return 0;
        int isNegative = 1;
        if (str.charAt(0) == '-') {
            isNegative = -1;
            str = str.substring(1, str.length());
        } else if (str.charAt(0) == '+') {
            str = str.substring(1, str.length());
        }

        // find out when it stop with non-numerical character
        str = findNum(str);
        //str = deleteZero(str);
        if (str.equals("null"))
            return 0;
        if (str.length() > 12)
            return isNegative == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE ;

        Long result = Long.valueOf(str) * isNegative;
        if (result > Integer.MAX_VALUE)
            result = Long.valueOf(Integer.MAX_VALUE);
        else if (result < Integer.MIN_VALUE)
            result = Long.valueOf(Integer.MIN_VALUE);

        return Integer.valueOf(String.valueOf(result));
    }

    public String findNum(String str) {
        boolean istrue = true, zeroAfter = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) > '0' && str.charAt(i) <= '9') {
                sb.append(str.charAt(i));
                istrue = false;
                zeroAfter = true;
            } else if(str.charAt(i) == '0' && (istrue || zeroAfter)) {
                istrue = false;
                sb.append(str.charAt(i));
            } else if(str.charAt(i) == '0') {
                continue;
            } else {
                break;
            }

        }
        if (sb.length() == 0)
            return sb.append("null").toString();

        return sb.toString();
    }

    public String deleteFirstWS(String str) {
        StringBuilder sb = new StringBuilder();
        int flag = 1;
        for (int i = 0; i < str.length(); ++i) {
            if ((str.charAt(i) == ' ') && flag == 1) {

            } else {
                flag = 0;
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

}
