class Solution {
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O') dfs(board,i,0);
            if(board[i][board[0].length-1]=='O') dfs(board,i,board[0].length-1);
        }
        for(int j=0;j<board[0].length;j++){
            if(board[0][j]=='O') dfs(board,0,j);
            if(board[board.length-1][j]=='O') dfs(board,board.length-1,j);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                // if(board[i][j]=='X'){
                //     board[i][j]='';
                // }
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(char[][] board,int i,int j){
        int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
        board[i][j]='T';
        
        for(int[] d:dir){
            int r=i+d[0];
            int c=j+d[1];
            if(r<0 || c<0 || r>board.length-1 || c>board[0].length-1) continue;
            // if(board[r][c]=='O' && (r==0 || c==0 || r==board.length-1 ||c==board[0].length-1) ){
            //     continue;
            // }
            if(board[r][c]=='O'){
                dfs(board,r,c);
                // return;
            }

        }
    }
}