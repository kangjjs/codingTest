package section08;

import java.util.*;

class S01 {

    static String answer="NO";
    static int [] arr;
    static int n,ans;
    boolean flag=false;

    public void solution(int l,int sum,int [] arr) {
        if(flag)
            return;
        if(sum>ans/2)
            return;
        if(l==n){
            if(sum==(ans-sum)){
                answer="YES";
                flag=true;
            }
        }else{
            solution(l+1,sum+arr[l],arr);
            solution(l+1,sum,arr);
        }
    }


    public static void main(String[] args) {
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt();
        arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i] = kb.nextInt();
        }

        ans = Arrays.stream(arr).sum();
        T.solution(0,0,arr);
        System.out.print(answer);
    }
}

