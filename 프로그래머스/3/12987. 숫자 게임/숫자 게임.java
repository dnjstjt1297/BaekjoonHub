import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int j = 0;
        for(int i =0; i<A.length;i++){
            if(j>=A.length) break;
            if(A[i]<B[j]){
                j++;
                answer++;
            }
            else{
                i-=1;
                j++;
            }
        }
        return answer;
    }
}