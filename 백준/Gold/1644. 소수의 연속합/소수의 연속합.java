import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] primes = erotos(4000001);

        int answer = 0;

        int start=0,end = 0;
        int sum = 0;
        while(start<=end && start<=N && end<=N){
            if(primes[start]) start++;
            if(primes[end]) end++;

            if(!primes[start] && !primes[end]){
                if(sum>=N){
                    if(sum == N) answer++;
                    sum -= start;
                    start++;
                }
                else{
                    sum+=end;
                    if(end<N) end++;
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean[] erotos(int N){
        boolean[] primes = new boolean[N+1];
        primes[0] = true;
        primes[1] = true;
        for(int i=2; i<=N; i++){
            if(primes[i]) continue;
            for(int j=i+i; j<=N; j+=i){
                primes[j] = true;
            }
        }
        return primes;
    }
}