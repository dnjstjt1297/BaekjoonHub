import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        
        dfs(info,0,n,m,0,0);
        
        
        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
    
    int answer = Integer.MAX_VALUE;
    Set<String> set = new HashSet<>();
    
    public void dfs(int[][] info, int idx, int n, int m, int a, int b){
        if(idx==info.length){
            if(answer>a) answer = a;
            return;
        }
        
        String key = a+","+b+","+idx;
        if(set.contains(key)){
            return;
        }
        
        if(a+info[idx][0] < n) dfs(info, idx+1, n, m, a+info[idx][0], b);
        
        if(b+info[idx][1] < m) dfs(info, idx+1,n, m, a, b+info[idx][1]);
        
        set.add(key);
    }
}