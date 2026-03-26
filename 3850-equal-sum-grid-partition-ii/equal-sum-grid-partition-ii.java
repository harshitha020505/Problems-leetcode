class Solution {
    public boolean hasThere(HashMap<Integer,Integer> map,int[][] grid,long diff,int r1,int r2,int c1,int c2,int m,int n){
        if(diff > 100000) return false;
        if(!map.containsKey((int)diff)) return false;
        int rows=r2-r1+1;
        int cols=c2-c1+1;
       
            // for(int j=c1;j<=c2;j++){
                // if(diff==grid[i][j]){
                    if(rows>1 && cols>1){
                        return true;
                    }
                
        if(rows == 1){
            return grid[r1][c1] == diff || grid[r1][c2] == diff;
        }
        if(cols == 1){
            return grid[r1][c1] == diff || grid[r2][c1] == diff;
        }
                // }
            // }
        // }
        return false;
    }
    public boolean canPartitionGrid(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;
        long val=0;
        int v=0;
         HashMap<Integer,Integer> top = new HashMap<>();
        HashMap<Integer,Integer> bottom = new HashMap<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                val+=grid[i][j];
                bottom.put(grid[i][j], bottom.getOrDefault(grid[i][j],0)+1);
            }
        }
        long curr=0;
        long diff=0;
        long rem=0;
        
        for(int i=0;i<grid.length-1;i++){
            for(int j=0;j<grid[0].length;j++){
                v=grid[i][j];
                curr+=grid[i][j];
                top.put(v, top.getOrDefault(v,0)+1);
                bottom.put(v, bottom.get(v)-1);
                if(bottom.get(v)==0) bottom.remove(v);

            }
            rem=val-curr;
            if(curr==rem){
                return true;
            }
            diff=Math.abs(curr-rem);
            // if(diff > 100000) return false;
             if(curr>rem){
            if(hasThere(top,grid,diff,0,i,0,n-1,m,n)){
                return true;
            }
             }

             else{
                if(hasThere(bottom,grid,diff,i+1,m-1,0,n-1,m,n)){
                return true;
            }
             }
        }
          HashMap<Integer,Integer> left = new HashMap<>();
        HashMap<Integer,Integer> right = new HashMap<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                right.put(grid[i][j], right.getOrDefault(grid[i][j],0)+1);
            }
        }
        curr=0;
        diff=0;
        rem=0;
        for(int i=0;i<grid[0].length-1;i++){
            for(int j=0;j<grid.length;j++){
                v=grid[j][i];
                curr+=grid[j][i];
                 left.put(v, left.getOrDefault(v,0)+1);
                right.put(v, right.get(v)-1);
                if(right.get(v)==0) right.remove(v);
            }
            // if(curr==val-curr){
            //     return true;
            // }
            // diff=curr-(val-curr);
            
            rem=val-curr;
            if(curr==rem){
                return true;
            }
             diff=Math.abs(curr-rem);
            //  if(diff > 100000) return false;
             if(curr>rem){
            if(hasThere(left,grid,diff,0,m-1,0,i,m,n)){
                return true;
            }
             }

             else{
                if(hasThere(right,grid,diff,0,m-1,i+1,n-1,m,n)){
                return true;
            }
             }
        }
        return false;
    }
}