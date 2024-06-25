package programmers;

public class CardBunch {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cardIdx1 = 0;
        int cardIdx1Max = cards1.length;
        int cardIdx2 = 0;
        int cardIdx2Max = cards2.length;

        for (String s : goal) {
            if (cardIdx1 < cardIdx1Max && cards1[cardIdx1].equals(s)) {
                cardIdx1++;
            } else if (cardIdx2 < cardIdx2Max && cards2[cardIdx2].equals(s)) {
                cardIdx2++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}
