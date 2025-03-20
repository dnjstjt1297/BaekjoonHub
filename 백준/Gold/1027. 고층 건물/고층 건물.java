
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxSum = 0;
        for(int i = 0; i<n; i++){

            int sum = 0;
            double minGradiant = Double.MAX_VALUE;
            for(int j = i-1; j>=0; j--){
                double gradiant = findGradiant(arr, i, j);
                if(gradiant < minGradiant){
                    sum++;
                    minGradiant = gradiant;
                }
            }

            double maxGradiant = -(Double.MAX_VALUE-1);
            for(int j = i+1; j<n; j++){
                double gradiant = findGradiant(arr, i, j);
                if(gradiant > maxGradiant){
                    sum++;
                    maxGradiant = gradiant;
                }
            }
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println(maxSum);
    }

    public static double findGradiant(int[] arr, int a, int b){
        return (double) (arr[b] - arr[a])/(b-a);
    }
}