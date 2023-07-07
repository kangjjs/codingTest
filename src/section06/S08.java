package section06;

import java.util.Arrays;
import java.util.Scanner;

public class S08 {

    public int solution(int n,int m,int [] arr){
        Arrays.sort(arr);
        int answer = 0;

        for(int i=0;i<n;i++){
            if(m==arr[i]){
                answer=i+1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        S08 T = new S08();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m  =kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.solution(n,m,arr));
    }
}
