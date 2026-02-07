package programmers;

import java.util.ArrayList;

class DecodingCode {

    static int nValue, answerCount, queryCount;
    static int[][] queries;
    static int[] answers;
    static ArrayList<Integer> selectedNumbers;

    public int solution(int n, int[][] q, int[] ans) {
        nValue = n;
        queries = q;
        answers = ans;
        answerCount = 0;
        queryCount = q.length;
        selectedNumbers = new ArrayList<>();

        dfs(0, 1);
        return answerCount;
    }

    static void dfs(int depth, int start) {
        if (depth == 5) {
            for (int i = 0; i < queryCount; i++) {
                int cnt = 0;
                for (int c : queries[i]) {
                    if (selectedNumbers.contains(c))
                        cnt++;
                }
                if (cnt != answers[i])
                    return;
            }
            answerCount++;
        } else {
            for (int i = start; i <= nValue; i++) {
                selectedNumbers.add(i);
                dfs(depth + 1, i + 1);
                selectedNumbers.remove(Integer.valueOf(i));
            }
        }
    }
}
