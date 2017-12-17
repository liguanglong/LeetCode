/*
求最大长度的回文串
*/

class Solution {
    public String longestPalindrome(String s) {

        int len = 0;
        String res = "";
        //由于子串的长度可以是奇数也可以是偶数，所以要分开判断
        //例如aba是奇数，bb是偶数
        //该算法较为巧妙的地方是，将遍历字符串的指针当做是substring的尾指针，起始指针是用尾指针减去当前最大回文串的长度，如果新串还是回文串，
        //那么更新回文串和len，在判断的过程中，如果新串是回文串的话，则len增加，再次循环时虽然i也增加，但i-len是不变的（因为i和len都增加了），
        //相当于起始位置没变,尾指针在向后移动，substring的长度在增加
        //judge(s, i - len, i)比judge(s, i, i+len)的好处在于避免下标越界，所以将遍历字符串的指针当做是substring的尾指针
        for (int i = 0; i < s.length(); i++) {
            if (judge(s, i - len, i)) {
                res = s.substring(i - len, i+1);
                len = len + 1;
            }
            if (judge(s, i - len - 1, i )) {
                res = s.substring(i - len - 1, i + 1);
                len = len + 2;
            }
        }
        // System.out.print(res);
        return res;
    }
    
    
		/*
    判断substring是不是回文串
    begin是起始位置
    end是结束位置
     */
    public static boolean judge(String s, int begin, int end) {
        if (begin < 0) {
            return false;
        }
        //因为子串的长度可以是奇数或是偶数，所以要分开判断

        while (begin <= end) {
        	//子串是偶数时
            if (begin == end) {
                return true;
            }
            if (s.charAt(begin) == s.charAt(end)) {
            	//子串是奇数使时
                if (begin + 1 == end) {
                    return true;
                }
                begin++;   //起始位置加一
                end--;    //结束位置减一
            }
            else
                return false;
        }
        return false;
    }
    
}