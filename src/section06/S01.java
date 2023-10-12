package section06;

import java.util.*;

class S01 {

    public int [] solution(int n,int []arr) {

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
               if(arr[i]> arr[j]){
                   int tmp = arr[i];
                   arr[i] = arr[j];
                   arr[j] = tmp;
               }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int [] arr =new int[n];

        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
        }

        for(int x : T.solution(n,arr)){
            System.out.print(x+" ");
        }
    }
}
