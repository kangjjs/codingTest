package ch02;

import java.util.*;

class Ch07 {

    public int time(String time) {
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        return h * 60 + m;
    }

    public String[] solution(String[] reports, int time) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, Integer> inT = new HashMap<>();
        HashMap<String, Integer> sumT = new HashMap<>();

        for(String x:reports){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            String c = x.split(" ")[2];
            if(c.equals("in"))
                inT.put(a, time(b));
            else
                sumT.put(a,sumT.getOrDefault(a,0)+(time(b)-inT.get(a)));
        }

        for(String name:sumT.keySet()){
            if(sumT.get(name)>time)
                answer.add(name);
        }

        Collections.sort(answer);

        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Ch07 T = new Ch07();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
