
class Solution {
    int min = Integer.MAX_VALUE;
    public int solution(int[][] cost, int[][] hint) {
        int answer = 0;
        
        for(int i = 0; i<hint.length;i++){
            for(int j=1; j<hint[i].length; j++){
                hint[i][j]--;
            }
        }
        
        int[] cntHint = new int[cost.length];
        
        dfs(cost,hint, cntHint, 0,0);
        answer = min;
        
        return answer;
    }
    
    private void dfs(int[][] cost, int[][] hint, int[] cntHint, int idx, int sum){
        if(idx>=cost.length){
            min = Math.min(min,sum);
            return;
        }
        
        
        dfs(cost,hint,cntHint,idx+1,sum+cost[idx][cntHint[idx]]);
        if(idx>hint.length-1){
            return;
        }
        
        int[] cntHintCopy = new int[cost.length];
        for(int i =0; i< cntHint.length;i++){
            cntHintCopy[i] = cntHint[i];
        }
        
        for(int i = 1; i<hint[idx].length; i++){
            if(cntHintCopy[hint[idx][i]]<cost[idx].length-1) cntHintCopy[hint[idx][i]]++;
        }
        
        dfs(cost,hint,cntHintCopy,idx+1,sum+cost[idx][cntHint[idx]]+hint[idx][0]);
    }
}