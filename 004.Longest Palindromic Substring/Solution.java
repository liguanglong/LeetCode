/*
����󳤶ȵĻ��Ĵ�
*/

class Solution {
    public String longestPalindrome(String s) {

        int len = 0;
        String res = "";
        //�����Ӵ��ĳ��ȿ���������Ҳ������ż��������Ҫ�ֿ��ж�
        //����aba��������bb��ż��
        //���㷨��Ϊ����ĵط��ǣ��������ַ�����ָ�뵱����substring��βָ�룬��ʼָ������βָ���ȥ��ǰ�����Ĵ��ĳ��ȣ�����´����ǻ��Ĵ���
        //��ô���»��Ĵ���len�����жϵĹ����У�����´��ǻ��Ĵ��Ļ�����len���ӣ��ٴ�ѭ��ʱ��ȻiҲ���ӣ���i-len�ǲ���ģ���Ϊi��len�������ˣ���
        //�൱����ʼλ��û��,βָ��������ƶ���substring�ĳ���������
        //judge(s, i - len, i)��judge(s, i, i+len)�ĺô����ڱ����±�Խ�磬���Խ������ַ�����ָ�뵱����substring��βָ��
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
    �ж�substring�ǲ��ǻ��Ĵ�
    begin����ʼλ��
    end�ǽ���λ��
     */
    public static boolean judge(String s, int begin, int end) {
        if (begin < 0) {
            return false;
        }
        //��Ϊ�Ӵ��ĳ��ȿ�������������ż��������Ҫ�ֿ��ж�

        while (begin <= end) {
        	//�Ӵ���ż��ʱ
            if (begin == end) {
                return true;
            }
            if (s.charAt(begin) == s.charAt(end)) {
            	//�Ӵ�������ʹʱ
                if (begin + 1 == end) {
                    return true;
                }
                begin++;   //��ʼλ�ü�һ
                end--;    //����λ�ü�һ
            }
            else
                return false;
        }
        return false;
    }
    
}