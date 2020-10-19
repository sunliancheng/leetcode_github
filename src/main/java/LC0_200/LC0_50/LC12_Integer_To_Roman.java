package LC0_200.LC0_50;

import java.util.HashMap;

public class LC12_Integer_To_Roman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5); map.put('X', 10); map.put('L', 50);
        map.put('C', 100); map.put('D', 500); map.put('M', 1000);

        while(num > 0) {
            int flag = 0;
            if(num >= 1000)
                flag = 1000;
            else if(num >= 100)
                flag = 100;
            else if(num >= 10)
                flag = 10;
            else
                flag = 1;

            int n = num / flag;
            if(num >= 1000) {
                for(int i = 0; i < n; ++i)
                    sb.append('M');
            } else if(num >= 100 && num < 500) {
                if(num >= 400 && num < 500) {
                    sb.append("CD");
                } else {
                    for(int i = 0; i < n; ++i) {
                        sb.append('C');
                    }
                }
            } else if(num >= 500) {
                if(num >= 900 && num < 1000) {
                    sb.append("CM");
                } else {
                    sb.append('D');
                    num -= 500;
                    continue;
                }
            } else if(num >= 10 && num < 50) {
                if(num >= 40 && num < 50) {
                    sb.append("XL");
                } else {
                    for(int i = 0; i < n; ++i) {
                        sb.append('X');
                    }
                }
            } else if(num >= 50) {
                if(num >= 90 && num < 100) {
                    sb.append("XC");
                } else {
                    sb.append('L');
                    num -= 50;
                    continue;
                }
            } else if(num >= 1 && num < 5) {
                if(num >= 4 && num < 5) {
                    sb.append("IV");
                } else {
                    for(int i = 0; i < n; ++i) {
                        sb.append('I');
                    }
                }
            } else if(num >= 5) {
                if(num >= 9 && num < 10) {
                    sb.append("IX");
                } else {
                    sb.append('V');
                    num -= 5;
                    continue;
                }
            }
            num -= n * flag;
        }

        return sb.toString();
    }
}
