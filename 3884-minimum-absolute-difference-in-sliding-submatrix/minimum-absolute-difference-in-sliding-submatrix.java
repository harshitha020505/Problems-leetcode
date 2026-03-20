class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] arr = new int[m - k + 1][n - k + 1];

        for (int l = 0; l <= m - k; l++) {
            for (int c = 0; c <= n - k; c++) {

                List<Integer> lst = new ArrayList<>();

                for (int i = l; i < l + k; i++) {
                    for (int j = c; j < c + k; j++) {
                        lst.add(grid[i][j]);
                    }
                }

                arr[l][c] = minAbsDiff1(lst);
            }
        }

        return arr;

    }
    public int minAbsDiff1(List<Integer> lst){
       if(lst.size() <= 1) return 0;

    long mini = Long.MAX_VALUE;

    for(int i = 0; i < lst.size(); i++){
        for(int j = i + 1; j < lst.size(); j++){
            if(!lst.get(i).equals(lst.get(j))){   // ignore duplicates
                long diff = Math.abs((long)lst.get(i) - (long)lst.get(j));
                mini = Math.min(mini, diff);
            }
        }
    }

    if(mini == Long.MAX_VALUE) return 0;

    return (int)mini;
    }
}