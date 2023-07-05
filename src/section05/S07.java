package section05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S07 {

    public String solution(String str1,String str2){
        Queue<Character> queue = new LinkedList<>();

        for(char x:str1.toCharArray()){
            queue.offer(x);
        }

        for(char x:str2.toCharArray()){
            if(queue.contains(x)){
                if(x!=queue.poll())
                    return "NO";
            }
        }

        if(!queue.isEmpty())
            return "NO";
        return "YES";
    }

    public static void main(String[] args) {
        S07 T = new S07();
        Scanner kb = new Scanner(System.in);
        String str1 = kb.next();
        String str2 = kb.next();

        System.out.print(T.solution(str1,str2));
    }
}
