import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;  // N과 number가 같으면 바로 답은 1
        
        // dp[0]은 사용하지 않음, dp[1] ~ dp[8]은 N을 1번부터 8번까지 사용한 경우의 숫자들을 저장
        List<Set<Integer>> dp = new ArrayList<>();
        
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        dp.get(1).add(N);  // N을 1번 사용한 경우
        
        for (int i = 2; i <= 8; i++) {
            // i번 사용하는 경우를 만듬
            Set<Integer> curSet = dp.get(i);
            
            // j번 사용한 경우와 (i - j)번 사용한 경우를 합쳐서 만듬
            for (int j = 1; j < i; j++) {
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i - j);
                
                for (int num1 : set1) {
                    for (int num2 : set2) {
                        curSet.add(num1 + num2);
                        curSet.add(num1 - num2);
                        curSet.add(num1 * num2);
                        if (num2 != 0) curSet.add(num1 / num2);
                    }
                }
            }
            
            // 숫자 N을 i번 이어붙인 값도 추가 (ex: N=5 -> 55, 555 등)
            curSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            // 만약 현재 집합에 목표 숫자 number가 있다면 바로 정답 반환
            if (curSet.contains(number)) {
                return i;
            }
        }
        
        // 8번을 초과하면 만들 수 없음
        return -1;
    }
}