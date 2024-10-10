import java.util.*;
class Solution {
    public String[] solution(String[] expressions) {
        ArrayList<String> answer = new ArrayList<>();
        
        int minBase = 0;
        
        for(int i = 0; i < expressions.length; i++){
            String[] tokens = expressions[i].split(" ");
            for(int j =0; j<tokens[0].length();j++){
                minBase = Math.max(minBase,tokens[0].charAt(j)-'0');
            }
            for(int j =0; j<tokens[2].length();j++){
                minBase = Math.max(minBase,tokens[2].charAt(j)-'0');
            }
            if(!tokens[4].equals("X")){
                for(int j =0; j<tokens[4].length();j++){
                    minBase = Math.max(minBase,tokens[4].charAt(j)-'0');
                }
            }   
        }
        minBase = minBase+1;
        
        boolean[] visited = new boolean[10];
        for(int i=0;i<minBase;i++) visited[i] = true;
        
        
        for(int j= minBase; j<=9;j++){
            boolean tmp = false;
            
            for(int i = 0; i < expressions.length; i++){
                String[] tokens = expressions[i].split(" ");
                
                if(!tokens[4].equals("X")) {
                    if(!check(tokens[0],tokens[2],tokens[4],tokens[1],j)) tmp = true;
                }
            }
            if(tmp) visited[j] = true;
        }
        
        
        
        int num = 0;
        for(int i =2; i<=9;i++){
            if(!visited[i]) num++;
        }
        
        int base = 0;
        if(num==1){
            for(int i =2; i<=9;i++){
                if(!visited[i]){
                    base = i;
                    break;
                }
            }
        }
        
        for(int i = 0; i < expressions.length; i++){
            String[] tokens = expressions[i].split(" ");
            if(tokens[4].equals("X")) {
                String result = tokens[0]+" "+ tokens[1]+" "+tokens[2]+" "+tokens[3]+" ";
                if(base!=0){
                    Integer C = baseToDec(tokens[0],base);
                    if(tokens[1].equals("+")){
                        C += baseToDec(tokens[2],base);
                    }
                    else {
                        C -= baseToDec(tokens[2],base);
                    }
                    
                    result += Integer.toString(C,base);
                }
                else{
                    int k = 0;
                    boolean tmp = true;
                    while(true){
                        if(tokens[0].length()-1-k<0) break;
                        if(tokens[2].length()-1-k<0) break;
                        int a = tokens[0].charAt(tokens[0].length()-1-k)-'0';
                        int b = tokens[2].charAt(tokens[2].length()-1-k)-'0';
                        if(tokens[1].equals("+")){
                            if(a+b>=minBase) tmp = false;
                        }
                        if(tokens[1].equals("-")){
                            if(a-b<0) tmp = false;
                        }
                        k++;
                    }
                    if(!tmp){
                        result += "?";
                    }
                    else{
                        if(tokens[1].equals("+")){
                            Integer C = Integer.parseInt(tokens[0])+Integer.parseInt(tokens[2]);
                            result+=C.toString();
                        }
                        if(tokens[1].equals("-")){
                            Integer C = Integer.parseInt(tokens[0])-Integer.parseInt(tokens[2]);
                            result+=C.toString();
                        }
                    }
                }
                answer.add(result);
            }
        }
        
        
        System.out.println(num+" "+minBase);
        
        String[] ans = new String[answer.size()];
        answer.toArray(ans);
        
        return ans;
    }
    
    public boolean check(String A, String B, String C, String op, int base){
        int a=baseToDec(A,base);
        int b=baseToDec(B,base);
        int c=baseToDec(C,base);
        
        if(op.equals("+")){
            if((a+b) == c) return true;
            else return false;
        }
        else{
            if((a-b) == c) return true;
            else return false;
        }
    }
    
    public int baseToDec(String A, int base){
        int a = 0;
        int k = 1;
        for(int i=A.length()-1;i>=0;i--){
            a = a+k*(A.charAt(i)-'0');
            k=k*base;
        }
        return a;
    }
    
}