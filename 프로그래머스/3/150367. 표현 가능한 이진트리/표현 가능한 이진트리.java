import java.util.*;
class Solution {
    static boolean isTree;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i=0; i<numbers.length;i++){
            long num = numbers[i];
            if(num == 0) {
                answer[i] = 0;
                continue;
            }
            int cnt =0;
            isTree = true;
            ArrayList<Boolean> arr = new ArrayList<>();
            while(num!=0){
                if(num%2 == 0)
                    arr.add(false);
                else if(num%2 == 1)
                    arr.add(true);
                num = num>>1;
                cnt++;
            }
            int n =1;
            int numAddZero = 0;
            while(true){
                if(cnt<n){
                    numAddZero = n-cnt;
                    break;
                }
                else if(cnt==n) break;
                cnt = cnt-n;
                n = n*2;
            }
            for(int j=0;j<numAddZero;j++){
                arr.add(false);
            }
            searchArr(arr,0,arr.size(),true);
            if(isTree) answer[i] = 1;
        }
        return answer;
    }
    public void searchArr(ArrayList<Boolean> arr, int start, int end, boolean P){
        if(end==start) return;
        int mid = (start+end)/2;
        if(arr.get(mid) == true && !P){
            isTree = false;
            return;
        }
        if(arr.get(mid) == false){
            searchArr(arr, start, mid,false);
            searchArr(arr, mid+1, end,false);
        }
        else{
            searchArr(arr, start, mid,P);
            searchArr(arr, mid+1, end,P);
        }
    }
        
}