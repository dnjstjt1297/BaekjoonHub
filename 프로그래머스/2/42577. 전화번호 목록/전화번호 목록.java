import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        boolean answer = true;
        
        Set<String> set = new HashSet<>();
        for(String p : phoneBook){
            set.add(p);
        }
        
        for(int i =0;i<phoneBook.length; i++){
            for(int j =  1; j<phoneBook[i].length(); j++){
                if(set.contains(phoneBook[i].substring(0,j))) answer = false;    
            }
        }
        
        return answer;
    }
}