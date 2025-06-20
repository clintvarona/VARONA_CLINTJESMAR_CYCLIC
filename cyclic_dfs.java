import java.util.Scanner;

public class CyclicDFS {
    private static final int MAX = 100;
    private static int[][] graph = new int[MAX][MAX];
    private static int[] visited = new int[MAX];
    private static int n;

    private static boolean dfs(int u, int parent, int[] cycle) {
        visited[u] = 1;
        for (int v = 0; v < n; v++) {
            if (graph[u][v] == 1) {
                if (visited[v] == 0) {
                    if (dfs(v, u, cycle)) {
                        return true;
                    }
                } else if (v != parent) {
                    cycle[0] = u;
                    cycle[1] = v;
                    return true;
                }
            }
        }
        return false;
    }

    private static int readIntCell(int i, int j, Scanner scanner) {
        while (true) {
            System.out.printf("Enter value for row %d column %d (0 or 1): ", i, j);
            try {
                int value = scanner.nextInt();
                if (value != 0 && value != 1) {
                    System.out.println("Invalid value! Only 0 or 1 allowed.");
                } else {
                    return value;
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        while (true) {
            try {
                n = scanner.nextInt();
                if (n <= 0 || n > MAX) {
                    System.out.printf("Invalid input! Enter a valid number between 1 and %d: ", MAX);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
        }

        System.out.println("\nEnter adjacency matrix:");
        for (int i = 0; i < n; i++) {
            System.out.printf("\n--- Row %d ---\n", i);
            for (int j = 0; j < n; j++) {
                graph[i][j] = readIntCell(i, j, scanner);
            }
        }

        for (int i = 0; i < n; i++) {
            visited[i] = 0;
        }

        boolean hasCycle = false;
        int[] cycle = new int[]{-1, -1};

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (dfs(i, -1, cycle)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        System.out.println("\n--- DFS Result ---");
        if (hasCycle) {
            System.out.printf("Cycle detected between vertices: %d and %d\n", cycle[0], cycle[1]);
        } else {
            System.out.println("No cycle found using DFS.");
        }
    }
}