package LC0_200.LC0_50;

import LeetCodeUtils.ListNode;

public class LC2_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = true;
        int weight = 0;
        ListNode result = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = result;
        while (flag){

            //System.out.println("while");
            if(p1 == null && p2 == null && weight ==0){
                flag = false;
                for( p = result; p.next.next !=null; p=p.next){

                }
                p.next = null;
                //System.out.println(3);
                return result;


            }else if(p1 == null && p2 == null && weight ==1){
                p.val = weight;
                p.next = null;
                flag = false;
                return result;
            }
            else if(p1 == null){
                if( p2.val + weight>9){

                    p.val = (p2.val+weight)%10;
                    weight=1;
                }else{

                    p.val =p2.val+weight;
                    weight=0;
                }
                p2=p2.next;
                ListNode nextnode = new ListNode(0);
                p.next = nextnode;
                p=p.next;
            }else if (p2==null){

                if(p1.val+weight>9){


                    p.val = (p1.val+weight)%10;
                    weight=1;

                }else{

                    p.val =p1.val+weight;
                    weight=0;
                }
                p1=p1.next;
                ListNode nextnode = new ListNode(0);
                p.next = nextnode;
                p=p.next;
            }else{
                if(p1.val+p2.val+weight>9){

                    p.val = (p1.val+p2.val+weight)%10;
                    weight=1;
                }else{

                    p.val =p1.val+p2.val+weight;
                    weight=0;
                }
                p1=p1.next;p2=p2.next;
                ListNode nextnode = new ListNode(0);
                p.next = nextnode;
                p=p.next;
            }
        }
        return result;
    }
}
