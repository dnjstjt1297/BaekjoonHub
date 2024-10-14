import java.util.*;
import java.io.*;

class Warrier{
    int x;
    int y;
    boolean rockStatus = false;
    boolean liveStatus = true;

    public Warrier(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Warrier[] warriers = new Warrier[M];
        for(int i =0; i<M;i++){
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            warriers[i] = new Warrier(x,y);
        }

        int[][] board = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<int[]> route = findRouteOfMedusa(board,N,sx,sy,ex,ey);
        

        for(int[] r : route){
            if(r[0]== ex && r[1] == ey){
                System.out.println(0);
                break;
            }
            for(Warrier w: warriers){
                if(w.x == r[0] && w.y== r[1]) w.liveStatus = false;
            }
            
            int b = makeRock(warriers, N, r[0], r[1]);
            int[] ac = moveWarries(warriers, r[0], r[1]);
            System.out.println(ac[0]+" "+b+" "+ac[1]);
        }
        
    }

    public static ArrayList<int[]> findRouteOfMedusa(int[][] board,int N, int sx, int sy, int ex, int ey){
        Queue<int[]> q1 = new LinkedList<>();
        q1.add(new int[]{sx,sy});
        
        ArrayList<int[]> route = new ArrayList<>();
        Queue<ArrayList<int[]>> q2 = new LinkedList<>();
        q2.add(route);

        while(!q1.isEmpty()){
            int[] cm = q1.poll();
            ArrayList<int[]> cr = q2.poll();

            if(cm[0]==ex && cm[1]==ey){
                return cr;
            }
            
            for(int i =0;i<4;i++){
                int nx = cm[0]+dx[i];
                int ny = cm[1]+dy[i];
                if(nx<0||ny<0||nx>=N||ny>=N) continue;
                if(board[nx][ny]==1) continue;
                q1.add(new int[]{nx,ny});
                ArrayList<int[]> nr = new ArrayList<>(cr);
                nr.add(new int[]{nx,ny});
                q2.add(nr);
            }
        }


        return route;
    }

    public static int countRock(Warrier[] warriers, int N, int mx, int my, char compase, boolean isMakeRock){
        int result = 0;
        
        int left = 0;
        int right = N-1;
        boolean centerStatus = true;

        Arrays.sort(warriers, new Comparator<Warrier>(){
            @Override
            public int compare(Warrier o1, Warrier o2){
                if(compase == 'D')
                    return o1.x-o2.x;
                else if(compase == 'U')
                    return o2.x-o1.x;
                else if(compase == 'R')
                    return o1.y-o2.y;
                else if(compase == 'L')
                    return o2.y-o1.y;
                return 0;
            }
        });

        for(Warrier w : warriers){
            if(!w.liveStatus) continue;
            if(compase == 'D'){
                if(w.x<=mx) continue;
                if(w.y<my && w.y>=left){
                    result++;
                    if(isMakeRock) w.rockStatus = true;
                    left = w.y+1;
                }
                else if(w.y>my && w.y<=right){
                    result++;
                    if(isMakeRock) w.rockStatus = true;
                    right = w.y-1;
                }
                else if(w.y==my && centerStatus){
                    result++;
                    if(isMakeRock) w.rockStatus = true;
                    centerStatus = false;
                }
            }
            else if(compase == 'U'){
                if(w.x>=mx) continue;

                if(w.y<my && w.y>=left){
                    result++;
                    if(isMakeRock) w.rockStatus = true;
                    left = w.y+1;
                }
                else if(w.y>my && w.y<=right){
                    result++;
                    if(isMakeRock) w.rockStatus = true;
                    right = w.y-1;
                }
                else if(w.y==my && centerStatus){
                    result++;
                    if(isMakeRock) w.rockStatus = true;
                    centerStatus = false;
                }
            }
            else if(compase == 'R'){
                if(w.y<=my) continue;
                if(w.x<mx && w.x>=left){
                    result++;
                    if(isMakeRock) w.rockStatus = true;
                    left = w.y+1;
                }
                else if(w.x>mx && w.x<=right){
                    result++;
                    if(isMakeRock) w.rockStatus = true;
                    right = w.y-1;
                }
                else if(w.x==mx && centerStatus){
                    result++;
                    if(isMakeRock) w.rockStatus = true;
                    centerStatus = false;
                }
            }
            else if(compase == 'L'){
                if(w.y>=my) continue;

                if(w.x<mx && w.x>=left){
                    result++;
                    if(isMakeRock) w.rockStatus = true;
                    left = w.y+1;
                }
                else if(w.x>mx && w.x<=right){
                    result++;
                    if(isMakeRock) w.rockStatus = true;
                    right = w.y-1;
                }
                else if(w.x==mx && centerStatus){
                    result++;
                    if(isMakeRock) w.rockStatus = true;
                    centerStatus = false;
                }
            }
        }
        return result;
    }

    public static int makeRock(Warrier[] warriers, int N, int mx, int my){
        
        int dCnt=countRock(warriers, N,  mx,  my,'D',false);
        int uCnt=countRock(warriers, N,  mx,  my,'U',false);
        int lCnt=countRock(warriers, N,  mx,  my,'L',false);        
        int rCnt=countRock(warriers, N,  mx,  my,'R',false);

        int maxCnt = dCnt;
        maxCnt = Math.max(maxCnt,uCnt);
        maxCnt = Math.max(maxCnt,lCnt);
        maxCnt = Math.max(maxCnt,rCnt);

        if(maxCnt==uCnt){
            countRock(warriers, N, mx, my,'U',true);
            return maxCnt;
        }
        else if(maxCnt==dCnt){
            countRock(warriers, N, mx, my,'D',true);
            return maxCnt;
        }
        else if(maxCnt==lCnt){
            countRock(warriers, N, mx, my,'L',true);
            return maxCnt;
        }
        else if(maxCnt==rCnt){
            countRock(warriers, N, mx, my,'R',true);
            return maxCnt;
        }

        return maxCnt;
    }

    static public int[] moveWarries(Warrier[] warriers, int mx, int my){
        
        int moveCnt = 0;
        int deadCnt = 0;
        for(Warrier w: warriers){
            if(!w.liveStatus) continue;
            if(w.rockStatus){
                w.rockStatus = false;
                continue;
            }
            //one move
            
            
            if(w.x>mx) w.x--;
            else if(w.x<mx) w.x++;
            else if(w.y>my) w.y--;
            else if(w.y<my) w.y++;
                moveCnt++;
            if(w.x == mx && w.y == my) {
                w.liveStatus = false;
                deadCnt++;
                continue;
            }

            //two move
            if(w.y>my) w.y--;
            else if(w.y<my) w.y++;
            else if(w.x>mx) w.x--;
            else if(w.x<mx) w.x++;
            moveCnt++;    
            if(w.x == mx && w.y == my) {
                w.liveStatus = false;
                deadCnt++;
            }
        }

        return new int[]{moveCnt,deadCnt};
    }

}