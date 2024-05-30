import java.util.*;

class Project implements Comparable<Project> {    
    String name;
    int start;
    int playtime;
    
    public Project(String name, int start, int playtime){
        this.name = name;
        this.start = start;
        this.playtime = playtime;
    }
    
    @Override
    public int compareTo(Project o1){
        return this.start - o1.start;
    }
}
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        PriorityQueue<Project> pq = new PriorityQueue<>();
        for(int i=0; i<plans.length; i++){
            String name = plans[i][0];
            String[] tokens = plans[i][1].split(":");
            int start = Integer.parseInt(tokens[0])*60+Integer.parseInt(tokens[1]);
            int playtime = Integer.parseInt(plans[i][2]);
            pq.add(new Project(name,start,playtime));
        }
        Stack<Project> s = new Stack<>();
        int starttime = 0;
        int endtime = 0;
        
        int idx = 0;
        while(!pq.isEmpty()){
            
            Project cur = pq.poll();
            
            endtime = cur.start;
            
            while(!s.isEmpty()){
                Project cur2 = s.pop();
                if(starttime+cur2.playtime<=endtime) {
                    starttime = starttime+cur2.playtime;
                    answer[idx++] = cur2.name;
                    
                    System.out.println();
                }
                else {
                    cur2.playtime = cur2.playtime-(endtime-starttime);
                    s.add(cur2);
                    break;
                }
                
            }
            
            starttime = cur.start;
            s.add(cur);
        }
        while(!s.isEmpty()){
            answer[idx++] = s.pop().name;
        }    
        return answer;
    }
}