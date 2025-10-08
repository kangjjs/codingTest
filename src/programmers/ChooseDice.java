package programmers;

import java.util.*;

class ChooseDice {
    static int[][] cd;
    static int n;
    static ArrayList<Integer> teamA, bestTeam;
    static boolean[] visited;
    static double maxWinRate;

    public int[] solution(int[][] dice) {

        cd = dice;
        n = dice.length;
        teamA = new ArrayList<>();
        visited = new boolean[n];
        maxWinRate = 0.0;

        dfs(0, 0);

        int[] answer = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            answer[i] = bestTeam.get(i) + 1;
        }

        return answer;
    }

    static void dfs(int l, int s) {
        if (l == n / 2) {
            ArrayList<Integer> teamB = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    teamB.add(i);
                }
            }

            fight(teamB);
            return;
        }

        for (int i = s; i < n; i++) {
            if (!visited[i]) {
                teamA.add(i);
                visited[i] = true;
                dfs(l + 1, i + 1);
                visited[i] = false;
                teamA.remove(Integer.valueOf(i));
            }
        }
    }

    static void fight(ArrayList<Integer> teamB) {
        ArrayList<Integer> sumA = getSum(teamA);
        ArrayList<Integer> sumB = getSum(teamB);

        Collections.sort(sumA);
        Collections.sort(sumB);

        long win = 0;
        long total = (long) sumA.size() * sumB.size();

        for (int a : sumA) {
            win += count(sumB, a);
        }

        double winRate = (double) win / total;

        if (winRate > maxWinRate) {
            maxWinRate = winRate;
            bestTeam = new ArrayList<>(teamA);
        }
    }

    static ArrayList<Integer> getSum(ArrayList<Integer> team) {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.add(0);

        for (int idx : team) {
            ArrayList<Integer> next = new ArrayList<>();
            for (int s : sums) {
                for (int c : cd[idx]) {
                    next.add(s + c);
                }
            }

            sums = next;
        }

        return sums;
    }

    static int count(ArrayList<Integer> teamB, int a) {
        int lt = 0, rt = teamB.size();

        while (lt < rt) {
            int mid = (lt + rt) / 2;

            if (teamB.get(mid) < a)
                lt = mid + 1;
            else
                rt = mid;
        }

        return lt;
    }
}