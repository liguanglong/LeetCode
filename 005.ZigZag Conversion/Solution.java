/*
��һ���ַ����ڸ����������Ͻ������飬ʹ֮������90��z����˳�����У�����ٰ����ϵ��£������ҵ�˳���ȡ�ַ����Ϳ�����
���ǻ���ͼ��ʾ�ɡ�����
*/
class Solution {
    public String convert(String s, int numRows) {

        //���ֻ��һ�еĻ����Ͳ���������
        if(numRows == 1){
            return s;
        }

        //����һ���ַ��Ͷ�ά����
        //numRows��s.length()�еĶ�ά���飬�����ܴ�������Ȼ�²����棬������ʱ����˵�null����

        Character[][] c = new Character[numRows][s.length()];
        int count = 0;
        int i =0;
        int j = 0;
        //��������90�ȵ�z��������ά�ַ�����
        for (i = 0; i < s.length(); i++) {

						//���б��
            if (j == numRows && count < s.length()) {
                for (j = (numRows - 2); j > 0; j--) {
                    if (count < s.length()) {

                        c[j][i] = s.charAt(count);
                        count++;
                        i++;    //��Ϊ��б�ߣ�ͬʱ�ı�i��j��i++,j--
                    }

                }
            }
            //�������
            if (j == 0 && count < s.length()) {
                for (j = 0; j < numRows; j++) {
                    if (count < s.length()) {
                    	//�������ǰ��մ��ϵ��µ�˳������ά�ַ����飬��ƽʱ��һ��һ�б�����ά�����෴��������c[j][i]
                        c[j][i] = s.charAt(count);
                        count++;
                    }


                }
            }
        }

        String res = new String();
				//����һ��һ�е�˳���ȡ�ַ�ƴ���ַ���
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