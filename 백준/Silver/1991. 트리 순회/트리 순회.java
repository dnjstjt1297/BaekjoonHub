
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder preOrder = new StringBuilder();
    static StringBuilder inOrder = new StringBuilder();
    static StringBuilder postOrder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char[][] tree = new char[N][3];
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                tree[i][j] = st.nextToken().charAt(0);
            }
            map.put(tree[i][0],i);
        }
        findOrders(tree,map,0);
        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);
    }

    public static void findOrders(char[][] tree, Map<Character,Integer> map, int idx){
        preOrder.append(tree[idx][0]);
        if(tree[idx][1]!='.') findOrders(tree,map,map.get(tree[idx][1]));
        inOrder.append(tree[idx][0]);
        if(tree[idx][2]!='.') findOrders(tree,map,map.get(tree[idx][2]));
        postOrder.append(tree[idx][0]);
    }
}
