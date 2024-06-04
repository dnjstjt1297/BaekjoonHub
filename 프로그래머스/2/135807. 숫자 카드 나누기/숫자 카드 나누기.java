import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = gcd(arrayA);
        int gcdB = gcd(arrayB);
        
        ArrayList<Integer> measureA = measure(gcdA);
        ArrayList<Integer> measureB = measure(gcdB);
        
        int a = func(measureA,arrayB);
        int b = func(measureB,arrayA);
        
        answer = Math.max(a,b);
        
        return answer;
    }
    public int gcd(int[] arr){
        int result = arr[0];
        for(int i=1;i<arr.length;i++){
            int a = result;
            int b = arr[i];
            while(true){
                if(b==0){
                    result = a;
                    break;
                }
                int tmp = a;
                a = b;
                b = tmp%b;
            }
        }
        return result;
    }
    public ArrayList<Integer> measure(int num){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(num);i++){
            if(num%i==0) {
                result.add(i);
                if(i==num/i) continue;
                result.add(num/i);
            }
        }
        Collections.sort(result);
        return result;
    }
    public int func(ArrayList<Integer> measures, int[] array){
        int result = 0;
        for(int e: measures){
            boolean is_mod = false;
            for(int f: array){
                if(f%e==0){
                    is_mod = true;
                    break;
                }
            }
            if(!is_mod) result = Math.max(e,result);
        }
        return result;
    }
}