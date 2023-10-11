package section05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class S07 {

    public String solution(String str1,String str2) {

        String str="";
        Queue<Character> queue =new LinkedList<>();

        for(Character x : str2.toCharArray()){
            for(Character y:str1.toCharArray()){
                if(x==y) {
                    queue.add(x);
                    break;
                }
            }
        }

        for(Character x:queue){
            str+=x;
        }

        if(str.equals(str1))
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args) {
        S07 T = new S07();
        Scanner kb = new Scanner(System.in);

        String str1 = kb.next();
        String str2 = kb.next();

        System.out.print(T.solution(str1,str2));
    }
}
