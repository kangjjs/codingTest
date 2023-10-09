package section02;

import java.util.*;
class S03 {

    public String [] solution(int [] A,int []B){

        int n=A.length;
        String [] answer =new String[n];

        for(int i=0;i<n;i++){
            if(A[i]==B[i])
                answer[i]="D";
            else{
                if(A[i]-B[i]==1)
                    answer[i]="A";
                else if(B[i]-A[i]==1)
                    answer[i]="B";
                else if(A[i]-B[i]==2)
                    answer[i]="B";
                else
                    answer[i]="A";
            }
        }

        return answer;
    }

    public static void main(String[] args){
        S03 T = new S03();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        int [] A = new int[n];
        int [] B = new int[n];

        for(int i=0;i<n;i++){
            A[i]=kb.nextInt();
        }

        for(int i=0;i<n;i++){
            B[i]=kb.nextInt();
        }

        for(String s : T.solution(A,B))
            System.out.println(s);
    }
}
