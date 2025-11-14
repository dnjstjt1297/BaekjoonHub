import java.util.*;

class Solution {
    public int[] solution(String[] gems) {

        Set<String> unique = new HashSet<>(Arrays.asList(gems));
        int kind = unique.size();

        Map<String, Integer> map = new HashMap<>();

        int s = 0, e = 0;
        int bestLen = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (true) {
            if (map.size() == kind) {
                // 최소 구간 갱신
                if (e - s < bestLen) {
                    bestLen = e - s;
                    answer[0] = s + 1;
                    answer[1] = e;
                }

                // left 줄이기
                map.put(gems[s], map.get(gems[s]) - 1);
                if (map.get(gems[s]) == 0) map.remove(gems[s]);
                s++;
            }
            else {
                if (e == gems.length) break;
                map.put(gems[e], map.getOrDefault(gems[e], 0) + 1);
                e++;
            }
        }

        return answer;
    }
}
