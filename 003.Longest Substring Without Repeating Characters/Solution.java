//1 java�е�length�������������˵��,����˵��������һ������,��֪���������ĳ������õ���length�������.
//2 java�е�length()����������ַ���String˵��,����뿴����ַ����ĳ������õ�length()�������.
//3.java�е�size()��������Է��ͼ���˵��,����뿴��������ж��ٸ�Ԫ��,�͵��ô˷������鿴!


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
//            if(!sub.contains(aa))    //String���Դ��ķ���
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
//������������������AC��ͨ����822/823����ͨ��822��case,�����һ��ͨ��������ʾ��ʱ�����һ��case���ַ�̫���ˡ��������������������ߵ�Ŀ�ľ��ǲ�����������

//�������������AC

//˼�룻���������ظ��Ƚϣ�ÿ���ҵ��ظ����ַ��ͻ�ظտ�ʼ��ƥ���λ�õ���һ����������ƥ�䣬��������ʱ�临�Ӷ�̫�ߡ�
//���Լ�¼ÿ���ַ��ϴγ��ֵ�λ�ã���������ظ��ַ��ˣ��жϸ��ַ��ϴγ��ֵ�λ��(n1)�Ƿ������substring����ʼλ��(n2)��
//�ص�n1,n2������λ�ü��ɣ���Ϊ�ص���С�Ļ����м�϶������ظ����ַ��ˣ�����ո�ƥ�䵽���Ǹ��ظ����ַ�

//����i����substring����ʼλ�ã�����i ���Ǹ���substring����ʼλ��
//ans������Ӵ�����
//HashMap<Character, Integer> :  Character�����ÿ���ַ��������ظ����ظ��˾͸��£���Integer������ϴ�����ַ����ֵ�λ�ã����forѭ�����ֵ����ֵ���1

  Map<Character, Integer> map = new HashMap<>();
        int ans =0;
        if (s.equals("")) {
            return 0;
        }

        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
            	// ����substring����ʼλ��
              //����ֱ��i= map.get(s.charAt(j)), ps:abba�����������ƥ�䵽�ڶ���a��ʱ��
              //��ʱ��iӦ�����ڵڶ���b��λ�ã���map��a����Ӧ��value���ǵ�һ��a���ֵ�λ��,���ֱ�Ӹ�ֵ��substring�����ظ�����
                i = Math.max(map.get(s.charAt(j)), i);

            }
                ans = Math.max(ans, j - i+1);   //����substring����󳤶�
                map.put(s.charAt(j), j+1);   //���ø��ַ����һ�γ��ֵ�λ��

        }
        return ans;