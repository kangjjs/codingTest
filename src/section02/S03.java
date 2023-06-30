package section02;

import java.util.ArrayList;
import java.util.Scanner;

public class S03 {

    public void solution(int [] arr1,int [] arr2){
        int n = arr1.length;

        ArrayList<Character> answer =new ArrayList<>();

        for(int i=0;i<n;i++){
            if(arr1[i]==arr2[i])
                answer.add('D');
            if(arr1[i]>arr2[i]){
                if(arr1[i]==3&&arr2[i]==1)
                    answer.add('B');
                else
                    answer.add('A');
            }else if(arr1[i]<arr2[i]){
                if(arr1[i]==1&&arr2[i]==3)
                    answer.add('A');
                else
                    answer.add('B');
            }
        }

        for(Character x:answer){
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        S03 T = new S03();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = kb.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = kb.nextInt();
        }

        T.solution(arr1,arr2);
    }
}
