/*
将一个int类型反转，返回另一个int
如：123  返回321
		-123  返回-321
		1200  返回21
		超出int范围就返回0
*/

class Solution {
    public int reverse(int x) {
        

				//用long存放x
				//如果不用long存放x,如x = -2147483648,这刚好是int能表示的最小值，用int存放是没问题的
				//但执行x=x*(-1)时就出错了，因为int能表示的最大正数是2147483647，2147483648超出范围了
        long aa = x;


        if(aa<Integer.MIN_VALUE  || aa>Integer.MAX_VALUE)
            return 0;
        boolean sign = false;  //正负标志位

        if (aa < 0) {
            sign = true;

            aa = 0 - aa;
        }
        //将数值转化为字符串
        String s = String.valueOf(aa);
        String res = "";
        if(sign)
            res = "-";
        //字符串反转
        for (int i = s.length() - 1; i >= 0; i--) {
                res = res + s.charAt(i);
        }
        //如果res表示的数值太大了，Intrger.parseInt是不能转化的，要用Long.parseLong
        if(Long.parseLong(res)>Integer.MAX_VALUE || Long.parseLong(res)< Integer.MIN_VALUE)
            return 0;
        else
            return Integer.parseInt(res);
        
    }
}