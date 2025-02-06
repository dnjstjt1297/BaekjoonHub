
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N,M,R;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<R;i++){
            int cmd = Integer.parseInt(st.nextToken());
            if(cmd==1) runCmd1();
            else if(cmd==2) runCmd2();
            else if(cmd==3) runCmd3();
            else if(cmd==4) runCmd4();
            else if(cmd==5) runCmd5();
            else if(cmd==6) runCmd6();
        }
        print();
    }

    public static void runCmd1() {
        for(int i = 0;i<N/2;i++){
            int[] tmp = arr[i];
            arr[i] = arr[N-i-1];
            arr[N-i-1] = tmp;
        }
    }
    public static void runCmd2() {
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M/2;j++){
                int tmp = arr[i][j];
                arr[i][j] = arr[i][M-1-j];
                arr[i][M-1-j] = tmp;
            }
        }
    }
    public static void runCmd3() {
        int[][] result = new int[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                result[i][j] = arr[N-1-j][i];
            }
        }
        arr = result;
        int tmp = N;
        N = M;
        M = tmp;
    }

    public static void runCmd4() {
        int[][] result = new int[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                result[i][j] = arr[j][M-1-i];
            }
        }
        arr = result;
        int tmp = N;
        N = M;
        M = tmp;
    }

    public static void runCmd5() {
        int[][] result = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(i<N/2 && j<M/2) result[i][j+M/2] = arr[i][j];
                else if(i<N/2 && j>=M/2) result[i+N/2][j] = arr[i][j];
                else if(i>=N/2 && j>=M/2) result[i][j-M/2] = arr[i][j];
                else if(i>=N/2 && j<M/2) result[i-N/2][j] = arr[i][j];
            }
        }
        arr = result;
    }

    public static void runCmd6() {
        int[][] result = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(i<N/2 && j<M/2) result[i+N/2][j] = arr[i][j];
                else if(i<N/2 && j>=M/2) result[i][j-M/2] = arr[i][j];
                else if(i>=N/2 && j>=M/2) result[i-N/2][j] = arr[i][j];
                else if(i>=N/2 && j<M/2) result[i][j+M/2] = arr[i][j];
            }
        }
        arr = result;
    }


    public static void print() {
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
