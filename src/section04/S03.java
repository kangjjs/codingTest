package section04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class S03 {

    public ArrayList<Integer> solution(int n,int m,int [] arr){
        HashMap<Integer,Integer> hashMap =new HashMap<>();
        ArrayList<Integer> answer =new ArrayList<>();

        for(int i=0;i<m-1;i++){
            hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0)+1);
        }
        int lt=0;
        for(int i=m-1;i<n;i++,lt++){
            hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0)+1);
            answer.add(hashMap.size());
            hashMap.put(arr[lt],hashMap.get(arr[lt])-1);
            if(hashMap.get(arr[lt])==0)
                hashMap.remove(arr[lt]);
        }

        return answer;
    }

    public static void main(String[] args) {
        S03 T = new S03();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int [] arr =new int[n];

        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
        }

        for(int x:T.solution(n,m,arr))
            System.out.print(x+" ");
    }
}