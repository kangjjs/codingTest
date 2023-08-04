package section08;

import java.util.Scanner;

public class S09 {

    static int n,m;
    static int [] arr,ch;

    public void solution(int l,int k){
        if(l==m){
            for(int x:arr)
                System.out.print(x+" ");
            System.out.println();
        }else{
            for(int i=k;i<=n;i++){
                arr[l]=i;
                solution(l+1,i+1);
            }
        }
    }

    public static void main(String[] args) {
        S09 T = new S09();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();
        ch=new int[n+1];
        arr=new int[m];
        T.solution(0,1);
    }
}
