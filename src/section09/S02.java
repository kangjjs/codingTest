package section09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Meeting implements Comparable<Meeting>{
    public int st;
    public int et;

    public Meeting(int st,int et){
        this.st=st;
        this.et=et;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.et==o.et)
            return this.st-o.st;
        else
            return this.et-o.et;
    }
}
public class S02 {

    public int solution(ArrayList<Meeting> meetings){
        Collections.sort(meetings);

        int et=0;
        int answer=0;

        for(Meeting m:meetings){
            if(m.st>=et){
                et=m.et;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        ArrayList<Meeting> meetings = new ArrayList<>();

        for(int i=0;i<n;i++){
            int st=kb.nextInt();
            int et=kb.nextInt();
            meetings.add(new Meeting(st,et));
        }

        System.out.print(T.solution(meetings));
    }
}
