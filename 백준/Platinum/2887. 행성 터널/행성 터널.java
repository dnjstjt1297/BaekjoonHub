import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int id;
    int[] loc;
    public Node(int id, int[] loc) {
        this.id = id;
        this.loc = loc;
    }
}

public class Main {
    static final int dimension = 3;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }
        Node[] nodes = new Node[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] loc = new int[dimension];
            for(int j = 0; j < dimension; j++) {
                loc[j] = Integer.parseInt(st.nextToken());
            }
            nodes[i] = new Node(i, loc);
        }
        Node[][] sortedNodes = makeSortedNodes(nodes);
        PriorityQueue<int[]> pq = makeEdges(sortedNodes);
        int result = kruskal(pq);
        System.out.println(result);
    }
    public static Node[][] makeSortedNodes(Node[] nodes) {
        Node[][] result = new Node[dimension][];
        for(int i = 0; i < dimension; i++) {
            result[i] = cloneNode(nodes);
            int finalI = i;
            Arrays.sort(result[i], Comparator.comparingInt(node -> node.loc[finalI]));
        }
        return result;
    }

    public static Node[] cloneNode(Node[] nodes) {
        Node[] clone = new Node[nodes.length];
        for(int i = 0; i < nodes.length; i++) {
            clone[i] = new Node(nodes[i].id, nodes[i].loc);
        }
        return clone;
    }

    public static int kruskal(PriorityQueue<int[]> pq) {
        int result = 0;
        while(!pq.isEmpty()) {
            int[] edge = pq.poll();
            if(find(edge[0])!=find(edge[1])) {
                union(edge[0], edge[1]);
                result+=edge[2];
            }
        }
        return result;
    }

    public static PriorityQueue<int[]> makeEdges(Node[][]nodes){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for(int i =0; i<dimension; i++) {
            for(int j = 1; j<nodes[i].length;j++){
                pq.add(new int[]{nodes[i][j-1].id, nodes[i][j].id, Math.abs(nodes[i][j].loc[i]-nodes[i][j-1].loc[i])});
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