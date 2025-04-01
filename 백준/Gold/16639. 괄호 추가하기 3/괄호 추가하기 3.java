import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String line = br.readLine();

        long[] nums = Arrays.stream(line.split("[*\\-+]"))
                .mapToLong(Long::parseLong)
                .toArray();

        char[] cmds = line.replaceAll("[0-9]", "").toCharArray();

        int k = nums.length;

        long[][] maxDp = new long[k][k];
        long[][] minDp = new long[k][k];

        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                minDp[i][j] = Integer.MAX_VALUE;
                maxDp[i][j] = Integer.MIN_VALUE;
            }
        }

        for(int i =0; i<k; i++){
            maxDp[i][i] = nums[i];
            minDp[i][i] = nums[i];
            if(i<k-1){
                maxDp[i][i+1] = runCmd(cmds[i], nums[i], nums[i+1]);
                minDp[i][i+1] = runCmd(cmds[i], nums[i], nums[i+1]);
            }

        }


        for(int i = 2; i < k; i++){

            for(int j = 0; j<k-i; j++){

                for(int p = 0; p<i; p++){
                    maxDp[j][j+i] = Math.max(maxDp[j][j+i], runCmd(cmds[j+p], maxDp[j][j+p], maxDp[j+p+1][j+i]));
                    maxDp[j][j+i] = Math.max(maxDp[j][j+i], runCmd(cmds[j+p], maxDp[j][j+p], minDp[j+p+1][j+i]));
                    maxDp[j][j+i] = Math.max(maxDp[j][j+i], runCmd(cmds[j+p], minDp[j][j+p], maxDp[j+p+1][j+i]));
                    maxDp[j][j+i] = Math.max(maxDp[j][j+i], runCmd(cmds[j+p], minDp[j][j+p], minDp[j+p+1][j+i]));

                    minDp[j][j+i] = Math.min(minDp[j][j+i], runCmd(cmds[j+p], minDp[j][j+p], minDp[j+p+1][j+i]));
                    minDp[j][j+i] = Math.min(minDp[j][j+i], runCmd(cmds[j+p], maxDp[j][j+p], minDp[j+p+1][j+i]));
                    minDp[j][j+i] = Math.min(minDp[j][j+i], runCmd(cmds[j+p], minDp[j][j+p], maxDp[j+p+1][j+i]));
                    minDp[j][j+i] = Math.min(minDp[j][j+i], runCmd(cmds[j+p], maxDp[j][j+p], maxDp[j+p+1][j+i]));
                }
            }
        }

        System.out.println(maxDp[0][k-1]);
    }

    public static long runCmd(char cmd, long num1, long num2){
        if(cmd == '+') return num1 + num2;
        else if(cmd == '-') return num1 - num2;
        else if(cmd == '*') return num1 * num2;
        return 0;
    }
}
