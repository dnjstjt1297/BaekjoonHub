import java.util.*;
import java.io.*;

class Entry{
    String name;
    int value;
    public Entry(String name, int value){
        this.name = name;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());

        ArrayList<Entry> DB = init();

        for(int i=0;i<Q;i++){
            String[] command = br.readLine().split(" ");
            
            if(command[0].equals("init")){
                DB = init();
            } 
            else if(command[0].equals("insert")){
                insert(DB,command[1],Integer.parseInt(command[2]));
            }
            else if(command[0].equals("delete")){
                delete(DB,command[1]);
            }
            else if(command[0].equals("rank")){
                rank(DB,Integer.parseInt(command[1]));
            }
            else if(command[0].equals("sum")){
                sum(DB,Integer.parseInt(command[1]));
            }
        }

    }
    public static ArrayList<Entry> init(){
        return new ArrayList<Entry>();
    }

    public static void insert(ArrayList<Entry> DB, String name, Integer value){
        for(Entry e: DB){
            if(e.name.equals(name) || e.value == value){
                System.out.println(0);
                return;
            }
        }
        DB.add(new Entry(name,value));
        System.out.println(1);
    }

    public static void delete(ArrayList<Entry> DB, String name){
        for(Entry e: DB){
            if(e.name.equals(name)){
                System.out.println(1);
                DB.remove(e);
                return;
            }
        }
        System.out.println(0);
    }

    public static void rank(ArrayList<Entry> DB, Integer k){
        Collections.sort(DB, new Comparator<Entry>(){
            @Override
            public int compare(Entry o1, Entry o2){
                return o1.value-o2.value;
            }
        });
        if(DB.size()<k){
            System.out.println("None");
            return;
        }
        System.out.println(DB.get(k-1).name);
        return;
    }
    
    public static void sum(ArrayList<Entry> DB, Integer k){
        Collections.sort(DB, new Comparator<Entry>(){
            @Override
            public int compare(Entry o1, Entry o2){
                return o1.value-o2.value;
            }
        });
        long result = 0;
        for(Entry e : DB){
            if(e.value<=k) result+=e.value;
            else break;
        }

        System.out.println(result);
    }

}