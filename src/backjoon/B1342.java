package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B1342 {

    static Map<Character, Integer> hm;
    static int answer, length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        hm = new HashMap<>();
        answer = 0;
        length = str.length();

        for (char c : str.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        dfs("",'\0');
        System.out.println(answer);
    }

    static void dfs(String cur, char last) {
        if (cur.length() == length) {
            answer++;
            return;
        }

        for (char c : hm.keySet()) {
            int count = hm.get(c);
            if (count == 0 || c == last)
                continue;
            hm.put(c, count - 1);
            dfs(cur + c, c);
            hm.put(c, count);
        }
    }
}
