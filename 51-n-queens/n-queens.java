class Solution
{
    public boolean issSafe(int row,int col,int n,char[][] board)
    {
        int i,j; 
        for(j=col-1 ; j>=0 ; j--)
        {
            if(board[row][j]=='Q')
            {
                return false;
            }
        } 
        for(i=row-1,j=col-1 ; i>=0&&j>=0 ; i--,j--)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }
        for(i=row+1,j=col-1 ; i<=n-1&&j>=0 ; i++,j--)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        } 
        return true;
    }
    public void solve(int n,int col,char[][] board,List<List<String>> res)
    {//col = 0 n = 4
        if(col==n)
        {
            List<String> list = new ArrayList<>();
            for(int i=0; i<n ; i++)
            {// i = 1
                String str=""; 
                for(int j=0;j<n;j++)
                {
                    str = str+board[i][j];
                }
                list.add(str);
            } 
            res.add(new ArrayList<>(list));
            return;            
        }
        else 
        {
            for(int row=0 ; row<n ; row++)
            { //row=0 ; 0<4 
                if(issSafe(row,col,n,board)==true)
                {
                    board[row][col] = 'Q'; 
                    solve(n,col+1,board,res); 
                    board[row][col] = '.';
                }
            }
        }
    }
    public List<List<String>> solveNQueens(int n)
    { // n = 4
        List<List<String>> res = new ArrayList<>(); 
        char[][] board = new char[n][n]; 
        int i,j; 
        for(i=0 ; i<n ; i++)
        {
            for(j=0 ; j<n ; j++) 
            {
                board[i][j] = '.';
            }
        }
        solve(n,0,board,res); 
        return res;
    }
}