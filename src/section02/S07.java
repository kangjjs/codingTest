package section02;

import java.util.Scanner;

public class S07 {

    public int solution(int [] arr){
        int answer=0,count=0;

        for (int x : arr) {
            if (x == 1)
                count++;
            else
                count = 0;
            answer += count;
        }

        return answer;
    }

    public static void main(String[] args) {
        S07 T = new S07();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr =new int[n];

        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
        }

        System.out.print(T.solution(arr));
    }
}
