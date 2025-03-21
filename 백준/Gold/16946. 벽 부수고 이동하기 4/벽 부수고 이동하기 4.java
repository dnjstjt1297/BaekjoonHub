import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static int[][] groupMap; // 그룹 ID 기록
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> groupSize = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        groupMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        makeZeroGroups();

        int[][] res = new int[n][m];
        int[] groupVisited = new int[groupSize.size()];
        int visitId = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    int sum = 1;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                        int gid = groupMap[nx][ny];
                        if (gid == 0) continue;

                        if (groupVisited[gid] == visitId) continue;
                        groupVisited[gid] = visitId;
                        sum += groupSize.get(gid);
                    }
                    res[i][j] = sum % 10;
                    visitId++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : res) {
            for (int v : row) sb.append(v);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void makeZeroGroups() {
        boolean[][] visited = new boolean[n][m];
        int groupId = 1; // 0은 미할당 상태
        groupSize.add(0); // groupSize[0]은 의미 없음

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    int size = 1;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    groupMap[i][j] = groupId;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0], y = cur[1];
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                            if (visited[nx][ny] || board[nx][ny] == 1) continue;
                            visited[nx][ny] = true;
                            groupMap[nx][ny] = groupId;
                            q.add(new int[]{nx, ny});
                            size++;
                        }
                    }

                    groupSize.add(size);
                    groupId++;
                }
            }
        }
    }
}
