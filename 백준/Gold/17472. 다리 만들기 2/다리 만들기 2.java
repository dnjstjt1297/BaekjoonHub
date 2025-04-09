import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge{
    int v;
    int w;
    int cost;
    public Edge(int v, int w, int cost) {
        this.v = v;
        this.w = w;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "(" + v + ", " + w + ", " + cost + ")";
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] board;
    static int numGroup;

    static ArrayList<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for(int i =0 ; i<n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        setGroup();
        setEdges();
        int answer = kruskal();
        System.out.println(answer);
    }

    public static void setGroup(){
        boolean[][] visited = new boolean[n][m];

        int id = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(visited[i][j] || board[i][j] == 0) continue;
                id++;

                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                visited[i][j] = true;

                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    board[cur[0]][cur[1]] = id;
                    for(int k=0 ; k<4 ; k++){
                        int nx = cur[0] + dx[k];
                        int ny = cur[1] + dy[k];
                        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if(visited[nx][ny] || board[nx][ny] == 0) continue;
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        numGroup = id;
    }

    public static void setEdges(){
        edges = new ArrayList<>();

        int[][] minCosts = new int[numGroup+1][numGroup+1];
        for(int i = 0; i<=numGroup; i++) Arrays.fill(minCosts[i], Integer.MAX_VALUE);

        findMinCosts(minCosts,n,m,true);
        findMinCosts(minCosts,m,n,false);

        for(int i=1 ; i<=numGroup ; i++){
            for(int j=i+1 ; j<=numGroup ; j++){
                if(minCosts[i][j] != Integer.MAX_VALUE){
                    edges.add(new Edge(i,j,minCosts[i][j]));
                }
            }
        }
    }

    private static void findMinCosts(int[][] minCostMap, int r, int c, boolean type){
        for(int i=0 ; i<r ; i++){
            int prev = 0;
            int next;
            int cost = 0;
            for(int j=0 ; j<c ; j++){
                if(type) next = board[i][j];
                else next = board[j][i];

                if(next != 0){
                    if(prev != 0 && prev != next && cost!=1){
                        minCostMap[prev][next] = Math.min(minCostMap[prev][next], cost);
                        minCostMap[next][prev] = Math.min(minCostMap[next][prev], cost);
                    }
                    prev = next;
                    cost = 0;
                }
                else cost++;
            }
        }
    }


    public static int kruskal(){
        int result = 0;

        int[] parents = new int[numGroup+1];
        for(int i=0 ; i<=numGroup ; i++) parents[i] = i;

        edges.sort(Comparator.comparingInt(o -> o.cost));
        for(int i=0; i<edges.size(); i++){
            int a = edges.get(i).v, b = edges.get(i).w;
            int cost = edges.get(i).cost;
            if(find(parents,a)!=find(parents,b)){
                union(parents,a,b);
                result+=cost;
            }
        }

        int tmp = find(parents,1);
        for(int i = 2 ; i<=numGroup ; i++){
            if(tmp!=find(parents,i)) return -1;
        }

        return result;
    }

    private static int find(int[] parents, int k){
        if(parents[k] == k) return k;
        parents[k] = find(parents, parents[k]);
        return parents[k];
    }

    private static void union(int[] parents, int a, int b){
        int pa = find(parents, a);
        int pb = find(parents, b);
        parents[pa] = pb;
    }

    public static void printBoard(){
        for(int i =0 ; i<n ; i++){
            for(int j =0 ; j<m ; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
