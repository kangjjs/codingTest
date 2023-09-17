package ch02;

import java.time.LocalTime;
import java.util.*;

class Times implements Comparable<Times>{

    public String name;
    public int t;

    public Times(String name, int t){
        this.name=name;
        this.t=t;
    }

    @Override
    public int compareTo(Times o) {
        return this.t-o.t;
    }
}
class Ch06 {

    public int getTime(String time){
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);

        return h*60+m;
    }

    public String[] solution(String[] reports, String times){
        ArrayList<Times> time = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();

        for(String x: reports){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            int t = getTime(b);

            time.add(new Times(a,t));
        }

        Collections.sort(time);

        int st = getTime(times.split(" ")[0]);
        int et = getTime(times.split(" ")[1]);

        for(Times t : time){
            if(t.t >= st && t.t<=et)
                answer.add(t.name);
        }

        return answer.toArray(new String[0]);
    }

    public static void main(String[] args){
        Ch06 T = new Ch06();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
