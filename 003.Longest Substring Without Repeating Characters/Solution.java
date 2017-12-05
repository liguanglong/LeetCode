//1 java中的length属性是针对数组说的,比如说你声明了一个数组,想知道这个数组的长度则用到了length这个属性.
//2 java中的length()方法是针对字符串String说的,如果想看这个字符串的长度则用到length()这个方法.
//3.java中的size()方法是针对泛型集合说的,如果想看这个泛型有多少个元素,就调用此方法来查看!


public static int lengthOfLongestSubstring(String s) {
        String sub="";
        int length=0;
        int temp =0;
        if(s.equals(""))
            return 0;
        for(int i = 0;i<s.length();i++)
        {

            if(sub.equals(""))
            {
                sub = sub +s.charAt(i);
                temp=i;
                continue;
            }
            String aa = String.valueOf(s.charAt(i));

            if(judge(sub,s.charAt(i)) )
//            if(!sub.contains(aa))    //String中自带的方法
            {
                System.out.println(sub);
                sub = sub +s.charAt(i);

            }
            else
            {
                sub = "";
                i = temp;
            }

            if(length <sub.length())
            {
                length = sub.length();
            }
        }
        return length;


    }


    public static boolean judge(String s,char a)
    {
        for(int i = 0;i<s.length();i++)
        {
            if(s.charAt(i) == a)
                return false;
        }
        return true;
    }
/********************************************************************/
//上述方法是蛮力法，AC不通过，822/823，能通过822个case,但最后一个通不过，显示超时，最后一个case中字符太多了。。。。。。，估计作者的目的就是不让用蛮力法

//下面这个方法可AC

//思想；蛮力法会重复比较，每次找到重复的字符就会回刚开始的匹配的位置的下一个，再重新匹配，这样做的时间复杂度太高。
//可以记录每个字符上次出现的位置，如果出现重复字符了，判断该字符上次出现的位置(n1)是否比现在substring的起始位置(n2)大，
//回到n1,n2中最大的位置即可，因为回到最小的话，中间肯定就有重复的字符了，比如刚刚匹配到的那个重复的字符

//其中i代表substring的起始位置，更改i 就是更改substring的起始位置
//ans是最大子串长度
//HashMap<Character, Integer> :  Character存的是每个字符（不会重复，重复了就更新），Integer存的是上次这个字符出现的位置，相比for循环里的值，其值会加1

  Map<Character, Integer> map = new HashMap<>();
        int ans =0;
        if (s.equals("")) {
            return 0;
        }

        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
            	// 更新substring的起始位置
              //不能直接i= map.get(s.charAt(j)), ps:abba这种情况，当匹配到第二个a的时候，
              //此时的i应该是在第二个b的位置，而map中a所对应的value则是第一次a出现的位置,如果直接赋值，substring就有重复的了
                i = Math.max(map.get(s.charAt(j)), i);

            }
                ans = Math.max(ans, j - i+1);   //计算substring的最大长度
                map.put(s.charAt(j), j+1);   //设置该字符最后一次出现的位置

        }
        return ans;