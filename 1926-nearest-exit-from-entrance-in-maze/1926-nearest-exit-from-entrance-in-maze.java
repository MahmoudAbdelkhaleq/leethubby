class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = maze.length, cols = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]]='+';
        while(!queue.isEmpty()){
            int [] state = queue.poll();
            int row = state[0];
            int col = state[1];
            int steps = state[2];
            for (int[] dir : dirs) {
                int nextRow = row + dir[0], nextCol = col + dir[1];
                if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols
                   && maze[nextRow][nextCol] == '.') {
                    if (nextRow == 0 || nextRow == rows - 1 || nextCol == 0 || nextCol == cols - 1)
                        return steps + 1;
                    maze[nextRow][nextCol] = '+';
                    queue.offer(new int[]{nextRow, nextCol, steps + 1});
                }
            }
        }
        return -1;
    }
}