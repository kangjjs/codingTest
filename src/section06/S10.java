package section06;

import java.util.Arrays;
import java.util.Scanner;

public class S10 {

    public int count(int [] arr,int n){
        int cnt=1;
        int ep=arr[0];

        for(int i=1;i<arr.length;i++){
            if(arr[i]-ep>=n){
                cnt++;
                ep=arr[i];
            }
        }

        return cnt;
    }

    public int solution(int n,int m,int [] arr){
        int answer = 0;
        Arrays.sort(arr);

        int lt=arr[0];
        int rt=arr[n-1];

        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(count(arr,mid)>=m){
                answer=mid;
                lt=mid+1;
            }else{
                rt=mid-1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        S10 T = new S10();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.solution(n, m, arr));
    }
}
