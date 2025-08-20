class Solution {
    int[] answer = {-1};
    int maxDiff = 0;

    public int[] solution(int n, int[] info) {
        dfs(info, new int[11], 0, n, 0);
        
        return answer;
    }

    public void dfs(int[] apach, int[] laion, int idx, int n, int diff){
        if(idx == 11){
            if(n > 0) laion[10] += n; 
            if(diff > 0) {
                if(diff > maxDiff){
                    maxDiff = diff;
                    answer = laion.clone();
                } else if(diff == maxDiff){
                    
                    for(int i=10; i>=0; i--){
                        if(answer[i] < laion[i]){
                            answer = laion.clone();
                            break;
                        } else if(answer[i] > laion[i]){
                            break;
                        }
                    }
                }
            }
            if(n > 0) laion[10] -= n; 
            return;
        }
        int need = apach[idx] + 1;
        if(n >= need){
            laion[idx] = need;
            dfs(apach, laion, idx+1, n-need, diff+10-idx);
            laion[idx] = 0;
        }
        dfs(apach, laion, idx+1, n, diff-(apach[idx] > 0 ? 10-idx : 0));
    }
}
