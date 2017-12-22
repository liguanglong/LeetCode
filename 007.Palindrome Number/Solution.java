class Solution {
    public boolean isPalindrome(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return false;
        }
        long l = x;
        boolean flag = false;
        if (l < 0) {
            return false;
        }

        int temp = 0;
        String s = String.valueOf(l);

        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if(i == j)
                return true;
            if (s.charAt(i) == s.charAt(j)) {
                if(i+1==j)
                    return true;
                i++;
                j--;
            }
            else
                return false;
        }
        return false;

    }
    
}