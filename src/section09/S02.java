package section09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {

    public int st;
    public int et;

    public Meeting(int st, int et) {
        this.st = st;
        this.et = et;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.et==o.et)
            return this.st-o.et;
        else
            return this.et-o.et;
    }
}

class S02 {

    public int solution(int n, ArrayList<Meeting> arrayList) {
        int answer=1;

        Collections.sort(arrayList);
        int et=arrayList.get(0).et;

        for(int i=1;i<n;i++){
            if(et<=arrayList.get(i).st){
                et=arrayList.get(i).et;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        ArrayList<Meeting> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int st = kb.nextInt();
            int et = kb.nextInt();
            arrayList.add(new Meeting(st, et));
        }

        System.out.print(T.solution(n, arrayList));
    }
}
