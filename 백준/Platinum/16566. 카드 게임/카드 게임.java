import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int N, M, K;
    static int[] parents;
    static int[] arr;
    static int[] arr2;
    static Map<Integer,PriorityQueue<Integer>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) arr[i] = Integer.parseInt(st.nextToken());

        arr2 = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) arr2[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        makePq();

        int[] arr3 = arr2.clone();
        Arrays.sort(arr3);

        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i = 0; i < K; i++) {
            map2.put(arr3[i], i);
        }

        for(int i = 0; i < K; i++){
            if(!map.get(arr2[i]).isEmpty()){
                System.out.println(map.get(arr2[i]).poll());
                continue;
            }
            int idx = map2.get(arr2[i]);
            for(int j = idx+1; j < arr3.length; j++){
                if(!map.get(arr3[j]).isEmpty()){
                    System.out.println(map.get(arr3[j]).poll());
                    break;
                }
            }
        }

    }

    public static void makePq(){
        Set<Integer> set = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
        int[] arr3 = set.stream().mapToInt(i -> i).toArray();
        Arrays.sort(arr3);
        map = new HashMap<>();
        for(int i = 0;i<arr3.length;i++){
            map.put(arr3[i],new PriorityQueue<>());
        }
        int prev = arr3[0];
        int next;
        int idx = 0;
        for(int i=1; i<=arr3.length; i++){
            if(i<arr3.length) next = arr3[i];
            else next = Integer.MAX_VALUE;

            while(idx<arr.length){
                if(arr[idx]>prev && arr[idx]<=next){
                    map.get(prev).offer(arr[idx]);
                }
                else if(arr[idx]>=next && idx>0){
                    idx--;
                    break;
                }
                idx++;
            }
            prev = next;
        }

    }
}