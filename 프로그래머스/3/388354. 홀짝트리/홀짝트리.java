import java.util.*;

class Solution {
    final int INF = 1000001; 
    int[] answer = new int[2];
    
    public int[] solution(int[] nodes, int[][] edges) {
        List<Integer>[] forest = makeForest(nodes,edges);
        
        
        List<List<Integer>> group = makeGroup(forest,nodes);
        int[] childs = getChilds(nodes, edges);
        
        for(List<Integer> treeNodes : group){
            findEOTree(childs,treeNodes);
        }
        
        return answer;
    }
    
    public List<Integer>[] makeForest(int[] nodes, int[][] edges){
        List<Integer>[] forest = new ArrayList[INF];
        
        for(int node: nodes)
            forest[node] = new ArrayList<>();
        
        for(int[] edge : edges){
            forest[edge[0]].add(edge[1]);
            forest[edge[1]].add(edge[0]);
        }
        return forest;
    }
    
    public List<List<Integer>> makeGroup(List<Integer>[] forest, int[] nodes){
        boolean[] visited = new boolean[INF];
        List<List<Integer>> group = new ArrayList<>();
        
        for(int node : nodes){
            if(visited[node]) continue;
            List<Integer> g = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(node);
            g.add(node);
            visited[node] = true;

            while(!q.isEmpty()){
                int cur = q.poll();
                
                for(int next: forest[cur]){
                    if(visited[next]) continue;
                    q.add(next);
                    g.add(next);
                    visited[next] = true;
                }
            }
            group.add(g);
        }
        
        return group;
    }
    
    public int[] getChilds(int[] nodes, int[][] edges){
        int[] childs = new int[INF];
        
        for(int[] edge: edges){
            childs[edge[0]]++;
            childs[edge[1]]++;
        }
        
        return childs;
    }
    
    public void findEOTree(int[] childs, List<Integer> treeNodes){
        int EOcnt = 0;
        int REOcnt = 0;
        
        for(int treeNode : treeNodes){
            if(treeNode%2==0){
                if((childs[treeNode]-1)%2==0)REOcnt++;
                else EOcnt++;
            }    
            else{
                if((childs[treeNode]-1)%2!=0)REOcnt++;
                else EOcnt++;
            }
        }
        if(EOcnt==1) answer[0]++;
        if(REOcnt==1) answer[1]++;
    }
}