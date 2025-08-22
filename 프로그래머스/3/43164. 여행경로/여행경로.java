import java.util.*;

class Solution {
    String[] answer;
    boolean[] visited;
    boolean found = false;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        visited = new boolean[tickets.length];
        List<String> path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN", tickets, path, 0);
        return answer;
    }

    void dfs(String cur, String[][] tickets, List<String> path, int used) {
        if (found) return; // 이미 정답 찾음 (사전순 최소 보장)

        if (used == tickets.length) {
            answer = path.toArray(new String[0]);
            found = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, path, used + 1);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
