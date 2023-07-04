package section04;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class S05 {

    public int solution(int n,int m,int [] arr){
        int answer=-1;
        TreeSet<Integer> treeSet =new TreeSet<>(Collections.reverseOrder());

        for (int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int l=j+1;l<n;l++){
                    treeSet.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }

        int cnt=0;

        for(int x:treeSet){
            cnt++;
            if(cnt==m)
                return x;
        }

        return answer;
    }

    public static void main(String[] args) {
        S05 T = new S05();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int [] arr =new int[n];

        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
        }

        System.out.print(T.solution(n,m,arr));
    }
}