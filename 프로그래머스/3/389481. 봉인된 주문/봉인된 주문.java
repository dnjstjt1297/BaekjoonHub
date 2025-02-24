import java.util.*;

class Solution {
    
    public String solution(long n, String[] bans) {
        long[] longBans = toLongBans(bans);
        Arrays.sort(longBans);
        
        int tmp = 0;
        for(int i = 0; i<longBans.length;i++){
            if(longBans[i]-tmp<=n){
                tmp++;
            }
            else break;
        }
        return toStr(n+tmp);
    }
    
    public long[] toLongBans(String[] bans){
        long[] result = new long[bans.length];
        for(int i = 0; i<bans.length;i++){
            result[i] = toLong(bans[i]);
        }
        return result;
    }
    
    public long toLong(String ban){
        long result = 0;
        for(int i =ban.length()-1; i>=0; i--){
            result+=(ban.charAt(i)-'a'+1)*Math.pow('z'-'a'+1,ban.length()-1-i);
        }
        return result;
    }
    
    public String toStr(Long n){
        StringBuilder sb = new StringBuilder();
        
        while(n>0){
            char p = (char)((int)(n%('z'-'a'+1))+'a');
            if(p=='a'){
                p = 'z';
                n--;
            }
            else p --;
            sb.append(p);
            n/='z'-'a'+1;
        }
        
        return sb.reverse().toString();
    }
}