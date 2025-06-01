import java.util.*;

class Solution {
    
    int[] parents;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parents = new int[n];
        for(int i=0;i<n;i++) parents[i] = i;
        
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });
        
        
        for(int i =0; i<costs.length; i++){
            if(find(costs[i][0]) == find(costs[i][1])){
                continue;
            }
            union(costs[i][0],costs[i][1]);
            answer+=costs[i][2];
        }
        
        return answer;
    }
    
    public int find(int n){
        if(parents[n]==n) return n;
        n = find(parents[n]);
        return n;
    }
    
    
    public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa<pb) parents[pb] = parents[pa];
        else parents[pa] = parents[pb];
    }
}