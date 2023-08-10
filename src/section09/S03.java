package section09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Friend implements Comparable<Friend>{
    public int t;
    public char s;

    public Friend(int t,char s){
        this.t=t;
        this.s=s;
    }


    @Override
    public int compareTo(Friend o) {
            if(this.t==o.t)
                return this.s-o.s;
            else
                return this.t-o.t;
    }
}

public class S03 {

    public int solution(ArrayList<Friend> friends){
        Collections.sort(friends);
        int count=0;
        int answer= Integer.MIN_VALUE;

        for(Friend f:friends){
            if(f.s=='s')
                count++;
            else
                count--;
            answer=Math.max(answer,count);
        }

        return answer;
    }

    public static void main(String[] args) {
        S03 T = new S03();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        ArrayList<Friend> friends = new ArrayList<>();

        for(int i=0;i<n;i++){
            int at=kb.nextInt();
            int lt=kb.nextInt();
            friends.add(new Friend(at,'s'));
            friends.add(new Friend(lt,'e'));
        }

        System.out.println(T.solution(friends));
    }
}
