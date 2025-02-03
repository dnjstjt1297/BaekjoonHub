import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] seq = new int[M][2];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            seq[i][0] = Integer.parseInt(st.nextToken());
            seq[i][1] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[N+1];

        for(int i = 0; i < M; i++){
            int parent = seq[i][0];
            int child = seq[i][1];
            graph[parent].add(child);
            indegree[child]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            int cur = q.poll();
            res.add(cur);
            for(Integer child : graph[cur]){
                indegree[child]--;
                if(indegree[child] == 0){
                    q.add(child);
                }
            }
        }

        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i));
            System.out.print(" ");
        }
        System.out.println();

    }

}