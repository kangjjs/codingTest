package programmers;

import java.util.*;

public class DoingTask {
    static int convertTime(String time) {
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        return 60 * h + m;
    }

    static class Task implements Comparable<Task> {
        String subject;
        int time, playtime;

        public Task(String subject, int time, int playtime) {
            this.subject = subject;
            this.time = time;
            this.playtime = playtime;
        }

        @Override
        public int compareTo(Task o) {
            if(this.time == o.time)
                return this.playtime - o.playtime;
            return this.time - o.time;
        }
    }

    public String[] solution(String[][] plans) {
        Stack<Task> st = new Stack<>();
        List<Task> list = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for (String[] plan : plans) {
            String title = plan[0];
            int time = convertTime(plan[1]);
            int playtime = Integer.parseInt(plan[2]);
            list.add(new Task(title, time, playtime));
        }
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            Task cur = list.get(i);
            Task next = list.get(i + 1);
            int et = cur.time + cur.playtime;
            if (et > next.time) {
                cur.playtime = et - next.time;
                st.push(cur);
                continue;
            }
            ans.add(cur.subject);
            int res = next.time - et;
            while (!st.isEmpty() && res>0) {
                Task peek = st.peek();
                if(peek.playtime>res){
                    st.peek().playtime-=res;
                    break;
                }else{
                    res-=peek.playtime;
                    ans.add(st.pop().subject);
                }
            }
        }

        ans.add(list.get(list.size()-1).subject);
        while (!st.isEmpty()) {
            ans.add(st.pop().subject);
        }

        return ans.toArray(new String[0]);
    }
}
