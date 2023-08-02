package section08;

import java.util.Scanner;

public class S08 {

    static int n,m;
    static int [] arr,a,ch;
    boolean flag=false;

    public int C(int c,int r){
        if (c == r || r==0)
            return 1;
        else if (r == 1)
            return c;
        else
            return C(c - 1, r - 1) + C(c - 1, r);
    }

    public void solution(int l,int sum){
        if(flag)
            return;
        if(l==n){
            if(sum==m){
                for(int x:a)
                    System.out.print(x+" ");
                flag=true;
            }
        }else{
            for(int i=1;i<=n;i++){
                if(ch[i]==0){
                    ch[i]=1;
                    a[l]=i;
                    solution(l+1,sum+(a[l]*arr[l]));
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        S08 T = new S08();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt();
        m=kb.nextInt();

        a=new int[n];
        arr=new int[n];
        ch=new int[n+1];

        for(int i=0;i<n;i++){
            arr[i]=T.C(n-1,i);
        }

        T.solution(0,0);
    }
}
