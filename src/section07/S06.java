package section07;

import java.util.Scanner;

public class S06 {
    static int n;
    static int [] ch;

    public void solution(int k){
        if(k==n+1){
            StringBuilder tmp= new StringBuilder();
            for(int i=1;i<=n;i++){
                if(ch[i]==1)
                    tmp.append(i).append(" ");
            }

            if(tmp.length()>0)
                System.out.println(tmp);
        }else{
            ch[k]=1;
            solution(k+1);
            ch[k]=0;
            solution(k+1);
        }
    }

    public static void main(String[] args) {
        S06 T = new S06();
        Scanner kb = new Scanner(System.in);

        n= kb.nextInt();
        ch = new int[n+1];

        T.solution(1);
    }
}
