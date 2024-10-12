class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String m = Integer.toString(n,k);
        String[] l = m.split("0+");
        
        for(String e : l){
            Long p = Long.parseLong(e);
            if(isPrime(p)) answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(long n) {
        if (n <= 1) return false;
        for (int i=2; i<=Math.sqrt(n); i++) if (n % i == 0) return false;
        return true;
    }
}