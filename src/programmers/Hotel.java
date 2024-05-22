package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Hotel {
    static class Book implements Comparable<Book>{
        int st,et;

        public Book(int st, int et){
            this.st=st;
            this.et=et;
        }

        @Override
        public int compareTo(Book o){
            if(this.st==o.st)
                return this.et-o.et;
            return this.st-o.st;
        }
    }

    static int convertTime(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);

        return hour*60+minute;
    }

    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Book> pq = new PriorityQueue<>();
        PriorityQueue<Integer> end = new PriorityQueue<>();
        for(String[] bookTime:book_time){
            int st = convertTime(bookTime[0]);
            int et = convertTime(bookTime[1])+10;
            pq.offer(new Book(st,et));
        }

        while(!pq.isEmpty()){
            Book cur = pq.poll();
            if(!end.isEmpty()){
                while(!end.isEmpty()&&cur.st>=end.peek()){
                    end.poll();
                }
            }
            end.offer(cur.et);
            answer= Math.max(answer,end.size());
        }

        return answer;
    }
}
