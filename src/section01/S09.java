package section01;

import java.util.*;
class S09 {
    public int solution(String str){
        str = str.toLowerCase().replaceAll("[^0-9]","");
        return Integer.parseInt(str);
    }

    public static void main(String[] args){
        S09 T = new S09();
        Scanner kb = new Scanner(System.in);

        String str=kb.nextLine();
        System.out.print(T.solution(str));
    }
}
