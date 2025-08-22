import java.util.*;


class Node{
    String word;
    int num;
    
    public Node(String word, int num){
        this.word = word;
        this.num = num;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean [words.length];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.num-o2.num);
        
        pq.add(new Node(begin,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.word.equals(target)){
                return cur.num;
            }
            
            for(int i =0 ; i<words.length; i++){
                if(visited[i]) continue;
                if(isNext(cur.word, words[i])){
                    visited[i] = true;
                    pq.add(new Node(words[i],cur.num+1));
                }
            }
            
        }
        
        return 0;
    }
    
    private boolean isNext(String str1, String str2){
        
        boolean isDiff = false;
        for(int i = 0; i<str1.length(); i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                if(isDiff) return false;
                isDiff = true;
            }
        }
        if(!isDiff) return false;
        return true;
    }
}