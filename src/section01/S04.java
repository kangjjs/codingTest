package section01;

import java.util.*;
class S04 {
    public void solution(String []str){

        for(String s:str){
            String ans=new StringBuilder(s).reverse().toString();
            System.out.println(ans);
        }
    }

    public static void main(String[] args){
        S04 T = new S04();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();

        String [] str = new String[n];

        for(int i=0;i<n;i++) {
            str[i]=kb.next();
        }

        T.solution(str);
    }
}
