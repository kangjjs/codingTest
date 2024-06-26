package section09;

import java.util.Scanner;

public class S06 {

    static int [] unf;
    public static int Find(int v){
        if(v==unf[v])
            return v;
        else
            return unf[v]=Find(unf[v]);
    }

    public static void Union(int a,int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb)
            unf[fa]=fb;
    }

    public static void main(String[] args) {
        S06 T = new S06();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n+1];
        for(int i=0;i<=n;i++){
            unf[i]=i;
        }

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            Union(a,b);
        }

        int a = kb.nextInt();
        int b = kb.nextInt();
        int fa = Find(a);
        int fb = Find(b);

        if(fa==fb)
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}
