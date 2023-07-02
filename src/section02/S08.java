package section02;

import java.util.Scanner;

public class S08 {

    public int [] solution(int [] arr){

        int n=arr.length;
        int [] answer =new int[n];

        for(int i=0;i<n;i++){
            answer[i]=1;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i]<arr[j])
                    answer[i]++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        S08 T = new S08();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for(int x: T.solution(arr))
            System.out.print(x+" ");
    }
}
