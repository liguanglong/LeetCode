/*
��һ��int���ͷ�ת��������һ��int
�磺123  ����321
		-123  ����-321
		1200  ����21
		����int��Χ�ͷ���0
*/

class Solution {
    public int reverse(int x) {
        

				//��long���x
				//�������long���x,��x = -2147483648,��պ���int�ܱ�ʾ����Сֵ����int�����û�����
				//��ִ��x=x*(-1)ʱ�ͳ����ˣ���Ϊint�ܱ�ʾ�����������2147483647��2147483648������Χ��
        long aa = x;


        if(aa<Integer.MIN_VALUE  || aa>Integer.MAX_VALUE)
            return 0;
        boolean sign = false;  //������־λ

        if (aa < 0) {
            sign = true;

            aa = 0 - aa;
        }
        //����ֵת��Ϊ�ַ���
        String s = String.valueOf(aa);
        String res = "";
        if(sign)
            res = "-";
        //�ַ�����ת
        for (int i = s.length() - 1; i >= 0; i--) {
                res = res + s.charAt(i);
        }
        //���res��ʾ����ֵ̫���ˣ�Intrger.parseInt�ǲ���ת���ģ�Ҫ��Long.parseLong
        if(Long.parseLong(res)>Integer.MAX_VALUE || Long.parseLong(res)< Integer.MIN_VALUE)
            return 0;
        else
            return Integer.parseInt(res);
        
    }
}