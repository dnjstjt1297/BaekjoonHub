import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[][] blocks;

    static int max=0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        blocks = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                blocks[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(blocks[i][j],max);
            }
        }
        br.close();
        dfs(blocks,0);


        bw.write(Integer.toString(max));
        bw.close();
    }
    public static void dfs(int[][] blocks, int cnt){
        up(blocks,cnt);
        down(blocks,cnt);
        left(blocks,cnt);
        right(blocks,cnt);
    }
    public static void up(int[][]blocks,int cnt){
        if(cnt==5){
            return;
        }

        int[][] copy = new int[N][N];
        for(int i=0;i<N;i++){
            copy[i] = blocks[i].clone();
        }

        for(int i=0;i<N;i++){
            //zero 모두 이동
            int zeroCnt =0;
            for(int j=0;j<N;j++){
                if(copy[j][i]==0){
                    zeroCnt++;
                }
                else{
                    for(int k = j; k<N;k++){
                        copy[k-zeroCnt][i] = copy[k][i];
                    }
                    for(int k=0;k<zeroCnt;k++){
                        copy[N-1-k][i] = 0;
                    }
                    j = j-zeroCnt;
                    zeroCnt =0;
                }
            }
            //2048
            for(int j=0;j<N-1; j++){
                if(copy[j][i] == copy[j+1][i]){
                    copy[j][i] *=2;
                    max = Math.max(max,copy[j][i]);
                    for(int k=j+1;k<N-1;k++){
                        copy[k][i] = copy[k+1][i];
                    }
                    copy[N-1][i] =0;
                }
            }
        }
        /*for(int i =0 ; i<N; i++){
            for(int j =0; j<N; j++){
                System.out.print(copy[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("up---------------"+(cnt+1));*/

        dfs(copy,cnt+1);
    }
    public static void down(int[][]blocks,int cnt){
        if(cnt==5){
            return;
        }

        int[][] copy = new int[N][N];
        for(int i=0;i<N;i++){
            copy[i] = blocks[i].clone();
        }

        for(int i=0;i<N;i++){
            //zero 모두 이동
            int zeroCnt =0;
            for(int j=N-1;j>=0;j--){
                if(copy[j][i]==0){
                    zeroCnt++;
                }
                else{
                    for(int k = j; k>=0;k--){
                        copy[k+zeroCnt][i] = copy[k][i];
                    }
                    for(int k=0;k<zeroCnt;k++){
                        copy[k][i] = 0;
                    }
                    j = j+zeroCnt;
                    zeroCnt =0;
                }
            }
            //2048
            for(int j=N-1;j>=1; j--){
                if(copy[j][i] == copy[j-1][i]){
                    copy[j][i] *=2;
                    max = Math.max(max,copy[j][i]);
                    for(int k=j-1;k>=1;k--){
                        copy[k][i] = copy[k-1][i];
                    }
                    copy[0][i] =0;
                }
            }
        }
        /*for(int i =0 ; i<N; i++){
            for(int j =0; j<N; j++){
                System.out.print(copy[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("down---------------"+(cnt+1));*/

        dfs(copy,cnt+1);
    }
    public static void left(int[][]blocks,int cnt){
        if(cnt==5){
            return;
        }

        int[][] copy = new int[N][N];
        for(int i=0;i<N;i++){
            copy[i] = blocks[i].clone();
        }

        for(int i=0;i<N;i++){
            //zero 모두 이동
            int zeroCnt =0;
            for(int j=0;j<N;j++){
                if(copy[i][j]==0){
                    zeroCnt++;
                }
                else{
                    for(int k = j; k<N;k++){
                        copy[i][k-zeroCnt] = copy[i][k];
                    }
                    for(int k=0;k<zeroCnt;k++){
                        copy[i][N-1-k] = 0;
                    }
                    j = j-zeroCnt;
                    zeroCnt =0;
                }
            }
            //2048
            for(int j=0;j<N-1; j++){
                if(copy[i][j] == copy[i][j+1]){
                    copy[i][j] *=2;
                    max = Math.max(max,copy[i][j]);
                    for(int k=j+1;k<N-1;k++){
                        copy[i][k] = copy[i][k+1];
                    }
                    copy[i][N-1] =0;
                }
            }
        }

        /*for(int i =0 ; i<N; i++){
            for(int j =0; j<N; j++){
                System.out.print(copy[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("left---------------"+(cnt+1));*/

        dfs(copy,cnt+1);
    }
    public static void right(int[][]blocks,int cnt){
        if(cnt==5){
            return;
        }

        int[][] copy = new int[N][N];
        for(int i=0;i<N;i++){
            copy[i] = blocks[i].clone();
        }

        for(int i=0;i<N;i++){
            //zero 모두 이동
            int zeroCnt =0;
            for(int j=N-1;j>=0;j--){
                if(copy[i][j]==0){
                    zeroCnt++;
                }
                else{
                    for(int k = j; k>=0;k--){
                        copy[i][k+zeroCnt] = copy[i][k];
                    }
                    for(int k=0;k<zeroCnt;k++){
                        copy[i][k] = 0;
                    }
                    j = j+zeroCnt;
                    zeroCnt =0;
                }
            }
            //2048
            for(int j=N-1;j>=1; j--){
                if(copy[i][j] == copy[i][j-1]){
                    copy[i][j] *=2;
                    max = Math.max(max,copy[i][j]);
                    for(int k=j-1;k>=1;k--){
                        copy[i][k] = copy[i][k-1];
                    }
                    copy[i][0] =0;
                }
            }
        }

        /*for(int i =0 ; i<N; i++){
            for(int j =0; j<N; j++){
                System.out.print(copy[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("right---------------"+(cnt+1));*/

        dfs(copy,cnt+1);
    }
}