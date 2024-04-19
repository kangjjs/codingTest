package programmers;

import java.util.*;

class KakaoGift {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            hm.put(friends[i], i);
        }
        int[] giftCnt = new int[friends.length];
        int[][] present = new int[friends.length][friends.length];

        for (String gift : gifts) {
            String x = gift.split(" ")[0];
            String y = gift.split(" ")[1];
            giftCnt[hm.get(x)]++;
            giftCnt[hm.get(y)]--;
            present[hm.get(x)][hm.get(y)]++;
        }

        for (int i = 0; i < friends.length; i++) {
            int cnt = 0;
            for (int j = 0; j < friends.length; j++) {
                if(i==j)
                    continue;
                if(present[i][j] > present[j][i])
                    cnt++;
                else if(present[i][j]==present[j][i]&&giftCnt[i]>giftCnt[j])
                    cnt++;
            }

            answer = Math.max(answer,cnt);
        }

        return answer;
    }
}