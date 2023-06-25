package ch02;

import java.time.LocalTime;
import java.util.*;
class Ch06 {
    public String[] solution(String[] reports, String times){

        HashMap<String, LocalTime> hm =new HashMap<>();
        ArrayList<String> member = new ArrayList<>();

        for(String report : reports){
            String name =report.split(" ")[0];
            LocalTime time = LocalTime.parse(report.split(" ")[1]);

            hm.put(name,time);
        }

        LocalTime startTime = LocalTime.parse(times.split(" ")[0]);
        LocalTime endTime = LocalTime.parse(times.split(" ")[1]);

        for(String name: hm.keySet()){
            if((hm.get(name).isAfter(startTime)&&hm.get(name).isBefore(endTime))||hm.get(name).equals(startTime)||hm.get(name).equals(endTime)) {
                member.add(name);
            }
        }

        member.sort(Comparator.comparing(hm::get));
        String [] answer =new String[member.size()];

        for(int i=0;i<answer.length;i++){
            answer[i]=member.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        Ch06 T = new Ch06();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
