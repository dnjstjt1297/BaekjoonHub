import java.util.*;

class Solution {
    boolean[] visited;
    Set<String> set = new HashSet<>();
    int n;

    public int solution(String[] userId, String[] bannedId) {
        visited = new boolean[userId.length];
        n = bannedId.length;

        dfs(userId, bannedId, 0, new ArrayList<>());
        return set.size();
    }

    public void dfs(String[] userId, String[] bannedId, int idx, List<Integer> selected){
        if(idx == n){
            List<Integer> sorted = new ArrayList<>(selected);
            Collections.sort(sorted);
            set.add(sorted.toString());
            return;
        }

        for(int i = 0; i < userId.length; i++){
            if(visited[i]) continue;
            if(userId[i].length() != bannedId[idx].length()) continue;

            boolean isBan = true;
            for(int j = 0; j < bannedId[idx].length(); j++){
                if(bannedId[idx].charAt(j) == '*') continue;
                if(userId[i].charAt(j) != bannedId[idx].charAt(j)){
                    isBan = false;
                    break;
                }
            }

            if(isBan){
                visited[i] = true;
                selected.add(i);

                dfs(userId, bannedId, idx + 1, selected);

                selected.remove(selected.size() - 1);
                visited[i] = false;
            }
        }
    }
}
