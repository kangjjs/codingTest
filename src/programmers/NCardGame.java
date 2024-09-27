package programmers;

import java.util.HashSet;

public class NCardGame {
    public int solution(int coin, int[] cards) {
        int answer = 0;
        HashSet<Integer> ori = new HashSet<>();
        HashSet<Integer> add = new HashSet<>();

        for (int i = 0; i < cards.length / 3; i++) {
            ori.add(cards[i]);
        }

        int l = cards.length / 3;
        int sol = cards.length + 1;
        while (true) {
            answer++;
            if (l >= cards.length)
                break;
            boolean flag = false;


            add.add(cards[l++]);
            add.add(cards[l++]);

            for (int i : ori) {
                if (ori.contains(sol - i)) {
                    ori.remove(i);
                    ori.remove(sol - i);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                if (coin > 0) {
                    for (int i : ori) {
                        if (add.contains(sol - i)) {
                            ori.remove(i);
                            add.remove(sol - i);
                            coin--;
                            flag = true;
                            break;
                        }
                    }
                }
            }

            if (!flag) {
                if (coin >= 2) {
                    for (int i : add) {
                        if (add.contains(sol - i)) {
                            add.remove(i);
                            add.remove(sol - i);
                            coin -= 2;
                            flag = true;
                            break;
                        }
                    }
                }
            }

            if (!flag)
                break;
        }

        return answer;
    }
}
