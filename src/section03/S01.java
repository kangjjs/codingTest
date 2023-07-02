package section03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class S01 {

    public ArrayList<Integer> solution(int []arr1, int []arr2){

        ArrayList<Integer> answer =new ArrayList<>();

        for(int x:arr1){
            answer.add(x);
        }

        for(int x:arr2){
            answer.add(x);
        }

        Collections.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [] arr1 = new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=kb.nextInt();
        }
        int m=kb.nextInt();
        int [] arr2 =new int[m];
        for(int i=0;i<m;i++){
            arr2[i]=kb.nextInt();
        }

        for(int x:T.solution(arr1,arr2)){
            System.out.print(x+" ");
        }
    }
}
