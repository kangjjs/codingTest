package section01;

import java.util.Scanner;

public class S11 {
    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        str=str+" ";
        int count = 1;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1))
                count++;
            else {
                sb.append(str.charAt(i));
                if(count>1)
                    sb.append(count);
                count = 1;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        S11 T = new S11();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.print(T.solution(str));
    }
}
