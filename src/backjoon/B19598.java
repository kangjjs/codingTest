package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Meeting1 implements Comparable<Meeting1> {
    int st, et;

    public Meeting1(int st, int et) {
        this.st = st;
        this.et = et;
    }

    @Override
    public int compareTo(Meeting1 o) {
        if (this.st == o.st)
            return this.et - o.et;
        return this.st - o.st;
    }
}

public class B19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Meeting1> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting1(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(meetings);
        ArrayList<Integer> nowMeeting = new ArrayList<>();
        int ans = 1;
        nowMeeting.add(meetings.get(0).et);

        for (int i = 1; i < n; i++) {
            int st = meetings.get(i).st;
            int et = meetings.get(i).et;
            boolean flag = false;

            for (int j = 0; j < nowMeeting.size(); j++) {
                if(st>=nowMeeting.get(j)){
                    flag=true;
                    nowMeeting.remove(j);
                    nowMeeting.add(et);
                    break;
                }
            }

            if(!flag){
                ans++;
                nowMeeting.add(et);
            }
        }

        System.out.println(ans);
    }
}
