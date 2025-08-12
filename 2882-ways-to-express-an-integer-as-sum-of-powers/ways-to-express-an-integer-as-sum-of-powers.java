class Solution {
    private static final int mod=1_000_000_007;
    private long[][] memo;
    public int numberOfWays(int n, int x) {
        memo=new long[n+1][n+1];
        for(long[] row:memo){
            Arrays.fill(row,-1);
        } 
        return (int) dfs(n,x,1);
    }
    private long dfs(int n, int x, int curr){
        int pow=(int) Math.pow(curr,x);
        if(n==0) return 1;
        if(n<0 || pow>n) return 0;
        if(memo[n][curr]!=-1) return memo[n][curr];

        long take=dfs(n-pow,x,curr+1)%mod;
        long skip=dfs(n,x,curr+1)%mod;
        return memo[n][curr]=(take+skip)%mod;
    } 

}