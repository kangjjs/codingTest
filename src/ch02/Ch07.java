package ch02;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

class Ch07 {
    public String[] solution(String[] reports, int time) {

        HashMap<String, ArrayList<LocalTime>> hm = new HashMap<>();
        ArrayList<String> overMember = new ArrayList<>();

        for (String report : reports) {
            String name = report.split(" ")[0];
            LocalTime t = LocalTime.parse(report.split(" ")[1]);
            hm.putIfAbsent(name, new ArrayList<>());
            hm.get(name).add(t);
        }

        for (String name : hm.keySet()) {
            ArrayList<LocalTime> localTimes = hm.get(name);
            long minutes = 0;

            for (int i = 0; i < localTimes.size(); i += 2) {
                LocalTime inTime = localTimes.get(i);
                LocalTime outTime = localTimes.get(i + 1);
                Duration duration = Duration.between(inTime, outTime);
                minutes += duration.toMinutes();
            }

            if (minutes > time) {
                overMember.add(name);
            }
        }

        overMember.sort(String::compareTo);
        String[] answer = new String[overMember.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = overMember.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch07 T = new Ch07();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
