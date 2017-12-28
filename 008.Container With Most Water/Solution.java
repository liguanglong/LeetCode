class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int temp = 0;
        int square = 0;
        while (i < j) {
        		//计算由两条边所围城的容器的面积，因为是存水，所以高是由最短的边决定的，长是两条线之间的距离
            temp = (height[i] < height[j] ? height[i] : height[j]) * (j - i);
            square = square > temp ? square : temp;
            //因为有木桶效应，两条边围成的桶所能存放的水的体积由最短的边决定的，移动最小的边是为了寻找面积更大的桶
            if (height[i] > height[j]) {
                j--;
            }else
            {
                i++;
            }
        }
        return square;
    }
}