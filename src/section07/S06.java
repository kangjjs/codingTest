package section07;

import java.util.*;

class S06 {

    static int [] ch;
    static int n;

    public void solution(int l) {
        if(l==n+1){
            String tmp="";

            for(int i=1;i<=n;i++){
                if(ch[i]==1)
                    tmp+=(i+" ");
            }

            if(tmp.length()>0)
                System.out.println(tmp);
        }else{
            ch[l]=1;
            solution(l+1);
            ch[l]=0;
            solution(l+1);
        }
    }

    public static void main(String[] args) {
        S06 T = new S06();
        n=3;
        ch=new int[n+1];
        T.solution(1);
    }
}