package section06;

import java.util.Scanner;

public class S02 {

    public int [] solution(int n,int [] arr){

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);
        int n= kb.nextInt();
        int [] arr =new int[n];

        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
        }

        for(int x:T.solution(n,arr)){
            System.out.print(x+" ");
        }
    }
}
