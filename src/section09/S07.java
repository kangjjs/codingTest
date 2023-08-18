package section09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edges implements Comparable<Edges>{
    public int x;
    public int y;
    public int c;

    public Edges(int x,int y,int c){
        this.x=x;
        this.y=y;
        this.c=c;
    }

    @Override
    public int compareTo(Edges o) {
        return this.c-o.c;
    }
}

public class S07 {

    static int [] dis;

    public static int find(int x){
        if(x==dis[x])
            return x;
        else
            return dis[x]=find(dis[x]);
    }

    public static void union(int x,int y){
        int fx=find(x);
        int fy=find(y);
        if(fx!=fy)
            dis[fx]=fy;
    }


    public static void main(String[] args) {
        S07 T = new S07();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();

        dis=new int[n+1];

        for(int i=1;i<=n;i++){
            dis[i]=i;
        }

        ArrayList<Edges> edges = new ArrayList<>();

        for(int i=0;i<m;i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            int c=kb.nextInt();
            edges.add(new Edges(a,b,c));
        }

        int answer=0;
        Collections.sort(edges);

        for(Edges e:edges){
            int fx=find(e.x);
            int fy=find(e.y);
            if(fx!=fy){
                answer+=e.c;
                union(e.x,e.y);
            }
        }

        System.out.print(answer);
    }
}
