import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Node{
    int node;
    int cost;
    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

public class Main {
    static int INF = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken())-1;
        }
        int M = Integer.parseInt(br.readLine());
        int[][] edges = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken()) - 1;
            edges[i][1] = Integer.parseInt(st.nextToken()) - 1;
            edges[i][2] = Integer.parseInt(st.nextToken());
        }
        int start = arrayToInt(arr,N);
        Arrays.sort(arr);
        int end = arrayToInt(arr,N);
        int result = dijkstra(edges,N,start,end);


        int[] s = intToArray(345,6);
        int w = arrayToInt(new int[]{0,0,0,3,4,5},6);
        System.out.println(result);
    }

    public static int dijkstra(int[][] edges, int N, int start, int end) {
        Map<Integer, Integer> degree = new HashMap<>();
        degree.put(start, 0);

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.node==end) return cur.cost;

            for(int i = 0 ; i < edges.length ; i++) {
                int next = swapInt(cur.node, N, edges[i][0],edges[i][1]);

                if(!degree.containsKey(next)) {
                    degree.put(next,degree.get(cur.node)+edges[i][2]);
                    pq.offer(new Node(next, degree.get(next)));
                }
                else if(degree.get(next)>degree.get(cur.node)+edges[i][2]) {
                    degree.replace(next, degree.get(cur.node)+edges[i][2]);
                    pq.offer(new Node(next,degree.get(next)));
                }
            }
        }

        return -1;
    }

    public static int swapInt(int num, int N, int idx1, int idx2){
        int[] arr = intToArray(num,N);
        swap(arr,idx1,idx2);
        return arrayToInt(arr, N);
    }

    public static int[] intToArray(int num, int N) {
        int digit = findDigit(num);
        int[] arr = new int[N];
        int tmp = (int) Math.pow(10,digit-1);
        for(int i = 0; i < N; i++){
            if(i<N-digit){
                arr[i] = 0;
                continue;
            }
            arr[i] = num/tmp;
            num %= tmp;
            tmp/=10;
        }
        return arr;
    }

    public static int arrayToInt(int[] arr, int N) {
        int result = 0;
        for(int i = 0; i<=N-1; i++){
            result+= (int) (arr[i]*Math.pow(10,N-1-i));
        }
        return result;
    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static int findDigit(int num){
        int result = 0;
        while(num!=0){
            num = num/10;
            result++;
        }
        return result;
    }
}