package programmers;

public class OurPassword {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int cnt = 0;
            char x = s.charAt(i);
            while (cnt < index) {
                x++;
                if (!Character.isAlphabetic(x))
                    x = 'a';
                if (skip.contains(String.valueOf(x)))
                    continue;
                cnt++;
            }
            sb.append(x);
        }

        return sb.toString();
    }
}
