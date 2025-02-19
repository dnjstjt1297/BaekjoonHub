import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    static char[][] building;
    static int h;
    static int w;

    static int documentCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            //input start
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            building = new char[h][w];
            for(int i = 0; i < h; i++){
                building[i] = br.readLine().toCharArray();
            }
            String keys = br.readLine();
            //input end
            if(!keys.equals("0")) for(int i = 0; i < keys.length(); i++) openDoor(keys.charAt(i));

            documentCnt = 0;
            while(!dfs());
            System.out.println(documentCnt);
        }
    }

    public static boolean dfs(){
        List<int[]> startLoc = getStartLoc();

        boolean[][] visited = new boolean[h][w];
        for(int[] loc : startLoc){
            Queue<int[]> q = new LinkedList<>();
            q.add(loc);
            visited[loc[0]][loc[1]] = true;
            while(!q.isEmpty()){
                int[] cur = q.poll();
                if(building[cur[0]][cur[1]] == '$'){
                    building[cur[0]][cur[1]] = '.';
                    documentCnt++;
                }
                else if('a'<= building[cur[0]][cur[1]] && building[cur[0]][cur[1]]<='z'){
                    openDoor(building[cur[0]][cur[1]]);
                    building[cur[0]][cur[1]] = '.';
                    return false;
                }

                for(int i=0; i<4; i++){
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if(building[nx][ny] == '*') continue;
                    if('A'<= building[nx][ny] && building[nx][ny] <= 'Z') continue;
                    if(visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }

            }

        }
        return true;
    }

    public static List<int[]> getStartLoc(){
        List<int[]> locs = new ArrayList<>();
        for(int i = 0; i<w; i++){
            if(building[h-1][i] != '*' && !('A'<=building[h-1][i] && building[h-1][i]<='Z')) locs.add(new int[]{h-1, i});
            if(building[0][i] != '*' && !('A'<=building[0][i] && building[0][i]<='Z')) locs.add(new int[]{0, i});
        }
        for(int i =0; i<h; i++){
            if(building[i][0] != '*' && !('A'<=building[i][0] && building[i][0]<='Z')) locs.add(new int[]{i, 0});
            if(building[i][w-1] != '*' && !('A'<=building[i][w-1] && building[i][w-1]<='Z')) locs.add(new int[]{i, w-1});
        }
        return locs;
    }

    public static void openDoor(char key){
        for(int i = 0; i<h; i++){
            for(int j = 0; j<w; j++){
                if(building[i][j]-'A'+'a'== key) building[i][j] = '.';
            }
        }
    }


}