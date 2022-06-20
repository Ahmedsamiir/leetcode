class Solution {
    public int uniquePathsIII(int[][] grid) {
        
           // start `x`
        int sx = 0;
        // start `y`
        int sy = 0;
        // start `zero`
        int zero = 0;
        
        // loop through grid columns
        for(int r = 0; r<grid.length; r++) {
            // loop through grid's first row
            for(int c = 0; c<grid[0].length; c++) {
                // find where the starting point is
                if(grid[r][c] == 1){
                    sx = r;
                    sy = c;
                    
                // otherwise count the zeros
                } else if(grid[r][c] == 0) zero++;
            }
        }
        
        // return from Depth First Search
        return dfs(grid, sx, sy, zero);
    }
    
    // dfs = Depth First Search
    private int dfs(int[][] grid, int x, int y, int zero) {
        // if out of bounds, return
        if( x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1){
            return 0;
        }
        
        // if end, return
        if(grid[x][y] == 2) {
            return zero == -1 ? 1 : 0;
        }
        // set current points to obstacle / something we can't go over again
        grid[x][y] = -1;
        // decrement the amount of zeros
        zero--;
        
        // recurse in all directions
        int totalPaths = dfs(grid, x+1, y,   zero) +
                         dfs(grid, x,   y+1, zero) +
                         dfs(grid, x-1, y,   zero) +
                         dfs(grid, x,   y-1, zero);
        
        // set to a path
        grid[x][y] = 0;
        // increment the amount of zeros
        zero++;
        
        // return the amount of paths
        return totalPaths;
    }
}