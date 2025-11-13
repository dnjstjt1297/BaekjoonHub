import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> datas = new ArrayList<>();
            
        for(String operation : operations){
            String[] tokens = operation.split(" ");
            String command = tokens[0];
            Integer data = Integer.parseInt(tokens[1]);
            
            if(command.equals("I")){
                datas.add(data);
                Collections.sort(datas);
            }
            else if(command.equals("D")){
                if(data == 1){
                    if(!datas.isEmpty()){
                        datas.remove(datas.size()-1);
                    }
                }
                else if(data == -1){
                    if(!datas.isEmpty()){
                        datas.remove(0);
                    }
                }
            }
        }
        if(datas.isEmpty()) return new int[]{0,0};
        else return new int[]{datas.get(datas.size()-1),datas.get(0)};
    }
    
}