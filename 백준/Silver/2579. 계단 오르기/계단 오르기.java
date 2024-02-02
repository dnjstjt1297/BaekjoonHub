import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.IllegalArgumentException;

public class Main {
    static int N;
    static int[] scoreList;
    public static void main(String[] args) throws IOException, IllegalArgumentException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        scoreList = new int[N];
        for(int i=0;i<N;i++){
            scoreList[i] = Integer.parseInt(br.readLine());
        }
        int[][] A = new int[N][2];
        for(int i=0; i<N;i++){
            if(i==0){
                A[i][0]+=scoreList[i];
            }
            else if(i==1){
                A[i][1] = A[i-1][0]+scoreList[i];
                A[i][0] += scoreList[i];
            }
            else{
                A[i][0] = Math.max(A[i-2][1]+scoreList[i],A[i-2][0]+scoreList[i]);
                A[i][1] = A[i-1][0]+scoreList[i];
            }
        }
        System.out.println(Math.max(A[N-1][0],A[N-1][1]));
    }
}