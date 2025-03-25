import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][2];
        for(int i = 0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int groupPrice = Integer.MAX_VALUE;
        int price = Integer.MAX_VALUE;

        for(int i = 0; i< m;i++){
            if(arr[i][0]<groupPrice) groupPrice = arr[i][0];
            if(arr[i][1]<price) price = arr[i][1];
        }

        if(groupPrice>price*6) groupPrice = price*6;

        int ans = 0;
        while(n>0){
            if(n>=6){
                ans+=groupPrice;
                n-=6;
            }
            else{
                if(groupPrice<price*n){
                    ans+=groupPrice;
                    n=0;
                }
                else {
                    ans+=price;
                    n--;
                }
            }
        }
        System.out.println(ans);

    }
}