package programmers;

import java.util.*;

public class FairNumber {
    public String solution(String X, String Y) {
        int lenX = X.length();
        int lenY = Y.length();
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> hmX = new HashMap<>();
        HashMap<Character, Integer> hmY = new HashMap<>();

        for (int i = 0; i < X.length(); i++) {
            hmX.put(X.charAt(i), hmX.getOrDefault(X.charAt(i), 0) + 1);
        }

        for (int i = 0; i < Y.length(); i++) {
            hmY.put(Y.charAt(i), hmY.getOrDefault(Y.charAt(i), 0) + 1);
        }

        if (lenX <= lenY) {
            for (char c : X.toCharArray()) {
                if (hmY.containsKey(c)) {
                    hmY.put(c, hmY.get(c) - 1);
                    list.add(Integer.parseInt(String.valueOf(c)));
                    if (hmY.get(c) == 0)
                        hmY.remove(c);
                }
            }
        } else {
            for (char c : Y.toCharArray()) {
                if (hmX.containsKey(c)) {
                    hmX.put(c, hmX.get(c) - 1);
                    list.add(Integer.parseInt(String.valueOf(c)));
                    if (hmX.get(c) == 0)
                        hmX.remove(c);
                }
            }
        }
        list.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        if (list.isEmpty())
            return "-1";
        if (list.get(0) == 0)
            return "0";
        for (Integer k : list) {
            sb.append(k);
        }

        return sb.toString();
    }
}
