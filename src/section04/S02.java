package section04;

import java.util.*;

class S02 {

    public String solution(String str1, String str2) {

        String answer = "YES";

        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();

        for (Character x : str1.toCharArray()) {
            hm1.put(x, hm1.getOrDefault(x, 0) + 1);
        }

        for (Character x : str2.toCharArray()) {
            hm2.put(x, hm2.getOrDefault(x, 0) + 1);
        }

        for (Character x : hm1.keySet()) {
            if (hm2.containsKey(x)) {
                if (!hm1.get(x).equals(hm2.get(x))) {
                    answer = "NO";
                    break;
                }
            }else{
                answer="NO";
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);

        String str1 = kb.next();
        String str2 = kb.next();

        System.out.print(T.solution(str1, str2));
    }
}
