import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,R,Q;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer>[] tree;
    static int[] query;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        query = new int[Q];

        for(int i=0;i<Q;i++){
            query[i] = Integer.parseInt(br.readLine());
        }
        boolean[] visited = new boolean[N+1];
        int[] subtreeNums = new int[N+1];
        findSubtreeNum(visited,subtreeNums,R);
        for(int i=0;i<Q;i++){
            System.out.println(subtreeNums[query[i]]);
        }
    }


    public static int findSubtreeNum(boolean[] visited, int[] subtreeNums, int head){
        visited[head] = true;
        subtreeNums[head] = 1;
        for(int v : graph[head]){
            if(visited[v]) continue;
            subtreeNums[head] += findSubtreeNum(visited, subtreeNums, v);
        }
        return subtreeNums[head];
    }
}