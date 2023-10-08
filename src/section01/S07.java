package section01;

import java.util.*;
class S07 {
    public void solution(String str){
        char x = Character.toLowerCase(str.charAt(0));
        char y = Character.toLowerCase(str.charAt(str.length()-1));

        if(x==y)
            System.out.print("YES");
        else
            System.out.print("NO");
    }

    public static void main(String[] args){
        S07 T = new S07();
        Scanner kb = new Scanner(System.in);

        String str=kb.next();
        T.solution(str);
    }
}
