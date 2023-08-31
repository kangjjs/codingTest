package section10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Top implements Comparable<Top>{
    public int a;
    public int h;
    public int w;

    public Top(int a,int h,int w){
        this.a=a;
        this.h=h;
        this.w=w;
    }

    @Override
    public int compareTo(Top o) {
        return o.a-this.a;
    }
}
public class S04 {

    static int [] dy;
    static ArrayList<Top> tops=new ArrayList<>();

    public int solution(){
        Collections.sort(tops);

        dy[0]=tops.get(0).h;
        int answer=tops.get(0).h;

        for(int i=1;i<tops.size();i++){
            int max=0;

            for(int j=i-1;j>=0;j--){
                if(tops.get(j).w>tops.get(i).w && dy[j]>max){
                    max=dy[j];
                }
            }
            dy[i]=max+tops.get(i).h;
            answer=Math.max(answer,dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        S04 T = new S04();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        dy=new int[n];

        for(int i=0;i<n;i++){
            int a=kb.nextInt();
            int h=kb.nextInt();
            int w=kb.nextInt();
            tops.add(new Top(a,h,w));
        }

        System.out.println(T.solution());
    }
}
