import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = br.readLine();
        }

        String answer = "";

        for(int i = 0; i<strs[0].length(); i++){
            boolean isMatch = true;
            char p = strs[0].charAt(i);
            for(int j = 1; j<strs.length; j++){
                if(strs[j].charAt(i) != p){
                    isMatch = false;
                }
            }
            if(isMatch){ answer += strs[0].charAt(i); }
            else { answer += '?'; }
        }
        System.out.println(answer);
    }
}
