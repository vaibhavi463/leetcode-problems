class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i=0,j=n-1;
        int maxArea = 0;
       
        while(i<j){
            int breadth=j-i;
            int length= Math.min(height[j],(height[i]));
            int area = breadth * length;
            maxArea = Math.max(maxArea, area);

            if (height[i]<height[j])
            i++;
            else
            j--;
        }
        return maxArea;
    }
}