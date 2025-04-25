import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[n];
        for(int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i = 0; i<n; i++){
            int move = arr2[i] - arr[i];
            arr[i] = arr2[i];
            if(move > 0) {
                for (int j = 0; j < move; j++) {
                    for (int k = i + 1; k < n; k++) {
                        if (arr2[k]-arr[k]>0){
                            arr[k]++;
                        }
                        else break;
                    }
                }
                answer += move;
            }
            else if(move < 0){
                for(int j = 0; j<-move; j++){
                    for (int k = i+1; k < n; k++) {
                        if(arr2[k]-arr[k]<0){
                            arr[k]--;
                        }
                        else break;
                    }
                }
                answer -= move;
            }
        }
        System.out.println(answer);

    }


}
