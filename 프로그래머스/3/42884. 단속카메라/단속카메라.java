import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                if(o1[0]==o2[0])
                    return (o1[1]-o1[0])-(o2[1]-o2[0]);
                return o1[0]-o2[0];
            }
        });
        int start = routes[0][0];
        int end = routes[0][1];
        answer++;
        for(int[]e : routes){
            if(end<e[0]){
                start = e[0];
                end = e[1];
                answer++;
            }
            else{
                start = e[0];
                if(end>e[1])
                    end = e[1];
            }
        }               

        return answer;
    }
}