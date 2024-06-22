package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Deque<String> back = new LinkedList<>();
        Deque<String> front = new LinkedList<>();

        for(int i=0; i<str.length(); ++i) {
            front.addLast(Character.toString(str.charAt(i)));
        }

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String x = st.nextToken();

            switch (x) {
                case "P":
                    front.addLast(st.nextToken());
                    break;
                case "L":
                    if (front.isEmpty()) continue;
                    back.addFirst(front.pollLast());
                    break;
                case "D":
                    if (back.isEmpty()) continue;
                    front.addLast(back.pollFirst());
                    break;
                default:
                    if (front.isEmpty()) continue;
                    front.removeLast();
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!front.isEmpty()){
            sb.append(front.pollFirst());
        }

        while (!back.isEmpty()){
            sb.append(back.pollFirst());
        }

        System.out.println(sb);
    }
}
