import java.util.LinkedList;
import java.util.Queue;

public class ZombieInMatrix {
    /*
     * Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can
     * turn adjacent (up/down/left/right) human beings into zombies every hour. Find
     * out how many hours does it take to infect all humans?
     * 
     * Example:
     * 
     * Input:
     * [[0, 1, 1, 0, 1],
     *  [0, 1, 0, 1, 0],
     *  [0, 0, 0, 0, 1],
     *  [0, 1, 0, 0, 0]]
     * 
     * Output: 2
     * 
     * Explanation: At the end of the 1st hour, the status of the grid:
     * [[1, 1, 1, 1, 1],
     *  [1, 1, 1, 1, 1],
     *  [0, 1, 0, 1, 1],
     *  [1, 1, 1, 0, 1]]
     * 
     * At the end of the 2nd hour, the status of the grid:
     * [[1, 1, 1, 1, 1],
     *  [1, 1, 1, 1, 1],
     *  [1, 1, 1, 1, 1],
     *  [1, 1, 1, 1, 1]] 
     */

    public static Integer minHours(Integer[][] grid) {
        Queue<int[]> zombieQueue = new LinkedList<>();
        int humanCount = 0;
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    humanCount++;
                } else {
                    zombieQueue.add(new int[] {i, j});
                }
            }
        }

        int hour = 0;
        while (!zombieQueue.isEmpty() && humanCount > 0) {
            int queueSize = zombieQueue.size();
            
            for (int i = 0; i < queueSize; i++) {
                int[] currentZombie = zombieQueue.poll();
                for (int[] direction : directions) {
                    int newX = currentZombie[0] + direction[0];
                    int newY = currentZombie[1] + direction[1];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 0){
                        grid[newX][newY] = 1; // turn human to zombie
                        zombieQueue.add(new int[] {newX, newY}); // mark zombie for next hour
                        humanCount--;
                    }
                }
            }
            hour++;
        }

        return hour;
    }

    
    public static void main(String[] args) {
        Integer[][] grid = {{0, 1, 1, 0, 1}, {0, 1, 0, 1, 0},{0, 0, 0, 0, 1},{0, 1, 0, 0, 0}};
        System.out.println(minHours(grid));
    }
}