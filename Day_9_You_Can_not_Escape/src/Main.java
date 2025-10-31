import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

class coordinates {
    int x;
    int y;
    public coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) {
        Path fileName = Path.of("Day_9_You_Can_not_Escape/src/hyperskill-dataset.txt");

        try {
            // Reading from file
            String content = Files.readString(fileName).trim();
            String[] lines = content.split("\n");
            char[][] map = new char[lines.length][];
            for (int i = 0; i < lines.length; i++) {
                map[i] = lines[i].toCharArray();
            }

            // Save coordinates and map size
            coordinates start = null, end = null;
            int rows = map.length;
            int cols = map[0].length;

            // Finding the entry (P) and exit (G)
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (map[i][j] == 'P') start = new coordinates(i, j);
                    if (map[i][j] == 'G') end = new coordinates(i, j);
                }
            }

            // Available directions: up, down, left, right
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            Queue<coordinates> queue = new LinkedList<>();
            boolean[][] visited = new boolean[rows][cols];
            coordinates[][] prev = new coordinates[rows][cols];

            queue.add(start);
            assert start != null;
            visited[start.x][start.y] = true;

            while (!queue.isEmpty()) {
                coordinates now = queue.poll();
                assert end != null;
                if (now.x == end.x && now.y == end.y) break;

                for (int[] d : dirs) {
                    int nx = now.x + d[0], ny = now.y + d[1];
                    if (nx >= 0 && ny >= 0 && nx < rows && ny < cols) { // ✅ boundary check
                        if (map[nx][ny] != '#' && !visited[nx][ny]) {
                            queue.add(new coordinates(nx, ny));
                            visited[nx][ny] = true;
                            prev[nx][ny] = now;
                        }
                    }
                }
            }

            // Reconstruct route
            List<coordinates> ruta = new ArrayList<>();
            for (coordinates p = end; p != null; p = prev[p.x][p.y])
                ruta.add(p);
            Collections.reverse(ruta);

            // Print path coordinates
            System.out.println("Ruta más corta (coordenadas):");
            for (coordinates p : ruta)
                System.out.println("(" + p.x + ", " + p.y + ")");

            // 🔹 Print directions (U, D, L, R)
            StringBuilder directions = new StringBuilder();
            for (int i = 1; i < ruta.size(); i++) {
                coordinates prevStep = ruta.get(i - 1);
                coordinates currStep = ruta.get(i);

                int dx = currStep.x - prevStep.x;
                int dy = currStep.y - prevStep.y;

                if (dx == -1 && dy == 0) directions.append("U");
                else if (dx == 1 && dy == 0) directions.append("D");
                else if (dx == 0 && dy == -1) directions.append("L");
                else if (dx == 0 && dy == 1) directions.append("R");
            }

            System.out.println("\nDirecciones:");
            System.out.println(directions);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
