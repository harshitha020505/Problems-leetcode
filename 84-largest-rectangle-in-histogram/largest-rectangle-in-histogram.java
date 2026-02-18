class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> stack = new Stack<>();

        // -------- Previous Smaller (Strictly Smaller) --------
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                prev[i] = -1;
            } else {
                prev[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        // -------- Next Smaller (Smaller or Equal) --------
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                next[i] = n;
            } else {
                next[i] = stack.peek();
            }

            stack.push(i);
        }
        int maxi=0;
        for(int i=0;i<arr.length;i++){
            maxi=Math.max(maxi,arr[i]*(next[i]-prev[i]-1));
        }
        return maxi;
    }
}