import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};

    static int n;
    static int[][] board;
    static int sx, sy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 9){
                    sx = i;
                    sy = j;
                    board[i][j] = 0;
                }
            }
        }

        int second = 0;
        int weight = 2;
        int countEat = 0;
        oo: while(true){
            boolean[][] visited = new boolean[n][n];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{sx, sy, 0});
            visited[sx][sy] = true;

            List<int[]> fishList = new ArrayList<>();
            int minDist = Integer.MAX_VALUE;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1], dist = cur[2];

                if (dist > minDist) break;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (visited[nx][ny] || board[nx][ny] > weight) continue;

                    visited[nx][ny] = true;

                    if (board[nx][ny] != 0 && board[nx][ny] < weight) {
                        fishList.add(new int[]{nx, ny, dist + 1});
                        minDist = dist + 1;
                    } else {
                        q.add(new int[]{nx, ny, dist + 1});
                    }
                }
            }
            if (fishList.isEmpty()) break;

            fishList.sort((a, b) -> {
                if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });

            int[] target = fishList.get(0);
            sx = target[0];
            sy = target[1];
            second += target[2];
            board[sx][sy] = 0;
            countEat++;
            if (countEat == weight) {
                weight++;
                countEat = 0;
            }
        }
        System.out.println(second);

    }

}
