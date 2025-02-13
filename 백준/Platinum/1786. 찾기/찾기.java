import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String S;
    static String P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        P = br.readLine();
        int[] a = makeLPS(P);
        List<Integer> result = kmp(S,P);
        System.out.println(result.size());
        for(int e : result){
            System.out.print(e+" ");
        }
    }

    public static int[] makeLPS(String P) {
        int M = P.length();
        int[] lps = new int[M];

        int j=0;
        for(int i=1;i<M;i++){
            while(j>0 && P.charAt(i)!=P.charAt(j)){
                j = lps[j-1];
            }
            if(P.charAt(i)==P.charAt(j)){
                lps[i] = ++j;
            }
        }
        return lps;
    }

    public static List<Integer> kmp(String T, String P){
        ArrayList<Integer> res = new ArrayList<>();

        int N = T.length();
        int M = P.length();
        int[] lps = makeLPS(P);

        int j = 0;
        for(int i=0; i<N; i++){
            while(j>0 && T.charAt(i)!=P.charAt(j)){
                j = lps[j-1];
            }
            if(T.charAt(i)==P.charAt(j)){
                if(j==M-1){
                    j = lps[j];
                    res.add(i-M+2);
                }
                else j++;
            }
        }
        return res;
    }
}
