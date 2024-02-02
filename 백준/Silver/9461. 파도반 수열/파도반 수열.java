import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.IllegalArgumentException;

public class Main {
    static int T;
    static int[] testList;
    public static void main(String[] args) throws IOException, IllegalArgumentException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        testList = new int[T];
        for(int i = 0; i< T; i++){
            testList[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<T;i++) {
            if(1<=testList[i]&&testList[i]<=3) {
                System.out.println(1);
            }
            else if(4<=testList[i]&&testList[i]<=5) {
                System.out.println(2);
            }
            else{
                long[] P = new long[testList[i]];
                P[0] = 1;
                P[1] = 1;
                P[2] = 1;
                P[3] = 2;
                P[4] = 2;
                for(int j=5;j<testList[i];j++){
                    P[j] = P[j-1]+P[j-5];
                }
                System.out.println(P[testList[i]-1]);
            }
        }
    }
}
