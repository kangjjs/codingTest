package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Lecture implements Comparable<Lecture> {
    public int st, et;

    public Lecture(int st, int et) {
        this.st = st;
        this.et = et;
    }

    @Override
    public int compareTo(Lecture o) {
        if (this.st == o.st)
            return this.et - o.et;
        return this.st - o.st;
    }
}

public class B11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Lecture> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arrayList.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(arrayList);
        PriorityQueue<Integer> queue =new PriorityQueue<>();
        int et=0;
        for (Lecture lecture : arrayList) {
            et = lecture.et;

            if(!queue.isEmpty() && queue.peek() <= lecture.st)
                queue.poll();
            queue.offer(et);
        }

        System.out.println(queue.size());
    }
}
