import java.io.*;
import java.util.*;

public class Main {
    static int count; // 팀에 속한 학생 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1]; // 1-indexed
            boolean[] visited = new boolean[n + 1];
            boolean[] finished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i, arr, visited, finished);
                }
            }

            System.out.println(n - count); // 팀에 속하지 못한 학생 수 출력
        }
    }

    public static void dfs(int now, int[] arr, boolean[] visited, boolean[] finished) {
        visited[now] = true;
        int next = arr[now];

        if (!visited[next]) {
            dfs(next, arr, visited, finished);
        } else if (!finished[next]) {
            // 사이클 발견
            int temp = next;
            count++; // 현재 노드 포함
            while (temp != now) {
                temp = arr[temp];
                count++;
            }
        }

        finished[now] = true;
    }
}
