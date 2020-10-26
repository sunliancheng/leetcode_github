package LC0_200.LC50_100;

public class LC67_Add_Binary {
    public String addBinary(String a, String b) {

        if(a == null || a.isEmpty()) {
            return b;
        }
        if(b == null || b.isEmpty()) {
            return a;
        }
        if(a.length() > b.length()) {
            return add2binary(a, b);
        } else {
            return add2binary(b, a);
        }
    }

    public String add2binary(String binary1, String binary2) {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        int i = binary1.length() - 1; int j = binary2.length() - 1;
        while(i >= 0) {
            if(j >= 0) {
                if(binary1.charAt(i) - 48 + binary2.charAt(j) - 48 + flag > 1) {
                    sb.append((binary1.charAt(i) - 48 + binary2.charAt(j) - 48 + flag) % 2);
                    flag = 1;
                }
                else {
                    sb.append(binary1.charAt(i) - 48 + binary2.charAt(j) - 48 + flag);
                    flag = 0;
                }
            } else {
                if(binary1.charAt(i) - 48 + flag > 1) {
                    sb.append((binary1.charAt(i) - 48 + flag) % 2);
                    flag = 1;
                }
                else {
                    sb.append(binary1.charAt(i) - 48 + flag);
                    flag = 0;
                }
            }
            --j;
            --i;
        }
        if(flag == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
