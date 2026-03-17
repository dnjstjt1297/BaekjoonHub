import java.util.*;

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        int time = 0;
        
        Deque<int[]> q = new LinkedList<>();
        
        int idx = 0;
        int curWeights = 0;
        
        while(true){
            time++;
            
            if(!q.isEmpty()){
                int[] cur = q.pollLast();
                if(time-cur[1] < bridgeLength) q.addLast(cur);
                else curWeights -= cur[0];    
            }
            
            if(q.size()<bridgeLength && idx<truckWeights.length && curWeights+truckWeights[idx]<=weight){
                q.addFirst(new int[]{truckWeights[idx],time});
                curWeights+=truckWeights[idx];
                idx++;
            }
            
            if(q.isEmpty()) break;
        }
            
            
        return time;
    }
}