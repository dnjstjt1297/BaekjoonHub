import java.util.*;

class Node{
    
    String url;
    double basicScore;
    double linkScore = 0;
    int idx;
    List<String> links = new ArrayList<>();
    public Node(String url, double basicScore,List<String> links, int idx){
        this.url = url;
        this.basicScore = basicScore;
        this.links = links;
        this.idx = idx;
    }
}

class Solution {
    
    public int solution(String word, String[] pages) {
        int answer = 0;
        List<Node> list = new ArrayList<>();
        
        for(int i = 0; i<pages.length; i++){
            String url = "";
            
            urlBreak : for(int j = 0; j<pages[i].length()-5;j++){
                if(pages[i].substring(j,j+5).equals("<head")){
                    for(int k = j+5; k< pages[i].length() - 23; k++){
                        if(pages[i].substring(k,k+23).equals("<meta property=\"og:url\"")){
                            for(int p = k+25; p< pages[i].length()-8; p++){
                                if(pages[i].substring(p, p+8).equals("https://")){
                                    for(int q = p+8; q<pages[i].length(); q++){
                                        if(pages[i].charAt(q)=='\"') break urlBreak;
                                        url+=pages[i].charAt(q);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            int basicScore = 0;
            
            String[] token = pages[i].split("[^a-zA-Z]");
            
            for(String t : token){
                if(t.toLowerCase().equals(word.toLowerCase())){
                    basicScore++;
                }
            }
            
            List<String> links = new ArrayList<>();
            
            for(int j = 0; j<pages[i].length()-2; j++){
                if(pages[i].substring(j,j+2).equals("<a")){
                    String link = "";
                    linkBreak : for(int k = j+2; k< pages[i].length()-8; k++){
                        if(pages[i].substring(k, k+8).equals("https://")){
                            for(int p = k+8; p< pages[i].length(); p++){
                                if(pages[i].charAt(p) == '\"') break linkBreak;
                                link+=pages[i].charAt(p);
                            }
                        }
                    }
                    links.add(link);
                }
            }
            
            Node node = new Node(url, basicScore, links, i);
            list.add(node);
        }
        
        for(Node node : list){
            
            for(String link : node.links){
                for(Node lnode : list){
                    if(link.equals(lnode.url)){
                        lnode.linkScore+=node.basicScore/node.links.size();
                        break;
                    }
                }
            }
        }
        
        double max = 0;
        for(Node node : list){
            double totalScore = node.basicScore+ node.linkScore;
            if(totalScore > max){
                max = totalScore;
                answer = node.idx;
            }
            else if(totalScore> max){
                if(answer<node.idx){
                    answer = node.idx;
                }
            }
        }
        
        return answer;
    }
    
    
}