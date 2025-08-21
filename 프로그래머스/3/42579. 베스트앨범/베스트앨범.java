import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        int N = genres.length;
        Map<String, ArrayList<int[]>> map = new HashMap<>();
        
        for(int i = 0; i<N; i++){
            map.put(genres[i], new ArrayList<>());
        }
        
        for(int i=0; i<N; i++){
            List<int[]> list = map.get(genres[i]);
            list.add(new int[]{i, plays[i]});
        }
        
        List<String> keySet = new ArrayList<>(map.keySet());
        
        Collections.sort(keySet, (o1, o2) -> {
            int sum1 = 0;
            for(int[] p : map.get(o1)) sum1+=p[1];
            
            int sum2 = 0;
            for(int[] p : map.get(o2)) sum2+=p[1];
            
            return sum2-sum1;
        });
        
        ArrayList<Integer> album = new ArrayList<>();
        for(String key : keySet){
            Collections.sort(map.get(key), (o1,o2) ->{
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o2[1]-o1[1];
            });
            
            album.add(map.get(key).get(0)[0]);
            if(map.get(key).size() >=2) album.add(map.get(key).get(1)[0]);
        }
        
        answer = new int[album.size()];
        for(int i = 0; i<album.size(); i++){
            answer[i] = album.get(i);
        }
        
        return answer;
    }
}