package section09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {
    int st,et;

    public Meeting(int st, int et){
        this.st=st;
        this.et=et;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.et==o.et) return this.st-o.st;
        else return this.et-o.et;
    }
}
public class S02 {
    public int solution(ArrayList<Meeting> meetings){
        Collections.sort(meetings);
        int count=0;
        int et=0;

        for(Meeting m:meetings){
            System.out.println(m.st+" "+m.et);
            if(m.st>=et){
                et=m.et;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        int st,et;
        ArrayList<Meeting> m =new ArrayList<>();

        for(int i=0;i<n;i++){
            st=kb.nextInt();
            et=kb.nextInt();
            m.add(new Meeting(st,et));
        }

        System.out.print(T.solution(m));
    }
}
