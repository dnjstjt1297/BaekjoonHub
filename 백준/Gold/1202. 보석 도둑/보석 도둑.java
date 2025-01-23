import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Jewel {
    int M;
    int V;

    public Jewel(int M, int V) {
        this.M = M;
        this.V = V;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Jewel[] jewels = new Jewel[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(M, V);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            int weight = Integer.parseInt(br.readLine());
            bags[i] = weight;
        }
        Arrays.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return o1.M - o2.M;
            }
        });
        Arrays.sort(bags);

        long answer = 0;
        PriorityQueue<Jewel> q = new PriorityQueue<>(new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return o2.V - o1.V;
            }
        });

        int bagsIdx = 0;
        int jewelIdx = 0;
        while (jewelIdx < N && bagsIdx < K) {
            if (jewels[jewelIdx].M <= bags[bagsIdx]) {
                q.add(jewels[jewelIdx]);
                jewelIdx++;
            } else {
                if(!q.isEmpty()) answer += q.poll().V;
                bagsIdx++;
            }
        }
        while (bagsIdx < K) {
            if (!q.isEmpty()) answer += q.poll().V;
            else break;
            bagsIdx++;
        }


        System.out.println(answer);
    }
}
