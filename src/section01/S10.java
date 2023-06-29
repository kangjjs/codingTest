package section01;

import java.util.Scanner;

public class S10 {

    public int[] solution(String str,Character c){
        int [] answer =new int[str.length()];
        int min=1000;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==c) {
                min = 0;
                answer[i]=min;
            }
            else {
                min++;
                answer[i]=min;
            }
        }

        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)==c)
                min=0;
            else {
                min++;
                answer[i] = Math.min(answer[i], min);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        S10 T = new S10();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        Character c = kb.next().charAt(0);
        for(int x:T.solution(str,c)){
            System.out.print(x+" ");
        }
    }
}
