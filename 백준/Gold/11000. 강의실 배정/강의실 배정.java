
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<int[]> rectures = new ArrayList<>();

        for(int i =0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            rectures.add(new int []{a,b});
        }
        br.close();


        Comparator<int[]> co = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                else{
                    return o1[0]-o2[0];
                }
            }
        };


        Collections.sort(rectures,co);

        Queue<Integer> prioQue = new PriorityQueue<>();

        prioQue.add(rectures.get(0)[1]);

        for(int i =1; i<N; i++){
            if(prioQue.peek() <= rectures.get(i)[0]){
                prioQue.poll();
            }
            prioQue.add(rectures.get(i)[1]);
        }

        bw.write(Integer.toString(prioQue.size()));
        bw.close();
    }
}
