package section09;

import java.util.Scanner;

public class S06 {

    static int [] unf;

    public static int find(int v){
        if(v==unf[v])
            return v;
        else
            return unf[v]=find(unf[v]);
    }

    public static void Union(int x,int y){
        int fx=find(x);
        int fy=find(y);
        if(fx!=fy)
            unf[fx]=fy;
    }

    public static void main(String[] args) {
        S06 T = new S06();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        unf=new int[n+1];

        for(int i=1;i<=n;i++){
            unf[i]=i;
        }

        for(int i=0;i<m;i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            Union(a,b);
        }

        int a=kb.nextInt();
        int b=kb.nextInt();
        int fa=find(a);
        int fb=find(b);

        if(fa==fb)
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}