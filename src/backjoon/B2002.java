package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            hm.put(str, i);
        }

        String[] exit = new String[n];
        for (int i = 0; i < n; i++) {
            exit[i] = br.readLine();
        }

        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if(hm.get(exit[i])>hm.get(exit[j])){
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
