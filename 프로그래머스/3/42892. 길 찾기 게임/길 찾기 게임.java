import java.util.*;

class Solution {
    int[][] nodeinfo;
    int n;  
    ArrayList<Integer> preorder = new ArrayList<>();
    ArrayList<Integer> postorder = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        this.nodeinfo = nodeinfo;
        this.n = nodeinfo.length;
        
        int[][] answer = new int[2][n];
        int[][] arr = new int[n][3];
        for(int i = 0; i<n; i++){
            arr[i][0] = nodeinfo[i][0];
            arr[i][1] = nodeinfo[i][1];
            arr[i][2] = i+1;
        }
        Arrays.sort(arr, (o1,o2)-> o1[0]-o2[0]);
        
        getOrder(arr,0,n-1);
        for(int i = 0; i<n; i++){
            answer[0][i] = preorder.get(i);
            answer[1][i] = postorder.get(i);
        }
        
        return answer;
    }

    
    public void getOrder(int[][] arr, int s, int e){
        if(s>e) return;
        
        int maxH = -1;
        int idx = 0;
        for(int i = s; i<=e ; i++){
            if(arr[i][1]>maxH){
                maxH = arr[i][1];
                idx = i;
            }
        }
        preorder.add(arr[idx][2]);
        getOrder(arr, s, idx-1);
        getOrder(arr, idx+1, e);
        postorder.add(arr[idx][2]);
    }
}