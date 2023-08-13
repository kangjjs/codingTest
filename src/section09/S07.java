package section09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Edges implements Comparable<Edges>{

    public int v1;
    public int v2;
    public int cost;

    public Edges(int v1,int v2,int cost){
        this.v1=v1;
        this.v2=v2;
        this.cost=cost;
    }

    @Override
    public int compareTo(Edges o) {
        return this.cost-o.cost;
    }
}
public class S07 {


    static int[] unf;

    public static int Find(int v){
        if(v==unf[v])
            return v;
        else
            return unf[v]=Find(unf[v]);
    }

    public static void Union(int a,int b){
        int fa=Find(a);
        int fb=Find(b);
        if(fa!=fb)
            unf[fa]=fb;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();
        ArrayList<Edges> arr=new ArrayList<>();
        unf=new int[n+1];

        for(int i=1;i<=n;i++){
            unf[i]=i;
        }

        for(int i=0;i<m;i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            int c=kb.nextInt();

            arr.add(new Edges(a,b,c));
        }

        int answer=0;
        Collections.sort(arr);


        for(Edges e : arr){
            int f1=Find(e.v1);
            int f2=Find(e.v2);

            if(f1!=f2)  {
                answer+=e.cost;
                Union(f1,f2);
            }
        }

        System.out.print(answer);
    }
}
