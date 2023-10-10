package section03;

import java.util.*;
class S01 {

    public ArrayList<Integer> solution(int [] arr1, int [] arr2){

        ArrayList<Integer> answer =new ArrayList<>();

        int i=0,j=0;

        while(i<arr1.length&&j<arr2.length){
            if(arr1[i]>arr2[j]){
                answer.add(arr2[j++]);
            }else{
                answer.add(arr1[i++]);
            }
        }

        while(i<arr1.length)
            answer.add(arr1[i++]);
        while(j<arr2.length)
            answer.add(arr2[j++]);

        return answer;
    }

    public static void main(String[] args){
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        int [] arr1 =new int[n];

        for(int i=0;i<n;i++){
            arr1[i]=kb.nextInt();
        }

        int m= kb.nextInt();
        int [] arr2 =new int[m];

        for(int i=0;i<m;i++){
            arr2[i]=kb.nextInt();
        }

        for(int x : T.solution(arr1,arr2))
            System.out.print(x+" ");
    }
}