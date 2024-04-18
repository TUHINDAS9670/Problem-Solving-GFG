 static int help(int i,int j,int n,int m,int points[][],int dp[][]){
        if(i==m-1 && j==n-1)return 1-points[i][j];
        if(i==m || j==n)return Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        int a = help(i,j+1,n,m,points,dp);
        int b = help(i+1,j,n,m,points,dp);
        return dp[i][j] = Math.max(1,Math.min(a,b)-points[i][j]);
    }
    public int minPoints(int points[][], int m, int n) {
        // Your code goes here
        int dp[][] = new int[m][n];
        for(int []temp:dp)Arrays.fill(temp,-1);
	    return help(0,0,n,m,points,dp);
    }
