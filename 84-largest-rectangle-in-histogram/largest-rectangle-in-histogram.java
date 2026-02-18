class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        Stack<Integer> st=new Stack<>();
        int nse=-1;
        int pse=-1;
        int element=0;
        for(int i=0;i<heights.length;i++){
           while(!st.isEmpty() && heights[st.peek()]>heights[i]){
            element=heights[st.pop()];
            nse=i;
            pse=st.isEmpty()?-1:st.peek();
            maxArea=Math.max(maxArea,element*(nse-pse-1));

           }
           st.push(i);
        }
        while(!st.isEmpty()){
            nse=heights.length;
            element=heights[st.pop()];
            pse=st.isEmpty()?-1:st.peek();
            maxArea=Math.max(maxArea,element*(nse-pse-1));


        }
        
        return maxArea;
    }
}