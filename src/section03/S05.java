package section03;

import java.util.Scanner;

public class S05 {

    public int solution(int n){

        int answer=0,sum=0,lt=0;
        int k;

        if(n%2==0)
            k=n/2;
        else
            k=n/2+1;

        int [] arr =new int[k];

        for(int i=0;i<k;i++){
            arr[i]=i+1;
        }

        for(int i=0;i<k;i++){
            sum+=arr[i];
            if(sum==n)
                answer++;
            while(sum>=n){
                sum-=arr[lt++];
                if(sum==n)
                    answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        S05 T = new S05();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.print(T.solution(n));
    }
}
