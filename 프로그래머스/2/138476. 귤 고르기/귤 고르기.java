import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int cnt = 1;
        for(int i=1;i<tangerine.length;i++){
            if(tangerine[i]==tangerine[i-1]){
                cnt+=1;
            }
            else{
                pq.add(cnt);
                cnt = 1;
            }
        }
        pq.add(cnt);
        
        int n = tangerine.length;
        while(!pq.isEmpty()){
            int cur = pq.poll();
            n-=cur;
            if(n==k){
                answer = pq.size();
                break;
            }
            else if(n<k){
                answer = pq.size()+1;
                break;
            }
            
        }
        
        
        
        return answer;
    }
}