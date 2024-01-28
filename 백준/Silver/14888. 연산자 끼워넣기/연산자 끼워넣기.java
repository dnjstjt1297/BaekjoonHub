import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int N;
    static int[] numList;
    static int[] operationNumList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numList = new int[N];
        for(int i=0; i<N; i++){
            numList[i] = Integer.parseInt(st.nextToken());
        }

        operationNumList = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operationNumList[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1,numList[0],0,0,0,0);
        System.out.println(max);

        System.out.println(min);
    }

    static int value;
    static int max = -1000000000;
    static int min = 1000000000;
    public static void dfs(int n, int value, int add, int sub, int mul, int div) {
        if(n == N){
            max = Math.max(max,value);
            min = Math.min(min,value);
            return;
        }
        if(add<operationNumList[0])
            dfs(n+1,value+numList[n],add+1,sub,mul,div);
        if(sub<operationNumList[1])
            dfs(n+1,value-numList[n],add,sub+1,mul,div);
        if(mul<operationNumList[2])
            dfs(n+1,value*numList[n],add,sub,mul+1,div);
        if(div<operationNumList[3])
            dfs(n+1,value/numList[n],add,sub,mul,div+1);
    }

}

