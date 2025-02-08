import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int[] inOrder;
    static int[] postOrder;
    static ArrayList<Integer> preOrder = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        inOrder = new int[N];
        for(int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());

        }
        st = new StringTokenizer(br.readLine());
        postOrder = new int[N];
        for(int i = 0; i < N; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
        getPreOrder(0,N-1);
        for(int e: preOrder){
            System.out.print(e + " ");
        }
    }

    public static void getPreOrder( int start, int end){
        if(start > end) return;
        preOrder.add(postOrder[end]);

        int idx = -1;
        for(int i=start; i<=end;i++){
            if(inOrder[i] == postOrder[end]){
                idx=i;
                removeIdx(inOrder,end,idx);
                break;
            }
        }
        if(idx == -1) return;
        getPreOrder(start,idx-1);
        if(idx<end) getPreOrder(idx,end-1);
    }

    public static void removeIdx( int[] arr, int end, int idx){
        for(int i=idx; i<end; i++){
            arr[i] = arr[i+1];
        }
    }
}