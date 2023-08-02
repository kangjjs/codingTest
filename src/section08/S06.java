package section08;

import java.util.Scanner;

public class S06 {

    static int n,m;
    static int [] arr,a,ch;

    public void solution(int l){
        if(l==m){
            for(int x:a)
                System.out.print(x+" ");
            System.out.println();
        }else{
            for(int i=0;i<n;i++){
                if(ch[i]==0) {
                    ch[i]=1;
                    a[l] = arr[i];
                    solution(l + 1);
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        S06 T = new S06();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();

        arr=new int[n];
        a=new int[m];
        ch=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
        }

        T.solution(0);
    }
}
