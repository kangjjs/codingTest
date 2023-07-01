package section02;

import java.util.ArrayList;
import java.util.Scanner;

public class S04 {
    public ArrayList<Integer> solution(int n){
        ArrayList<Integer> answer =new ArrayList<>();
        answer.add(1);
        answer.add(1);

        for(int i=2;i<n;i++){
            int x = answer.get(i-2)+answer.get(i-1);
            answer.add(x);
        }

        return answer;
    }

    public static void main(String[] args) {
        S04 T = new S04();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        for(int x:T.solution(n)){
            System.out.print(x+" ");
        }
    }
}
