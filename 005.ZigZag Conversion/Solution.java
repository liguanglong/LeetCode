/*
将一个字符串在给定的行数上进行重组，使之按左旋90度z字型顺序排列，最后再按从上到下，从左到右的顺序读取字符串就可以了
还是画个图表示吧。。。
*/
class Solution {
    public String convert(String s, int numRows) {

        //如果只是一行的话，就不用排列了
        if(numRows == 1){
            return s;
        }

        //创建一个字符型二维数组
        //numRows行s.length()列的二维数组，尽可能大点儿，不然怕不够存，遍历的时候过滤掉null即可

        Character[][] c = new Character[numRows][s.length()];
        int count = 0;
        int i =0;
        int j = 0;
        //按照左旋90度的z字形填充二维字符数组
        for (i = 0; i < s.length(); i++) {

						//填充斜线
            if (j == numRows && count < s.length()) {
                for (j = (numRows - 2); j > 0; j--) {
                    if (count < s.length()) {

                        c[j][i] = s.charAt(count);
                        count++;
                        i++;    //因为是斜线，同时改变i和j，i++,j--
                    }

                }
            }
            //填充竖线
            if (j == 0 && count < s.length()) {
                for (j = 0; j < numRows; j++) {
                    if (count < s.length()) {
                    	//由于先是按照从上到下的顺序填充二维字符数组，和平时的一行一行遍历二维数组相反，所以是c[j][i]
                        c[j][i] = s.charAt(count);
                        count++;
                    }


                }
            }
        }

        String res = new String();
				//按照一行一行的顺序读取字符拼接字符串
        for (int k = 0; k < numRows; k++) {
            for(int l = 0;l<i;l++) {
                if (c[k][l] != null) {
                    res = res + c[k][l];
                }
            }
        }
        return res;
    }
}