import java.io.*;
import java.util.*;

public class Main {
    
    static Long INF = 1000000000000000000L;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        
        int start = 0;
        int end = arr[N-1];
        int mid = end;
        
        int result = 0;
        while(start<=end) {
        	int sum = 0;
        	for(int i=0;i<N;i++) {
        		if(arr[i]<=mid) sum += arr[i];
        		else sum += mid;
        	}
        	if(sum<=K) result = Math.max(result,mid);		
        	if(sum<=K) start = mid+1;
        	else end = mid-1;

        	mid = (end+start)/2;
        	
        }
        System.out.println(result);
    }
    
}