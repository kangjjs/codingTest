package section02;

import java.util.*;
class S05 {

    public int solution(int n){
        int answer=0;

        int [] ch =new int[n+1];

        for(int i=2;i<=n;i++){
            if(ch[i]==0){
                answer++;

                for(int j=i;j<=n;j+=i){
                    ch[j]=1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        S05 T = new S05();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();

        System.out.print(T.solution(n));

    }
}
