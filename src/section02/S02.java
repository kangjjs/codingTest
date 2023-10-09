package section02;

import java.util.*;
class S02 {

    public int solution(int [] arr){

        int answer=1;
        int n=arr.length;
        int max=arr[0];

        for(int i=1;i<n;i++){
            if(max<arr[i]){
                max=arr[i];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        int [] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
        }

        System.out.print(T.solution(arr));
    }
}

