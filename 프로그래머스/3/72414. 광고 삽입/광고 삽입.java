import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int playTime = toSecond(play_time);
        int advTime = toSecond(adv_time);
        long[] times = new long[playTime+1];
                
        
        for(int i = 0; i<logs.length; i++){
            String[] se = logs[i].split("-");
            int s = toSecond(se[0]);
            int e = toSecond(se[1]);
            times[s]++;
            times[e]--;
        }
        
        for(int i = 1; i< playTime+1; i++) times[i]+=times[i-1];
        for(int i = 1; i< playTime+1; i++) times[i]+=times[i-1];
        
        long max = times[advTime];
        int startTime = 0;

        for (int i = 1; i < playTime + 1 - advTime; i++) {
            long cur = times[advTime + i - 1] - times[i - 1];
            if (cur > max) {
                max = cur;
                startTime = i;
            }
        }
        
        return toTime(startTime);
        
    }
    
    public int toSecond(String time){
        String[] times = time.split(":");
        return Integer.parseInt(times[0])*60*60 +
            Integer.parseInt(times[1])*60+
            Integer.parseInt(times[2]);
    }
    
    public String toTime(int time){
        int H = (time/3600);
        int M = ((time%3600)/60);
        int S = ((time%3600)%60);
        
        return String.format("%02d:%02d:%02d", H, M, S);

    }
}