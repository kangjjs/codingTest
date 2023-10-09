package section02;

import java.util.*;
class S01 {

    public ArrayList<Integer> solution(int [] arr){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(arr[0]);

        for(int i=1;i<arr.length;i++){
            if(arr[i-1]<arr[i])
                arrayList.add(arr[i]);
        }

        return arrayList;
    }

    public static void main(String[] args){
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        int [] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
        }

        for(int x: T.solution(arr)){
            System.out.print(x+" ");
        }
    }
}
