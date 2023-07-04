package section04;

import java.util.HashMap;
import java.util.Scanner;

public class S04 {

    public int solution(String str1, String str2) {
        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();
        int n = str2.length();

        int answer = 0, lt = 0;

        for (int i = 0; i < n - 1; i++) {
            hashMap1.put(str1.charAt(i), hashMap1.getOrDefault(str1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            hashMap2.put(str2.charAt(i), hashMap2.getOrDefault(str2.charAt(i), 0) + 1);
        }

        for (int i = n - 1; i < str1.length(); i++, lt++) {
            hashMap1.put(str1.charAt(i), hashMap1.getOrDefault(str1.charAt(i), 0) + 1);

            if (hashMap1.equals(hashMap2))
                answer++;


            hashMap1.put(str1.charAt(lt), hashMap1.get(str1.charAt(lt)) - 1);

            if (hashMap1.get(str1.charAt(lt)) == 0)
                hashMap1.remove(str1.charAt(lt));
        }

        return answer;
    }

    public static void main(String[] args) {
        S04 T = new S04();
        Scanner kb = new Scanner(System.in);
        String str1 = kb.next();
        String str2 = kb.next();

        System.out.print(T.solution(str1, str2));
    }
}
