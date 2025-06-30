package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class B1713 {
    static class Candidate {
        int num;
        int votes;
        int time;

        Candidate(int num, int time) {
            this.num = num;
            this.votes = 1;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Candidate> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int m = Integer.parseInt(st.nextToken());
            boolean found = false;

            for (Candidate c : list) {
                if (c.num == m) {
                    c.votes++;
                    found = true;
                    break;
                }
            }

            if (found)
                continue;

            if (list.size() == n) {
                list.sort((a, b) -> {
                    if (a.votes == b.votes)
                        return a.time - b.time;
                    return a.votes - b.votes;
                });
                list.remove(0);
            }

            list.add(new Candidate(m, i));
        }

        list.sort(Comparator.comparingInt(a->a.num));

        for(Candidate c:list){
            System.out.print(c.num+" ");
        }
    }
}
