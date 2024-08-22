class Solution
{
    public boolean solve(char[][] board,int n,int m ,int row,int col,String word,int ind)
    {
        if(ind==word.length())
        {
            return true;
        }
        if(row==-1 ||col==-1 || row==n || col==m || board[row][col]!=word.charAt(ind) )
        {
            return false;
        }
        else
        {
           char safe = board[row][col];
            board[row][col]='*';
            boolean a=solve(board,n,m,row-1,col,word,ind+1); // 
            boolean b=solve(board,n,m,row,col-1,word,ind+1); //sol(b,4,4,0,0,w,1)=false 
            boolean c=solve(board,n,m,row+1,col,word,ind+1); //sol(b,4,4,1,1,w,1) =false  
            boolean d=solve(board,n,m,row,col+1,word,ind+1); //sol(b,4,4,0,2,w,1)  
            board[row][col]  = safe;
            return (a||b||c||d);
            
        }
    }
    public boolean exist(char[][] board, String word)
    {
        int n,m; 
        n = board.length; 
        m = board[0].length; 
        int row,col; 
        for(row=0;row<=n-1;row++)
        { //row=0; 0<=4 
            for(col=0;col<=m-1;col++)
            {//col =0; 1<=4 ;col=2 
                if(board[row][col]==word.charAt(0))
                {
                    if(solve(board,n,m,row,col,word,0)==true)
                    {
                        return true;
                    }
                }
            }
        } 
        return false;
    }
}