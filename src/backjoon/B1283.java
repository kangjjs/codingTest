package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class B1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        HashSet<Character> hs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");
            boolean flag = false;

            for (int j = 0; j < words.length; j++) {
                char c = Character.toLowerCase(words[j].charAt(0));
                if (!hs.contains(c)) {
                    words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1);
                    hs.add(c);
                    flag = true;
                    break;
                }
            }


            if(!flag) {
                for (int j = 0; j < words.length; j++) {
                    for (int k = 0; k < words[j].length(); k++) {
                        char c = Character.toLowerCase(words[j].charAt(k));
                        if (!hs.contains(c)) {
                            hs.add(c);
                            words[j] = words[j].substring(0, k) + "[" + words[j].charAt(k) + "]" + words[j].substring(k + 1);
                            flag = true;
                            break;
                        }
                    }
                    if (flag)
                        break;
                }
            }

            sb.append(String.join(" ", words)).append("\n");
        }

        System.out.print(sb);
    }
}
