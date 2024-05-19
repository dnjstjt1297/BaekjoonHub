import java.io.*;
import java.util.*;

class Node{
    int e;
    int t;
    int g;
    public Node(int e, int t, int g){
        this.e = e;
        this.t = t;
        this.g = g;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        
        ArrayList<Node>[] graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++) 
            graph[i] = new ArrayList<>();
        int s,e,t,g;
        for(int i=0; i<M; i++) {
            s = sc.nextInt();
            e = sc.nextInt();
            t = sc.nextInt();
            g = sc.nextInt();
            graph[s].add(new Node(e,t,g));
        }

        //int[] = {현재 정류장, 기다린 시간, 빨리 기다리기 수}
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0,0});

        int[] inDegree = new int[N+1];
        for(int i=0; i<=N; i++){
            
            inDegree[i] = Integer.MAX_VALUE;
            
        }
        inDegree[1] = 0;
        int answer = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == N){
                answer = Math.min(answer, cur[1]);
            }
            for(Node next : graph[cur[0]]){
                if(cur[1]%next.g!=0 && cur[2]<K){
                    if(cur[1]+next.t < inDegree[next.e]) {
                        inDegree[next.e] = cur[1]+next.t;
                        q.add(new int[]{next.e, cur[1]+next.t, cur[2]+1});
                    }
                }
                if(cur[1]+next.t+(next.g-(cur[1]%next.g))%next.g < inDegree[next.e]) {
                    inDegree[next.e] = cur[1]+next.t+(next.g-(cur[1]%next.g))%next.g;
                    q.add(new int[]{next.e, cur[1]+next.t+(next.g-(cur[1]%next.g))%next.g, cur[2]});
                }
            }
        }
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }
}
