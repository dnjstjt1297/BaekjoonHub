import java.util.*;
class Solution {
    static ArrayList<int[]> combA;
    static ArrayList<int[]> combB;
    public int[] solution(int[][] dice) {
        int n = dice.length;
        int[] answer = new int[n/2];
        combA = new ArrayList<>();
        combB = new ArrayList<>();
        int[] arr = new int[n];
        for(int i=0; i<n;i++){
            arr[i] = i;
        }
        boolean[] visited = new boolean[n];
        comb(arr,visited,0,n,n/2);
        
        ArrayList<Integer> arrA;
        ArrayList<Integer> arrB;
        int maxNum = 0;
        int maxIdx = -1;
        for(int i=0; i<combA.size();i++){
            arrA = new ArrayList<>();
            arrB = new ArrayList<>();
            add(dice, arrA, combA.get(i), 0,0);
            add(dice, arrB, combB.get(i), 0,0);
            Collections.sort(arrA);
            Collections.sort(arrB);
            
            int numWin = 0;
            int start =0; 
            int end =arrB.size();    
            for(int j=0; j<arrA.size();j++){
                int target = arrA.get(j);
                int left = start;
                int right = end;
                boolean isSearch = false;
                while(left<right){
                    int mid = (left+right)/2;
                    if(arrB.get(mid)>=target){
                        if(arrB.get(mid)==target) isSearch = true;
                        right = mid;
                    }
                    else{
                        left = mid+1;
                    }
                }
                numWin+=left; 
            }
            if(maxNum<numWin){
                maxNum = numWin;
                maxIdx = i;
            }
        }
        for(int i=0;i<n/2;i++){
            answer[i] = combA.get(maxIdx)[i]+1;
        }
        
        return answer;
    }
    public void comb(int[] arr, boolean[] visited,int start, int n, int r){
        if(r==0){
            int[] tmp1 = new int[n/2];
            int[] tmp2 = new int[n/2];
            int idx1 = 0;
            int idx2 = 0;
            for(int i =0; i<n;i++){
                if(visited[i]){
                    tmp1[idx1]= i;
                    idx1++;
                }
                else{
                    tmp2[idx2]= i;
                    idx2++;
                }
            }
            combA.add(tmp1);
            combB.add(tmp2);
        }
        for(int i =start; i<n;i++){
            visited[i] = true;
            comb(arr,visited,i+1,n,r-1);
            visited[i] = false;
        }
    }
    public void add(int[][] dice, ArrayList<Integer> arr, int[] nums,int idx,int sum){
        if(idx==nums.length){
            arr.add(sum);
            return;
        }
        for(int i=0;i<6; i++){
            add(dice,arr,nums,idx+1,sum+dice[nums[idx]][i]);
        }
    }
    
    
}