import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long m;
    static int[][] arr;
    static int[][] arr2;
    static int[][] arr3;
    static HashMap<Long, int[][]> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken())%1000;
            }
        }
        arr2 = mulMatrix(arr,arr);
        arr3 = mulMatrix(arr2,arr);
        map = new HashMap<>();
        map.put(1L,arr);
        map.put(2L,arr2);
        map.put(3L,arr3);

        int[][] res = powMatrix(m);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] mulMatrix(int[][] arr, int[][] arr2) {
        int[][] res = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    res[i][j] =(res[i][j]+ (arr[i][k] * arr2[k][j])%1000)%1000;
                }
            }
        }
        return res;
    }

    public static int[][] powMatrix(long m) {
        if(map.containsKey(m)){
            return map.get(m);
        }
        int[][] result;
        if(m%2==1) result = mulMatrix(mulMatrix(powMatrix(m/2),powMatrix(m/2)),arr);
        else result = mulMatrix(powMatrix(m/2),powMatrix(m/2));
        if(!map.containsKey(m)) map.put(m,result);
        return result;
    }
}