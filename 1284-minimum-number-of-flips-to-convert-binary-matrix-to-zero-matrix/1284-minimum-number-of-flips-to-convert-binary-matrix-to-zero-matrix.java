class Solution {
    
     private int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    private int[] dp;   //dp[i]: the minimum flips needed transitioning from state i to             state 0
    private boolean[] seen;
    public int minFlips(int[][] mat) {
        
        
        int m = mat.length, n = mat[0].length, ans = Integer.MAX_VALUE;
        dp = new int[1 << (m * n)];
        seen = new boolean[1 << (m * n)];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
      
        return dfs(mat);
    }
    
    private int dfs(int[][] mat) {
        int state = getState(mat);
        if(seen[state]) {
            return -1;
        }
        if(dp[state] < Integer.MAX_VALUE) {
            return dp[state];
        }   
        seen[state] = true;
        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                flipAt(mat, i, j);
                int currMin = dfs(mat);
                if(currMin >= 0) {
                    minCost = Math.min(minCost, currMin);
                }
                flipAt(mat, i, j);
            }
        }
        dp[state] = (minCost == Integer.MAX_VALUE ? -1 : minCost + 1);
        seen[state] = false;        
        return dp[state];        
    }
    
    private void flipAt(int[][] mat, int x, int y) {
        mat[x][y] = (mat[x][y] == 0 ? 1 : 0);
        for(int dir = 0; dir < 4; dir++) {
            int x1 = x + dx[dir];
            int y1 = y + dy[dir];
            if(x1 >= 0 && x1 < mat.length && y1 >= 0 && y1 < mat[0].length) {
                mat[x1][y1] = (mat[x1][y1] == 0 ? 1 : 0);
            }
        }
    }
    private int getState(int[][] mat) {
        int state = 0, cnt = 0;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                state = (state | (mat[i][j] << cnt));
                cnt++;
            }
        }
        return state;
        
    }
}