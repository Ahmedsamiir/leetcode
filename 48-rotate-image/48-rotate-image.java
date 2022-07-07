class Solution {
    public void rotate(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        // Reverse top to down
        for (int i = 0; i < rows / 2; i++) {
            for (int j = 0; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[rows-i-1][j];
                matrix[rows-i-1][j] = temp;
            }
        }
        // Swap the symmetry
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}