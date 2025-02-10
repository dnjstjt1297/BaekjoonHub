

import java.util.Scanner;

public class Main{

    static int N;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = i+1;

        do{
            print();
        }while(nextPermutation(arr));
    }
    public static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        while(i>0 && arr[i-1]>=arr[i]) i--;

        if(i==0) return false;

        int j = N-1;
        while(arr[i-1]>=arr[j]) j--;

        swap(i-1,j);

        int k = N-1;
        while(i<k) swap(i++,k--);

        return true;
    }

    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void print(){
        for(int i=0; i<N; i++) System.out.print(arr[i]+" ");
        System.out.println();
    }

}
