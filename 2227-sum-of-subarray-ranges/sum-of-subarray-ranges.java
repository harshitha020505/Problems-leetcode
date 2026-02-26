class Solution {
    public long sumSubarrayMins(int[] arr) {
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

        long sum = 0;
        int mod = 1000000007;

        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            long freq=right*left;
            sum+=freq*arr[i];
        }

        return sum;
    }
    public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> stack = new Stack<>();

        // -------- Previous Smaller (Strictly Smaller) --------
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
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
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                next[i] = n;
            } else {
                next[i] = stack.peek();
            }

            stack.push(i);
        }

        long sum = 0;
        int mod = 1000000007;

        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            long freq=right*left;
            sum +=freq*arr[i];
        }

        return sum;
    }
    public long subArrayRanges(int[] nums) {
       return sumSubarrayMaxs(nums)-sumSubarrayMins(nums);   
    }
}