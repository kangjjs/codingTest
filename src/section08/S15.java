package section08;

import java.util.ArrayList;
import java.util.Scanner;

public class S15 {

    static int n,m,len,answer=Integer.MAX_VALUE;
    static int [] c;
    static ArrayList<Point> hs,pz;

    public void solution(int l,int s){
        if(l==m){
            int sum=0;

            for(Point p:hs){
                int dis=Integer.MAX_VALUE;
                for(int i:c){
                    dis=Math.min(dis,Math.abs(p.x-pz.get(i).x)+Math.abs(p.y-pz.get(i).y));
                }
                sum+=dis;
            }
            answer=Math.min(sum,answer);
        }else{
            for(int i=s;i<len;i++){
                c[l]=i;
                solution(l+1,i+1);
            }
        }
    }

    public static void main(String[] args) {
        S15 T = new S15();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt();
        m=kb.nextInt();

        hs=new ArrayList<>();
        pz=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int tmp=kb.nextInt();

                if(tmp==1)
                    hs.add(new Point(i,j));
                else if(tmp==2)
                    pz.add(new Point(i,j));
            }
        }

        len = pz.size();
        c=new int[m];
        T.solution(0,0);
        System.out.print(answer);
    }
}
