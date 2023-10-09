package section01;

import java.util.*;
class S08 {
    public String solution(String str){
        String s = new StringBuilder(str).reverse().toString();

        if(str.equals(s))
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args){
        S08 T = new S08();
        Scanner kb = new Scanner(System.in);

        String str=kb.nextLine();
        str = str.toLowerCase().replaceAll("[^a-z]","");

        System.out.print(T.solution(str));
    }
}
