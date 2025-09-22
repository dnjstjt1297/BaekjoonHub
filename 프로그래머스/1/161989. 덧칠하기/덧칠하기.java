class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int max = 0;

        for(int sec : section){
            if (max <= sec) {
                max = sec + m;
                answer++;
            }
        }
        return answer;
    }
}