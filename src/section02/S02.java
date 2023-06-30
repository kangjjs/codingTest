package section02;

import java.util.Scanner;

public class S02 {

    public int solution(int [] arr){

        int count=0;
        int max=0;
        for (int x : arr) {
            if (max < x) {
                max = x;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);
        int n =kb.nextInt();
        int [] arr =new int[n];

        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
        }
        System.out.print(T.solution(arr));
    }
}
