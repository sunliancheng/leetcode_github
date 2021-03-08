package LC0_200.LC0_50;

import java.util.HashMap;

public class LC13_Roman_To_Integer {

    public int romanToInt(String s) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1); map.put("V", 5); map.put("X", 10); map.put("L", 50);
        map.put("C", 100); map.put("D", 500); map.put("M", 1000);
        int result = 0;
        for(int i = 0; i < s.length(); ++i){

            if(s.charAt(i) == 'I' && i < s.length() - 1){
                if(s.charAt(i + 1) == 'V'){
                    result += 4;
                    ++i;
                    continue;
                } else if(s.charAt(i + 1) == 'X'){
                    result += 9;
                    ++i;
                    continue;
                }
            }
            if(s.charAt(i) == 'X' && i < s.length() - 1){
                if(s.charAt(i + 1) == 'L'){
                    result += 40;
                    ++i;
                    continue;
                } else if(s.charAt(i + 1) == 'C'){
                    result += 90;
                    ++i;
                    continue;
                }
            }
            if(s.charAt(i) == 'C' && i < s.length() - 1){
                if(s.charAt(i + 1) == 'D'){
                    result += 400;
                    ++i;
                    continue;
                } else if(s.charAt(i + 1) == 'M'){
                    result += 900;
                    ++i;
                    continue;
                }
            }
            result += map.get(String.valueOf(s.charAt(i)));
        }
        return result;
    }

}
