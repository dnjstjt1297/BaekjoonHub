import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Line{
    long x1, y1, x2, y2;
    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

}

public class Main {
    static int[] parent;
    static Line[] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        lines = new Line[N];
        parent = new int[N];
        for(int i = 0; i < N; i++) parent[i] = i;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            lines[i] = new Line(x1, y1, x2, y2);
        }


        for(int i = 0; i < N; i++) {
            for(int j=0;j<i;j++){
                if(cross(lines[i],lines[j])){
                    union(i,j);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int groupnum = 0;
        int[] counts = new int[N];
        for(int i = 0; i<N;i++) {
            if(find(i) == i)  groupnum++;
            counts[find(i)]++;
            max = Math.max(max, counts[find(i)]);
        }
        System.out.println(groupnum);
        System.out.println(max);
    }

    public static boolean cross(Line l1, Line l2) {

        long c1 = ccw(l1.x1, l1.y1, l1.x2, l1.y2, l2.x1, l2.y1) *ccw(l1.x1,l1.y1,l1.x2,l1.y2,l2.x2,l2.y2);
        long c2 = ccw(l2.x1,l2.y1,l2.x2,l2.y2,l1.x1,l1.y1)*ccw(l2.x1,l2.y1,l2.x2,l2.y2,l1.x2,l1.y2);


        if(c1==0 && c2==0) {
            long l1x = Math.abs(l1.x2-l1.x1);
            long l1y = Math.abs(l1.y2-l1.y1);

            long l2x = Math.abs(l2.x2-l2.x1);
            long l2y = Math.abs(l2.y2-l2.y1);

            long minx = Math.min(l1.x1,l1.x2);
            minx = Math.min(minx,l2.x1);
            minx = Math.min(minx,l2.x2);
            long maxx = Math.max(l1.x1,l1.x2);
            maxx = Math.max(maxx,l2.x1);
            maxx = Math.max(maxx,l2.x2);


            long miny = Math.min(l1.y1,l1.y2);
            miny = Math.min(miny,l2.y1);
            miny = Math.min(miny,l2.y2);
            long maxy = Math.max(l1.y1,l1.y2);
            maxy = Math.max(maxy,l2.y1);
            maxy = Math.max(maxy,l2.y2);

            long tx = maxx-minx;
            long ty = maxy-miny;

            if(tx<=l1x+l2x && ty<=l1y+l2y) return true;
            return false;
        }
        else if(c1<=0 && c2<=0) return true;
        else return false;
    }

    public static long ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        return x1*y2+x2*y3+x3*y1 - x2*y1-x3*y2-x1*y3;
    }

    public static int find(int n){
        if(parent[n]==n) return n;
        n = find(parent[n]);
        return n;
    }

    public static void union(int a, int b){
        int na = find(a);
        int nb = find(b);
        if(a < b) parent[nb] = na;
        else parent[na] = nb;
    }
}