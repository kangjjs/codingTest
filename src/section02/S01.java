package section02;

import java.util.ArrayList;
import java.util.Scanner;

public class S01 {

    public ArrayList<Integer> solution(int [] array){
        ArrayList<Integer> answer =new ArrayList<>();

        answer.add(array[0]);

        for(int i=1;i<array.length;i++){
            if(array[i]>array[i-1])
                answer.add(array[i]);
        }

        return answer;
    }

    public static void main(String[] args){
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);
        int n= kb.nextInt();
        int [] array = new int[n];

        for(int i=0;i<n;i++){
            array[i]=kb.nextInt();
        }

        for(int x:T.solution(array)){
            System.out.print(x+" ");
        }
    }
}
