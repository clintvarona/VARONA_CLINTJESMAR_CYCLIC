import java.util.Scanner;

public class CyclicBFS {
    private static final int MAX = 100;
    private static int[][] graph = new int[MAX][MAX];
    private static int[] parent = new int[MAX];
    private static int n;

    private static int find(int i) {
        while (parent[i] != -1) {
            i = parent[i];
        }
        return i;
    }

    private static boolean unionSet(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) {
            return false;
        }
        parent[pu] = pv;
        return true;
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
                scanner.next();
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
            parent[i] = -1;
        }

        boolean hasCycle = false;
        int u = -1, v = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 1) {
                    if (!unionSet(i, j)) {
                        hasCycle = true;
                        u = i;
                        v = j;
                        break;
                    }
                }
            }
            if (hasCycle) {
                break;
            }
        }

        System.out.println("\n--- BFS (Union-Find) Result ---");
        if (hasCycle) {
            System.out.printf("Cycle detected between vertices: %d and %d\n", u, v);
        } else {
            System.out.println("No cycle found using BFS.");
        }
    }
}