import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static final int INF = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i],i);
        }
        int[] res = find(arr,map);
        for(int i = 0;i < n;i++) {
            System.out.print(res[i]+" ");
        }
    }

    public static int[] find(int[] arr, HashMap<Integer,Integer> map) {
        int[] res = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            for(int j = arr[i]*2; j<=INF; j+=arr[i]) {
                if(map.containsKey(j)) {
                    res[map.get(j)]--;
                    res[i]++;
                }
            }
        }
        return res;
    }
}