import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        ArrayList<Double> result = new ArrayList<>();
        ArrayList<Integer> collatz = calculateCollatz(k);
        
        for(int[] e: ranges){
            result.add(integral(collatz,e[0],e[1]));
        }
        
        double[] answer = new double[result.size()];
        for(int i = 0; i<result.size();i++) answer[i] = result.get(i);
        
        return answer;
    }
    
    public ArrayList<Integer> calculateCollatz(int k){
        ArrayList<Integer> result = new ArrayList<>();
        while(true){
            result.add(k);
            if(k==1) break;
            
            if(k%2==0) k=k/2;
            else k=k*3+1;
        }
        
        return result;
    }
    
    public double integral(ArrayList<Integer> collatz, int a, int b){
        double result = 0;
        
        int n = collatz.size()-1;
        int start = a;
        int end = n+b;
        
        for(int i=start; i<end;i++){
            double area = (double)(collatz.get(i)+collatz.get(i+1))/2;
            result+=area;
        }
        
        if(start>end) result = -1;
        
        return result;
    }
    
    
}