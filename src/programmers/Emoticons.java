package programmers;

import java.util.*;

public class Emoticons {
    static class Kakao implements Comparable<Kakao> {
        int cnt;
        long amount;

        public Kakao(int cnt, long amount) {
            this.cnt = cnt;
            this.amount = amount;
        }

        @Override
        public int compareTo(Kakao o) {
            if (this.cnt == o.cnt)
                return (int)o.amount - (int)this.amount;
            return o.cnt - this.cnt;
        }
    }

    static int n;
    static int[] discount, dis;
    static List<Kakao> list;

    static void dfs(int l, int[][] users, int[] emoticons) {
        if (l == n) {
            int sub = 0;
            long price = 0;
            for (int[] user : users) {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    if (user[0] <= dis[i]) {
                        sum += (emoticons[i]) * (100 - dis[i]) / 100;
                    }
                }
                if (sum >= user[1]) {
                    sub++;
                } else {
                    price += sum;
                }
            }
            list.add(new Kakao(sub, price));
        } else {
            for (int j = 0; j < 4; j++) {
                dis[l] = discount[j];
                dfs(l + 1, users, emoticons);
                dis[l] = 0;
            }
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        n = emoticons.length;
        discount = new int[]{10, 20, 30, 40};
        dis = new int[n];
        list = new ArrayList<>();
        dfs(0, users, emoticons);
        Collections.sort(list);
        return new int[]{list.get(0).cnt, (int) list.get(0).amount};
    }
}
