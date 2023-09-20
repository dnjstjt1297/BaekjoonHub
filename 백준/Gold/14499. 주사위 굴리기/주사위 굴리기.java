import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    static int N,M;
    static int x,y;
    static int K;
    static int[][] map;
    static int[] orders;
    static int front=0,back=0,up=0,down=0,left=0,right=0;



    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        down=map[x][y];

        orders = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<K;i++){
            orders[i]=Integer.parseInt(st.nextToken());
        }
        br.close();

        for(int i =0; i<K;i++){
            if(move(orders[i]))
                bw.write(Integer.toString(up)+'\n');
        }
        bw.close();
    }
    public static boolean move(int order){
        int temp;
        if(order == 1){
            if(y+1 == M) return false;
            y++;
            temp = right;
            right = up;
            up = left;
            left = down;
            down = temp;
            if(map[x][y]==0){
                map[x][y] = down;
            }
            else{
                down = map[x][y];
                map[x][y]=0;
            }
        }
        else if(order == 2){
            if(y-1 == -1) return false;
            y--;
            temp = left;
            left = up;
            up = right;
            right = down;
            down = temp;
            if(map[x][y]==0){
                map[x][y] = down;
            }
            else{
                down = map[x][y];
                map[x][y]=0;
            }
        }
        else if(order == 3){
            if(x-1 == -1) return false;
            x--;
            temp = back;
            back = up;
            up = front;
            front = down;
            down = temp;
            if(map[x][y]==0){
                map[x][y] = down;
            }
            else{
                down = map[x][y];
                map[x][y]=0;
            }
        }
        else if(order == 4){
            if(x+1 == N) return false;
            x++;
            temp = front;
            front = up;
            up = back;
            back = down;
            down = temp;
            if(map[x][y]==0){
                map[x][y] = down;
            }
            else{
                down = map[x][y];
                map[x][y]=0;
            }
        }
        return true;
    }
}

