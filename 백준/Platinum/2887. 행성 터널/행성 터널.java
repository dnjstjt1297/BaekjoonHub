import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int id;
    int x,y,z;
    public Node(int id, int x, int y, int z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }
        Node[] nodes1 = new Node[N];
        Node[] nodes2 = new Node[N];
        Node[] nodes3 = new Node[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            nodes1[i] = new Node(i, x, y, z);
            nodes2[i] = new Node(i, x, y, z);
            nodes3[i] = new Node(i, x, y, z);
        }
        Arrays.sort(nodes1, Comparator.comparingInt(s -> s.x));
        Arrays.sort(nodes2, Comparator.comparingInt(s -> s.y));
        Arrays.sort(nodes3, Comparator.comparingInt(s -> s.z));

        PriorityQueue<int[]> pq = makeEdges(nodes1,nodes2,nodes3);

        int result = 0;
        while(!pq.isEmpty()) {
            int[] edge = pq.poll();
            if(find(edge[0])!=find(edge[1])) {
                union(edge[0], edge[1]);
                result+=edge[2];
            }
        }
        System.out.println(result);
    }

    public static PriorityQueue<int[]> makeEdges(Node[] ... nodes){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);

        for(int i =0; i<3; i++) {
            for(int j = 1; j<nodes[i].length;j++){
                if(i==0) pq.add(new int[]{nodes[i][j-1].id, nodes[i][j].id, Math.abs(nodes[i][j].x-nodes[i][j-1].x)});
                else if(i==1) pq.add(new int[]{nodes[i][j-1].id, nodes[i][j].id, Math.abs(nodes[i][j].y-nodes[i][j-1].y)});
                else if(i==2) pq.add(new int[]{nodes[i][j-1].id, nodes[i][j].id, Math.abs(nodes[i][j].z-nodes[i][j-1].z)});
            }
        }
        return pq;
    }

    public static int find(int n){
        if(parent[n] == n) return n;
        n = find(parent[n]);
        return n;
    }

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa < pb) parent[pa] = pb;
        else parent[pb] = pa;
    }
}