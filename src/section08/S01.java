package section08;

import java.util.Arrays;
import java.util.Scanner;

public class S01 {

    static int n,sum=0;
    static int [] arr;
    static boolean flag=false;

    public void solution(int l,int s){
        if(flag)
            return;
        if(s>sum/2)
            return;
        if(l==n){
            if(sum-s==s)
                flag=true;
        }
        else{
            solution(l+1,s+arr[l]);
            solution(l+1,s);
        }
    }

    public static void main(String[] args) {
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);

        n =kb.nextInt();
        arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= kb.nextInt();
            sum+=arr[i];
        }

        Arrays.sort(arr);
        T.solution(0,0);

        if(flag)
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}
