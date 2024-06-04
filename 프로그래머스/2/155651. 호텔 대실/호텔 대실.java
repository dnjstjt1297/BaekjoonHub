import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] times = new int[book_time.length][2];
        for(int i=0;i<book_time.length;i++){
            String s = book_time[i][0];
            String e = book_time[i][1];
            String[] st = s.split(":");
            String[] et = e.split(":");
            times[i][0] = Integer.parseInt(st[0])*60+Integer.parseInt(st[1]);
            times[i][1] = Integer.parseInt(et[0])*60+Integer.parseInt(et[1]);
        }
        
        Arrays.sort(times, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<times.length;i++){
            if(!pq.isEmpty()){
                int next = pq.poll();
                if(next>times[i][0]){
                    pq.add(next);
                    answer++;
                }
            }
            else answer++;
            pq.add(times[i][1]+10);
        }
        
        
        
        return answer;
    }
}