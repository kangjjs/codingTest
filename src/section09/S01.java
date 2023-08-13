package section09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Body implements Comparable<Body>{

    public int h;
    public int w;

    public Body(int h,int w){
        this.h=h;
        this.w=w;
    }

    @Override
    public int compareTo(Body o) {
        return o.h-this.h;
    }
}
public class S01 {

    public int solution(ArrayList<Body> bodies){
        Collections.sort(bodies);

        int max=Integer.MIN_VALUE;
        int answer=0;

        for(Body b : bodies){
            if(b.w>max){
                max=b.w;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        ArrayList<Body> bodies = new ArrayList<>();

        for(int i=0;i<n;i++){
            int h=kb.nextInt();
            int w=kb.nextInt();
            bodies.add(new Body(h,w));
        }

        System.out.print(T.solution(bodies));
    }
}
