import java.util.*;
class Solution {
    static final int LEN_T = 50;
    static int[][][] mergeTable;
    static String[][] table;
    
    public String[] solution(String[] commands) {
        String[] answer;
        mergeTable = new int[LEN_T+1][LEN_T+1][2];
        table = new String[LEN_T+1][LEN_T+1];
        ArrayList<String> ans = new ArrayList<>();
        for(int i=1; i<=LEN_T;i++){
            for(int j=1; j<=LEN_T;j++){
                mergeTable[i][j][0] = i;
                mergeTable[i][j][1] = j;
            }
        }
        for(int i=1; i<=LEN_T;i++){
            for(int j=1; j<=LEN_T;j++){
                table[i][j] = new String("EMPTY");
            }
        }
        for(String command: commands){
            String[] entrys = command.split(" ");
            if(entrys[0].equals("UPDATE")){
                if(entrys.length == 4) {
                    int r = Integer.parseInt(entrys[1]);
                    int c = Integer.parseInt(entrys[2]);
                    String value = new String(entrys[3]);
                    
                    updateOne(value,new int[]{r,c});
                    
                }
                else if(entrys.length == 3){
                    String valueOne = new String(entrys[1]);
                    String valueTwo = new String(entrys[2]);
                    updateTwo(valueOne,valueTwo);
                }
            }
            else if(entrys[0].equals("MERGE")){
                int r1 = Integer.parseInt(entrys[1]);
                int c1 = Integer.parseInt(entrys[2]);
                int r2 = Integer.parseInt(entrys[3]);
                int c2 = Integer.parseInt(entrys[4]);
                merge(new int[] {r1,c1},new int[]{r2,c2});
            }
            else if(entrys[0].equals("UNMERGE")){
                int r = Integer.parseInt(entrys[1]);
                int c = Integer.parseInt(entrys[2]);
                unmerge(new int[]{r,c});
            }
            else if(entrys[0].equals("PRINT")){
                int r = Integer.parseInt(entrys[1]);
                int c = Integer.parseInt(entrys[2]);
                int[] x = find(new int[]{r,c});
                ans.add(new String(table[x[0]][x[1]]));
            }
        }
        answer = new String[ans.size()];
        for(int i =0; i<ans.size();i++){
            answer[i] = new String(ans.get(i));
        }        
        return answer;
    }
    public int[] find(int[] x){
        if(mergeTable[x[0]][x[1]][0]==x[0]&&mergeTable[x[0]][x[1]][1]==x[1]){
            return x;
        }
        int[] p = new int[2];
        p[0] = mergeTable[x[0]][x[1]][0];
        p[1] = mergeTable[x[0]][x[1]][1];
        return find(p);
    }
    public void union(int[] x, int[] y){
        x = find(x);
        y = find(y);
        mergeTable[x[0]][x[1]][0] = mergeTable[y[0]][y[1]][0];
        mergeTable[x[0]][x[1]][1] = mergeTable[y[0]][y[1]][1];
    }
    public void merge(int[] x, int[] y){
        union(x,y);
        int[] p = find(x);
        if(!table[x[0]][x[1]].equals("EMPTY")){
            for(int i=1; i<=LEN_T;i++){
                for(int j=1; j<=LEN_T;j++){
                    int[] q = find(new int[] {i,j});
                    if(p[0] == q[0] && p[1] == q[1]){
                        table[i][j] = new String(table[x[0]][x[1]]);
                    }
                }
            }
        }
        else if(table[x[0]][x[1]].equals("EMPTY") && !table[y[0]][y[1]].equals("EMPTY")){
            for(int i=1; i<=LEN_T;i++){
                for(int j=1; j<=LEN_T;j++){
                    int[] q = find(new int[] {i,j});
                    if(p[0] == q[0] && p[1] == q[1]){
                        table[i][j] = new String(table[y[0]][y[1]]);
                    }
                }
            }
        }
    }
    public void updateOne(String value, int[] x){
        int[] nx = find(x);
        for(int i=1; i<=LEN_T;i++){
            for(int j=1; j<=LEN_T;j++){
                int[] ny = find(new int[] {i,j});
                if(ny[0] == nx[0] && ny[1] == nx[1]){
                    table[i][j] = new String(value);
                }
            }
        }
    }
    public void updateTwo(String valueOne, String valueTwo){
        for(int i=1; i<=LEN_T; i++){
            for(int j=1; j<=LEN_T; j++){
                if(table[i][j].equals(valueOne)){
                    table[i][j] = new String(valueTwo);
                }
            }
        }
    }
    public void unmerge (int[] x){
        String tmp = new String(table[x[0]][x[1]]);
        ArrayList<int[]> arr = new ArrayList<>();
        int[] nx = find(x);
        for(int i=1; i<=LEN_T;i++){
            for(int j=1; j<=LEN_T;j++){
                int[] ny = find(new int[] {i,j});
                if(ny[0] == nx[0] && ny[1] == nx[1]){
                    table[i][j] = new String("EMPTY");
                    arr.add(new int[]{i,j});
                }
            }
        }
        for(int[] e : arr){
            mergeTable[e[0]][e[1]][0] = e[0];
            mergeTable[e[0]][e[1]][1] = e[1];
        }
        table[x[0]][x[1]] = new String(tmp);
    }
}