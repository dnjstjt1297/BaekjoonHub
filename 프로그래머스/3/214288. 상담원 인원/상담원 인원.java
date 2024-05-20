import java.util.*;

class Solution {
    
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int k, int n, int[][] reqs) {
        dfs(k,n, reqs, new int[k+1],1,0);
        return answer;
    }
    /**
    * dfs 알고리즘 사용
    * 1. 멘토를 n만큼 나누는 경우의 수를 구함
    * 2. 경우에 따라 기다린 시간 구하는 함수 호출
    */
    public void dfs(int k, int n, int[][] reqs, int[] peoples, int typeIdx, int cnt){
        if(typeIdx>k){
            if(cnt == n){
                answer = Math.min(answer,wait(k,reqs,peoples));
            }
            return;
        }
        for(int i=1; i<=n;i++){
            peoples[typeIdx] = i;
            dfs(k, n,reqs, peoples,typeIdx+1,cnt+i);
        }
    }
    /**
    * 기다린 시간 구하는 함수
    */
    public int wait(int k, int[][] reqs, int[] peoples) {
        int wtime = 0;
        
        PriorityQueue<Integer>[] pq = new PriorityQueue[k+1];
        for(int i=0;i<=k;i++) pq[i] = new PriorityQueue<>();
        
        for(int i=0;i<reqs.length;i++){
            if(peoples[reqs[i][2]]!=pq[reqs[i][2]].size()){
                pq[reqs[i][2]].add(reqs[i][0]+reqs[i][1]);    
                continue;
            }
            int mTime = pq[reqs[i][2]].poll();
            if(mTime<reqs[i][0]){
                pq[reqs[i][2]].add(reqs[i][0]+reqs[i][1]);
            }
            else {
                wtime += mTime - reqs[i][0];
                pq[reqs[i][2]].add(mTime+reqs[i][1]);
            }
        }
        return wtime;
    }
}