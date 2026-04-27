class Solution {   // check bidirection ,like water pipe ,jaye to aaye bhi

    private boolean valid(int[][] grid, int row, int col, boolean[][] vis) {
        int m = grid.length, n = grid[0].length;

        if (row < 0 || col < 0 || row >= m || col >= n || vis[row][col]) {
            return false;                                                   //Boundary condition
        }  

        if (row == m - 1 && col == n - 1) return true;

        vis[row][col] = true;

        if (grid[row][col] == 1) {
            // left
            if (col - 1 >= 0 && (grid[row][col - 1] == 1 || grid[row][col - 1] == 4 || grid[row][col - 1] == 6)) {
                if (valid(grid, row, col - 1, vis)) return true;
            }
            // right
            if (col + 1 < n && (grid[row][col + 1] == 1 || grid[row][col + 1] == 3 || grid[row][col + 1] == 5)) {
                if (valid(grid, row, col + 1, vis)) return true;
            }

        } else if (grid[row][col] == 2) {
            // up
            if (row - 1 >= 0 && (grid[row - 1][col] == 2 || grid[row - 1][col] == 3 || grid[row - 1][col] == 4)) {
                if (valid(grid, row - 1, col, vis)) return true;
            }
            // down
            if (row + 1 < m && (grid[row + 1][col] == 2 || grid[row + 1][col] == 5 || grid[row + 1][col] == 6)) {
                if (valid(grid, row + 1, col, vis)) return true;
            }

        } else if (grid[row][col] == 3) {
            // left
            if (col - 1 >= 0 && (grid[row][col - 1] == 1 || grid[row][col - 1] == 4 || grid[row][col - 1] == 6)) {
                if (valid(grid, row, col - 1, vis)) return true;
            }
            // down
            if (row + 1 < m && (grid[row + 1][col] == 2 || grid[row + 1][col] == 5 || grid[row + 1][col] == 6)) {
                if (valid(grid, row + 1, col, vis)) return true;
            }

        } else if (grid[row][col] == 4) {
            // right
            if (col + 1 < n && (grid[row][col + 1] == 1 || grid[row][col + 1] == 3 || grid[row][col + 1] == 5)) {
                if (valid(grid, row, col + 1, vis)) return true;
            }
            // down
            if (row + 1 < m && (grid[row + 1][col] == 2 || grid[row + 1][col] == 5 || grid[row + 1][col] == 6)) {
                if (valid(grid, row + 1, col, vis)) return true;
            }

        } else if (grid[row][col] == 5) {
            // left
            if (col - 1 >= 0 && (grid[row][col - 1] == 1 || grid[row][col - 1] == 4 || grid[row][col - 1] == 6)) {
                if (valid(grid, row, col - 1, vis)) return true;
            }
            // up
            if (row - 1 >= 0 && (grid[row - 1][col] == 2 || grid[row - 1][col] == 3 || grid[row - 1][col] == 4)) {
                if (valid(grid, row - 1, col, vis)) return true;
            }

        } else if (grid[row][col] == 6) {
            // right
            if (col + 1 < n && (grid[row][col + 1] == 1 || grid[row][col + 1] == 3 || grid[row][col + 1] == 5)) {
                if (valid(grid, row, col + 1, vis)) return true;
            }
            // up
            if (row - 1 >= 0 && (grid[row - 1][col] == 2 || grid[row - 1][col] == 3 || grid[row - 1][col] == 4)) {
                if (valid(grid, row - 1, col, vis)) return true;
            }
        }

        return false;
    }

    public boolean hasValidPath(int[][] grid) {

        int n=grid.length ,m=grid[0].length;
        boolean[][] vis = new boolean[n][m];

        return valid(grid, 0, 0, vis);
    }
}