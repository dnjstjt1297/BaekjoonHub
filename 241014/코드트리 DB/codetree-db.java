import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());

        HashMap<String, Integer> DB = init();

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
    public static HashMap<String, Integer> init(){
        return new HashMap<String,Integer>();
    }

    public static void insert(HashMap<String,Integer> DB, String name, Integer value){
        if(DB.containsKey(name)) System.out.println(0);
        else{
            for(String s : DB.keySet()){
                if(DB.get(s).equals(value)){
                    System.out.println(0);
                    return;
                }
            }
            DB.put(name,value);
            System.out.println(1);
        }
    }

    public static void delete(HashMap<String,Integer> DB, String name){
        if(!DB.containsKey(name)) System.out.println(0);
        else{
            System.out.println(DB.get(name));
            DB.remove(name);
        }
    }

    public static void rank(HashMap<String,Integer> DB, Integer k){
        List<String> names = new ArrayList<>(DB.keySet());
        
        if(names.size()<k){
            System.out.println("None");
            return;
        }

        Collections.sort(names, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return DB.get(o1)-DB.get(o2);
            }
        });

        System.out.println(names.get(k-1));
        return;
    }
    
    public static void sum(HashMap<String,Integer> DB, Integer k){
        List<String> names = new ArrayList<>(DB.keySet());
        
        long result = 0;
        for(String name: DB.keySet()){
            if(DB.get(name)<=k) result+=DB.get(name);
        }

        System.out.println(result);
    }

}