import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });
        int n = priorities.length;
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(new int[]{i,priorities[i]});
            pq.add(priorities[i]);
        }
        
        int max = pq.poll();
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(max!=cur[1]){
                q.add(cur);
            }
            else{
                answer++;
                if(location==cur[0]){
                    break;
                }
                max=pq.poll();
            }
        }
        
        return answer;
    }
}