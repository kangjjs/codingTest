package section08;

import java.util.Scanner;

public class S09 {

    static int n,m;
    static int [] arr;

    public void solution(int k,int s){
        if(k==m){
            for(int x:arr)
                System.out.print(x+" ");
            System.out.println();
        }else{
            for(int i=s;i<=n;i++){
                arr[k]=i;
                solution(k+1,i+1);
            }
        }
    }

    public static void main(String[] args) {
        S09 T = new S09();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();

        arr= new int[m];
        T.solution(0,1);
    }
}
