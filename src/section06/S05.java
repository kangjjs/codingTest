package section06;

import java.util.Arrays;
import java.util.Scanner;

public class S05 {

    public String solution(int n,int [] arr){
        String answer ="U";
        Arrays.sort(arr);

        for(int i=0;i<n-1;i++){
            if(arr[i]==arr[i+1]) {
                answer="D";
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        S05 T = new S05();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.solution(n,arr));
    }
}
