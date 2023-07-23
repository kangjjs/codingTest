package section08;

import java.util.Scanner;

public class S08 {

    static int n,m;
    static int [] b,p,ch;
    boolean flag = false;
    int [][] dy= new int [35][35];

    public int C(int n, int r){
        if(dy[n][r]>0) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r] = C(n-1,r-1)+ C(n-1,r);
    }

    public void solution(int k,int sum){
        if(flag)
            return;
        if(k==n){
            if(sum==m){
                for(int x : p){
                    System.out.print(x+" ");
                }
                flag=true;
            }
        }else{
            for(int i=1;i<=n;i++){
                if(ch[i]==0){
                    ch[i]=1;
                    p[k]=i;
                    solution(k+1,sum+p[k]*b[k]);
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        S08 T = new S08();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();

        b=new int[n];
        p=new int[n];
        ch=new int[n+1];

        for(int i=0;i<n;i++){
            b[i]=T.C(n-1,i);
        }

        T.solution(0,0);
    }
}
