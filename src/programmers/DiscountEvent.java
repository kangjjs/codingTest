package programmers;

import java.util.*;

public class DiscountEvent {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantList = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantList.put(want[i], number[i]);
        }

        int answer = 0;
        boolean flag = false;

        for (int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> cloneList = new HashMap<>(wantList);
            for (int j = i; j < i + 10; j++) {
                if (cloneList.containsKey(discount[j])) {
                    cloneList.put(discount[j], cloneList.get(discount[j]) - 1);
                    if (cloneList.get(discount[j]) == 0) {
                        cloneList.remove(discount[j]);
                    }
                } else {
                    break;
                }
            }
            if (cloneList.isEmpty()) {
                flag = true;
                answer++;
            }
        }

        return !flag ? 0 : answer;
    }
}
