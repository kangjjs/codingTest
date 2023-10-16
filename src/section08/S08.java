package section08;

import java.util.*;

class S08 {

    static int n,m;
    static int [] b,p,ch;
    int [][] c = new int[35][35];
    boolean flag=false;

    public int combination(int n,int r){
        if(c[n][r]>0)
            return c[n][r];
        if(n==r||r==0)
            return 1;
        else
            return c[n][r]=combination(n-1,r-1)+combination(n-1,r);
    }

    public void solution(int l,int sum) {
        if(flag)
            return;
        if(l==n){
            if(sum==m){
                for(int x:p)
                    System.out.print(x+" ");
                flag=true;
            }
        }else{
            for(int i=1;i<=n;i++){
                if(ch[i]==0){
                    ch[i]=1;
                    p[l]=i;
                    solution(l+1,sum+b[l]*p[l]);
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

        b=new int[n];
        p=new int[n];
        ch=new int[n+1];

        for(int i=0;i<n;i++){
            b[i]= T.combination(n-1,i);
        }

        T.solution(0,0);
    }
}
