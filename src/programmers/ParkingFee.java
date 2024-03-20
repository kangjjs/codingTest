package programmers;

import java.util.*;

// 2022카카오
public class ParkingFee {

    public int getTime(String time) {
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);

        return 60 * h + m;
    }

    public int[] solution(int[] fees, String[] records) {

        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<String, Integer> ans = new HashMap<>();

        for (String record : records) {
            int time = getTime(record.split(" ")[0]);
            String number = record.split(" ")[1];
            String state = record.split(" ")[2];

            if (state.equals("IN")) {
                hm.put(number, time);
            } else if (state.equals("OUT")) {
                int t = time - hm.get(number);
                hm.remove(number);
                ans.put(number, ans.getOrDefault(number, 0) + t);
            }
        }

        if (!hm.isEmpty()) {
            for (String num : hm.keySet()) {
                int time = getTime("23:59");
                int t = time - hm.get(num);
                ans.put(num, ans.getOrDefault(num, 0) + t);
            }
        }

        List<String> keySet = new ArrayList<>(ans.keySet());
        Collections.sort(keySet);

        int a = fees[0];
        int b = fees[1];
        int c = fees[2];
        int d = fees[3];
        int[] answer = new int[ans.size()];
        int i = 0;

        for (String num : keySet) {
            int price;
            if (ans.get(num) <= a) {
                price = b;
            } else {
                price = b + (int)Math.ceil((double)(ans.get(num) - a) / c) * d;
            }
            answer[i++] = price;
        }

        return answer;
    }

    public static void main(String[] args) {
        ParkingFee T = new ParkingFee();
        int [] fees ={180,5000,10,600};
        String [] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(T.solution(fees, records)));
    }
}
