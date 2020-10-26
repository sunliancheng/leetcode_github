package LC0_200.LC50_100;

import java.util.LinkedList;

public class LC66_Plus_One {
    public int[] plusOne(int[] digits) {
        int flag = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = digits.length - 1; i >= 0; --i) {
            if(i == digits.length - 1) {
                if(digits[i] + 1 >= 10) {
                    flag = 1;
                    linkedList.addFirst((digits[i] + 1) % 10);
                    continue;
                }
                linkedList.addFirst(digits[i] + 1);
                continue;
            }
            if(digits[i] + flag >= 10) {
                linkedList.addFirst((digits[i] + flag) % 10);
                flag = 1;
                continue;
            } else{
                linkedList.addFirst(digits[i] + flag);
                flag = 0;
            }
        }
        if(flag == 1) {
            linkedList.addFirst(1);
        }
        int[] result = new int[linkedList.size()];
        int i = 0;
        for(int temp : linkedList){
            result[i] = temp;
            i++;
        }
        return result;
    }
}
