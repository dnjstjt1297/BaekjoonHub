import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int n, m;
    static int[][] board;
    static int[][] groups;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        groups = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][m];
        Map<Integer,Integer> map = new HashMap<>();
        int maxGroup = 0;
        int group = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j]) continue;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                visited[i][j] = true;
                int cnt = 0;
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    groups[cur[0]][cur[1]] = group;
                    cnt++;
                    int[] seq = decode(board[cur[0]][cur[1]]);
                    for(int e : seq){
                        int nx = cur[0] + dx[e];
                        int ny = cur[1] + dy[e];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(visited[nx][ny]) continue;
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
                maxGroup = Math.max(maxGroup, cnt);
                map.put(group,cnt);
                group++;
            }
        }

        Map<Integer,HashSet<Integer>> map2 = new HashMap<>();
        for(int i = 0; i<group; i++) {
            map2.put(i,new HashSet<>());
        }


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if(groups[i][j] != groups[nx][ny]){
                        map2.get(groups[i][j]).add(groups[nx][ny]);
                    }
                }
            }
        }

        int maxSumGroup = 0;
        for(int i = 0; i<group; i++) {
            HashSet<Integer> set = map2.get(i);
            int cnt = map.get(i);

            for(int g : set){
                maxSumGroup = Math.max(maxSumGroup, map.get(g)+cnt);
            }
        }


        System.out.println(group);
        System.out.println(maxGroup);
        System.out.println(maxSumGroup);

    }



    public static int[] decode(int n){
        if(n==15) return new int[]{};
        if(n==14) return new int[]{2}; // 1
        if(n==13) return new int[]{0}; // 2
        if(n==12) return new int[]{0,2}; // 1 2
        if(n==11) return new int[]{3}; // 4
        if(n==10) return new int[]{2,3}; // 1 4
        if(n==9) return new int[]{0,3}; // 2 4
        if(n==8) return new int[]{2,0,3}; // 1 2 4
        if(n==7) return new int[]{1}; // 8
        if(n==6) return new int[]{1,2}; // 1 8
        if(n==5) return new int[]{0,1}; // 2 8
        if(n==4) return new int[]{0,1,2}; // 1, 2, 8
        if(n==3) return new int[]{1,3}; // 4, 8
        if(n==2) return new int[]{1,2,3}; // 1 4 8
        if(n==1) return new int[]{0,1,3}; // 2 4 8
        if(n==0) return new int[]{0,1,2,3};
        return null;
    }

}
