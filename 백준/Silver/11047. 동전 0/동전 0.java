
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] As = new int[N];
        for(int i = 0; i < N; i++){
            As[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        while(K>0){
            int i = 0;
            while(As[i]<K){
                i++;
                if(i==N){
                    i--;
                    break;
                }
            }
            if(As[i]>K) i--;
            K-=As[i];
            ans++;
        }
        System.out.println(ans);

    }
}
