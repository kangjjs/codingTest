package ch02;

import java.util.*;

class Ch06 {

    public int time(String time) {
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);

        return h * 60 + m;
    }

    public static class People implements Comparable<People> {
        public String name;
        public int time;

        public People(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(People o) {
            return this.time - o.time;
        }
    }

    public String[] solution(String[] reports, String times) {
        ArrayList<People> peoples = new ArrayList<>();

        for (String x : reports) {
            String name = x.split(" ")[0];
            int time = time(x.split(" ")[1]);
            peoples.add(new People(name, time));
        }

        Collections.sort(peoples);

        int st = time(times.split(" ")[0]);
        int et = time(times.split(" ")[1]);
        ArrayList<String> answer = new ArrayList<>();

        for (People p : peoples) {
            if (st <= p.time && p.time <= et) {
                answer.add(p.name);
            }

            if (p.time > et)
                break;
        }

        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Ch06 T = new Ch06();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
