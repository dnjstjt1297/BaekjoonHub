import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map1 = makeMap(arr1);
        Map<Integer, Integer> map2 = makeMap(arr2);
        int[] set1 = makeSet(map1);
        int[] set2 = makeSet(map2);
        long result = findT(set1,set2, map1, map2, T);
        System.out.println(result);
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == target) return mid;
            if(arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public static Map<Integer,Integer> makeMap(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return map;
    }

    public static int[] makeSet(Map<Integer, Integer> map){
        Set<Integer> set = map.keySet();
        int[] result = new ArrayList<>(set).stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(result);
        return result;
    }

    public static long findT(int[] set1, int[] set2, Map<Integer, Integer> map1, Map<Integer, Integer> map2, int T){
        long result = 0;
        for(int e: set1){
            int idx = binarySearch(set2, T-e);
            if(idx!=-1){
                result+= (long) map1.get(e) * map2.get(set2[idx]);
            }
        }
        return result;
    }

}