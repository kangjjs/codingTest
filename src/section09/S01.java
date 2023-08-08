package section09;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Athlete implements Comparable<Athlete>{
    public int h;
    public int w;

    public Athlete(int h, int w){
        this.w=w;
        this.h=h;
    }

    @Override
    public int compareTo(Athlete o) {
        return o.h-this.h;
    }
}

public class S01 {

    public int solution(ArrayList<Athlete> arrays){
        int answer=0;
        Collections.sort(arrays);
        int max=Integer.MIN_VALUE;

        for(Athlete a:arrays){
            if(a.w>max){
                max=a.w;
                answer++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int h,w;
        ArrayList<Athlete> athletes = new ArrayList<>();

        for(int i=0;i<n;i++){
            h=kb.nextInt();
            w=kb.nextInt();
            athletes.add(new Athlete(h,w));
        }


        System.out.print(T.solution(athletes));
    }
}
