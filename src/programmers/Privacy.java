package programmers;
import java.util.*;

public class Privacy {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String,Integer> hm = new HashMap<>();
        for(String term:terms){
            hm.put(term.split(" ")[0],Integer.parseInt(term.split(" ")[1]));
        }

        int year = Integer.parseInt(today.split("\\.")[0]);
        int month = Integer.parseInt(today.split("\\.")[1]);
        int day = Integer.parseInt(today.split("\\.")[2]);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<privacies.length;i++){
            String date = privacies[i].split(" ")[0];
            int v = hm.get(privacies[i].split(" ")[1]) * 28;

            int n = (year - Integer.parseInt(date.split("\\.")[0]))*28*12
                    + (month - Integer.parseInt(date.split("\\.")[1]))*28
                    + (day - Integer.parseInt(date.split("\\.")[2]));
            if(n>=v){
                list.add(i+1);
            }
        }

        return list.stream().filter(Objects::nonNull).mapToInt(i->i).toArray();
    }
}
