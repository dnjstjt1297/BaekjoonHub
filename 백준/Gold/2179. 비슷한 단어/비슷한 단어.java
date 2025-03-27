import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = new String[n];

        for (int i = 0; i < n; i++) {
            strs[i] = br.readLine();
        }

        int maxPrefix = -1;
        int idx1 = -1, idx2 = -1;

        for (int i = 0; i < n; i++) {
            String s1 = strs[i];
            for (int j = i + 1; j < n; j++) {
                String s2 = strs[j];
                int len = commonPrefixLength(s1, s2);

                if (len > maxPrefix) {
                    maxPrefix = len;
                    idx1 = i;
                    idx2 = j;
                } else if (len == maxPrefix) {
                    // 입력 순서 기준 우선
                    if (i < idx1 || (i == idx1 && j < idx2)) {
                        idx1 = i;
                        idx2 = j;
                    }
                }
            }
        }

        System.out.println(strs[idx1]);
        System.out.println(strs[idx2]);
    }

    static int commonPrefixLength(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int i = 0;
        while (i < len && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        return i;
    }
}
