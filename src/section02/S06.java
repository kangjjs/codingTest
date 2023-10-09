package section02;

import java.util.*;
class S06 {

    public ArrayList<Integer> solution(int [] arr){

        int n=arr.length;
        ArrayList<Integer> answer= new ArrayList<>();

        for(int i=0;i<n;i++){
            String s = String.valueOf(arr[i]);
            int x = Integer.parseInt(new StringBuilder(s).reverse().toString());

            if(x==1)
                continue;

            boolean flag=true;
            for(int j=2;j<x;j++){
                if(x%j==0){
                    flag=false;
                    break;
                }
            }

            if(flag)
                answer.add(x);
        }

        return answer;
    }

    public static void main(String[] args){
        S06 T = new S06();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        int [] arr =new int[n];

        for(int i=0;i<n;i++){
            arr[i]= kb.nextInt();
        }

        for(int x:T.solution(arr))
            System.out.print(x+" ");
    }
}
