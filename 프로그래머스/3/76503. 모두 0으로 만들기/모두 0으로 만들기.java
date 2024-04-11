import java.util.*;



class Solution {
    public long solution(int[] a, int[][] edges) {
        long answer = 0;
        ArrayList<Integer>[] tree = new ArrayList[a.length];
        for(int i=0;i<a.length;i++) tree[i] = new ArrayList<>();
        for(int[] e: edges){
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }
        long[] n = new long[a.length];
        for(int i=0; i<a.length;i++){
            n[i] = a[i];
        }
        
        int start =0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,0});
        PriorityQueue<int[]> leaf = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o2[1]- o1[1];
            }
        });
        
        boolean[] visited = new boolean[a.length];
        while(!q.isEmpty()){
            int[] cur = q.poll();
            visited[cur[0]] = true;
            boolean is_leaf = true;
            for(int e: tree[cur[0]]){
                if(visited[e])  continue;
                q.add(new int[]{e,cur[1]+1});
                is_leaf = false;
            }
            if(is_leaf){
                leaf.add(new int[]{cur[0],cur[1]});
            }
        }
        
        visited = new boolean[a.length];
        while(!leaf.isEmpty()){
            int[] cur = leaf.poll();
            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;
            for(int e: tree[cur[0]]){
                if(visited[e]) continue;
                int next = e;
                n[next]+=n[cur[0]];
                answer+=Math.abs(n[cur[0]]);
                leaf.add(new int[]{next,cur[1]-1});
                break;
            }
        }
        if(n[start]!=0) answer = -1;
        

        return answer;
    }
}