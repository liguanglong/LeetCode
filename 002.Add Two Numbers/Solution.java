/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        //此版本只针对能用double类型表示的数
        //超过double表示的范围就不行了
        //测试用例中会有很长的一段数

        //         double a =0,c=0;
        //         double b=0;
        //         int count=0;
        //         while(l1!=null){
        //             a=a+Math.pow(10,count)*l1.val;
        //             l1 = l1.next;
        //             count++;
        //         }
        //         count = 0;



        //         while(l2!=null){

        //             b=b+Math.pow(10,count)*l2.val;

        //             l2 = l2.next;

        //             count++;

        //         }

        //         c=a+b;

        //           ListNode  w1 = new ListNode(0);
        //           ListNode w2 = w1;
        //         if(c == 0){
        //             return w1;
        //         }
        //             while(c>=1){
        //             w2.next = new ListNode((int)(c%10));
        //             c=c/10;
        //               w2 = w2.next;
        //         }
        //         return w1.next;


        //此版本适合所有情况，可AC!!!
        //没采用先转换两个数，然后再相加的思想

        ListNode e = new ListNode(0);
        ListNode e2 = e;
        int a = 0,b=0,c=0 ;
        int carry=0;
        while(l1!=null || l2!=null)
        {
            // System.out.println(l1.val);
            a = (l1 ==null) ? 0:l1.val;
            b = (l2 ==null)? 0:l2.val;
            c=a+b+carry;
            if(c>=10)
            {
                c = c-10;
            }
            e2.next = new ListNode(c);
            e2=e2.next;
            c=a+b+carry;
            if(c>=10)
            {
                carry = 1;
            }
            else
            {
                carry = 0;
            }
            if(l1!=null)
            {
                l1 = l1.next;
            }
            if(l2!=null)
            {
                l2 = l2.next;
            }

        }

        if(carry == 1)
        {
            e2.next = new ListNode(carry);
            e2=e2.next;
        }
        return e.next;
    }

}