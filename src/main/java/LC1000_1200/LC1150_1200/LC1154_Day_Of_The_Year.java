package LC1000_1200.LC1150_1200;

import java.util.*;

public class LC1154_Day_Of_The_Year {

    static Map<Integer, Integer> map = new HashMap<>();
    static {
        map.put(1, 31);
        map.put(2, 28);
        map.put(3, 31);
        map.put(4, 30);
        map.put(5, 31);
        map.put(6, 30);
        map.put(7, 31);
        map.put(8, 31);
        map.put(9, 30);
        map.put(10, 31);
        map.put(11, 30);
        map.put(12, 31);
    }
    public int dayOfYear(String date) {
        String[] splits = date.split("-");
        int year = Integer.parseInt(splits[0]);
        int month = Integer.parseInt(splits[1]);
        int day = Integer.parseInt(splits[2]);

        int sum = 0;

        if (month == 1) return day;
        else if (month == 2) return map.get(1) + day;
        for (int i = 1;i<month;i++) sum += map.get(i);
        sum += day;
        return isLeap(year) ? ++sum : sum;
    }

    public boolean isLeap(int year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

}
