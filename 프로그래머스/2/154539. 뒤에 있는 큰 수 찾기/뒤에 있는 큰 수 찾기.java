import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        
        answer[n-1] = -1;
        for(int i=n-1;i>=0;i--){
            int result = -1;
            
            for(int j=i+1;j<n;j++){
                if(numbers[i]<numbers[j]){
                    result = numbers[j];
                    break;
                }
                else{
                    if(answer[j] == -1){
                        result = -1;
                        break;
                    }
                    else if(answer[j]>numbers[i]){
                        result = answer[j];
                        break;
                    }
                }
        
            }
            answer[i] = result;
        }
        
        
        return answer;
    }
}