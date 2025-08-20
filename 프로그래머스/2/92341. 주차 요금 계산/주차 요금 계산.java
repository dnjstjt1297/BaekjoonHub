import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        
        Map<Integer, Integer> inMap = new HashMap<>();
        Map<Integer, Integer> resMap = new HashMap<>();
        
        for(String record : records){
            String[] token = record.split(" ");
            
            String[] HHMM = token[0].split(":");
            int h = Integer.parseInt(HHMM[0]);
            int m = h*60+Integer.parseInt(HHMM[1]);
            int carNum = Integer.parseInt(token[1]);
            
            if(token[2].equals("IN")){
                inMap.put(carNum, m);
            }
            else{
                int inM = inMap.get(carNum);
                int cm = m-inM;
                
                Integer pm = resMap.getOrDefault(carNum, 0);
                resMap.put(carNum,pm+cm);

                inMap.remove(carNum);
            }
        }
        
        for(Integer carNum : inMap.keySet()){
            int inM = inMap.get(carNum);
            int cm = 23*60+59 - inM;
            Integer pm = resMap.getOrDefault(carNum, 0);
            resMap.put(carNum,pm+cm);
            
        }
        
        List<Integer> carNums = new ArrayList<>(resMap.keySet());
        Collections.sort(carNums);
        answer = new int[carNums.size()];
        
        for(int i = 0; i< carNums.size(); i++){
            int cost = (resMap.get(carNums.get(i))-fees[0])/fees[2]*fees[3]
                        +fees[1];
            if((resMap.get(carNums.get(i))-fees[0])%fees[2]>0){
                cost+=fees[3];
            }
            if(cost<fees[1]){
                cost = fees[1];
            }
            answer[i] = cost;    
        }
        
        return answer;
        
    }
}