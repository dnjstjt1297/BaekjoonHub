import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int A,B,C;
    static String[] inputList;
    static ArrayList<Integer> stack;

    public static void main(String[] args) throws IOException, IllegalArgumentException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(br.readLine());


        int D = B+C;

        if(D>59){
            B = D%60;
            A = D/60 +A;
        }
        else{
            B = B+C;
        }
        if(A>23){
            A = A%24;
        }


        System.out.println(A+" "+B);


    }
}