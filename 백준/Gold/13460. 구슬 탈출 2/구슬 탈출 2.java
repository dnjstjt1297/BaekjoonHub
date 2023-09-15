import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static String[] beads;

    static int min = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        beads = new String[N];


        int rowR=0;
        int colR=0;
        int rowB=0;
        int colB=0;

        for(int i =0; i<N; i++){
            beads[i] = br.readLine();
            for(int j=0;j<M;j++){
                if(beads[i].charAt(j) == 'R'){
                    colR = i;
                    rowR = j;
                }
                if(beads[i].charAt(j) == 'B'){
                    colB = i;
                    rowB = j;
                }
            }
        }
        br.close();

        dfs(colB,rowB, colR,rowR,0);

        bw.write(Integer.toString(min));
        bw.close();
    }
    public static void dfs(int colB, int rowB, int colR, int rowR, int cnt){
        if(cnt==10){
            return;
        }
        up(colB,rowB,colR,rowR,cnt);
        down(colB,rowB,colR,rowR,cnt);
        left(colB,rowB,colR,rowR,cnt);
        right(colB,rowB,colR,rowR,cnt);
    }

    public static void up(int colB, int rowB, int colR, int rowR, int cnt){

        int cntB = 0;
        int cntR = 0;

        for(int i = colB-1; i>=0;i--){
            if(beads[i].charAt(rowB)=='#'){
                break;
            }
            else if(beads[i].charAt(rowB)=='O'){
                return;
            }
            else{
                cntB++;
            }
        }

        for(int i = colR-1; i>=0;i--){
            if(beads[i].charAt(rowR)=='#'){

                break;
            }
            else if(beads[i].charAt(rowR)=='O'){
                if(min == -1){
                    min = cnt+1;
                }
                else
                    min = Math.min(min,cnt+1);
                return;
            }
            else{
                cntR++;
            }
        }

        if(rowB==rowR){
            if(colB - cntB == colR - cntR){
                if(colB>colR){
                    cntB--;
                }
                else if(colB<colR){
                    cntR--;
                }
            }
        }

        dfs(colB-cntB,rowB,colR-cntR,rowR,cnt+1);
    }
    public static void down(int colB, int rowB, int colR, int rowR, int cnt){

        int cntB = 0;
        int cntR = 0;

        for(int i = colB+1; i<N;i++){
            if(beads[i].charAt(rowB)=='#'){
                break;
            }
            else if(beads[i].charAt(rowB)=='O'){
                return;
            }
            else{
                cntB++;
            }
        }

        for(int i = colR+1; i<N;i++){
            if(beads[i].charAt(rowR)=='#'){
                break;
            }
            else if(beads[i].charAt(rowR)=='O'){
                if(min == -1){
                    min = cnt+1;
                }
                else
                    min = Math.min(min,cnt+1);
                return;
            }
            else{
                cntR++;
            }
        }

        if(rowB==rowR){
            if(colB + cntB == colR + cntR){
                if(colB<colR){
                    cntB--;
                }
                else if(colB>colR){
                    cntR--;
                }
            }
        }

        dfs(colB+cntB,rowB,colR+cntR,rowR,cnt+1);
    }
    public static void left(int colB, int rowB, int colR, int rowR, int cnt){

        int cntB = 0;
        int cntR = 0;

        for(int i = rowB-1; i>=0;i--){
            if(beads[colB].charAt(i)=='#'){
                break;
            }
            else if(beads[colB].charAt(i)=='O'){
                return;
            }
            else{
                cntB++;
            }
        }

        for(int i = rowR-1; i>=0;i--){
            if(beads[colR].charAt(i)=='#'){
                break;
            }
            else if(beads[colR].charAt(i)=='O'){
                if(min == -1){
                    min = cnt+1;
                }
                else
                    min = Math.min(min,cnt+1);
                return;
            }
            else{
                cntR++;
            }
        }

        if(colB==colR){
            if(rowB - cntB == rowR - cntR){
                if(rowB>rowR){
                    cntB--;
                }
                else if(rowB<rowR){
                    cntR--;
                }
            }
        }

        dfs(colB,rowB-cntB, colR,rowR-cntR,cnt+1);
    }
    public static void right(int colB, int rowB, int colR, int rowR, int cnt){
        int cntB = 0;
        int cntR = 0;

        for(int i = rowB+1; i<M;i++){
            if(beads[colB].charAt(i)=='#'){
                break;
            }
            else if(beads[colB].charAt(i)=='O'){
                return;
            }
            else{
                cntB++;
            }
        }

        for(int i = rowR+1; i<M;i++){
            if(beads[colR].charAt(i)=='#'){
                break;
            }
            else if(beads[colR].charAt(i)=='O'){
                if(min == -1){
                    min = cnt+1;
                }
                else
                    min = Math.min(min,cnt+1);
                return;
            }
            else{
                cntR++;
            }
        }

        if(colB==colR){
            if(rowB + cntB == rowR + cntR){
                if(rowB<rowR){
                    cntB--;
                }
                else if(rowB>rowR){
                    cntR--;
                }
            }
        }

        dfs(colB,rowB+cntB, colR,rowR+cntR,cnt+1);
    }
}