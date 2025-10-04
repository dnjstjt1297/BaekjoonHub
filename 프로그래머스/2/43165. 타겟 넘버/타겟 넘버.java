class Solution {
    public int solution(int[] numbers, int target) {
        dfs(numbers,target, 0, 0);
        return answer;
    }
    int answer = 0;
    public void dfs(int[] numbers, int target, int idx, int n){
        if(idx == numbers.length){
            if(target == n){
                answer++;
            }
            return;
        }
        dfs(numbers, target, idx+1, n+numbers[idx]);
        dfs(numbers, target, idx+1, n-numbers[idx]);
        
    }
}