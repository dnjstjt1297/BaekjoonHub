import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<int[]> persons = new ArrayList<>();
        ArrayList<int[]> chickens = new ArrayList<>();
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<N;j++){
                int input = Integer.parseInt(st.nextToken());
                if(input==2) chickens.add(new int[]{i,j});
                else if(input==1) persons.add(new int[]{i,j});
            }
        }

        int[] seq = new int[chickens.size()];
        for(int i = chickens.size()-1; i>= chickens.size()-M;i--) seq[i] = 1;

        int result = Integer.MAX_VALUE;
        do{
            int chickenLength = findChickenLength(persons,chickens,seq);
            result = Math.min(result,chickenLength);
        }while(nextPermutation(seq));

        System.out.println(result);
    }

    public static int findChickenLength(ArrayList<int[]> persons, ArrayList<int[]> chickens, int[] seq) {
        int result = 0;

        for(int i = 0 ; i < persons.size() ; i++){
            int minLength = Integer.MAX_VALUE;
            for(int j = 0 ; j < seq.length ; j++){
                if(seq[j]!=1)continue;
                int length = Math.abs(chickens.get(j)[0] - persons.get(i)[0]) + Math.abs(chickens.get(j)[1] - persons.get(i)[1]);
                minLength = Math.min(minLength, length);
            }
            result+=minLength;
        }
        return result;
    }

    public static boolean nextPermutation(int[] nums) {
        int i = nums.length-1;
        while(i>0 && nums[i-1]>=nums[i]) i--;
        if(i==0) return false;

        int j = nums.length-1;
        while(nums[i-1]>=nums[j]) j--;
        swap(nums,i-1,j);

        int k = nums.length-1;
        while(i<k) swap(nums,i++,k--);
        return true;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}