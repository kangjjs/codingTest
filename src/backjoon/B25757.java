package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(br.readLine());
        }

        if (c == 'Y') {
            System.out.println(hs.size());
        } else if (c == 'F') {
            System.out.println(hs.size() / 2);
        } else {
            System.out.println(hs.size() / 3);
        }
    }
}
