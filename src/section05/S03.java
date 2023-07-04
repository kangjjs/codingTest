package section05;

import java.util.Scanner;
import java.util.Stack;

public class S03 {

    public int solution(int [][]arr1,int [] arr2){
        int answer =0;

        Stack<Integer> stack =new Stack<>();
        for(int x:arr2){
            for(int i=0;i<arr1.length;i++){
                if(arr1[i][x-1]!=0){
                    int tmp=arr1[i][x-1];
                    arr1[i][x-1]=0;
                    if(!stack.isEmpty()&&stack.peek()==tmp){
                        answer+=2;
                        stack.pop();
                    }else
                        stack.push(tmp);
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        S03 T = new S03();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int [][] arr1 =new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr1[i][j]=kb.nextInt();
            }
        }

        int m=kb.nextInt();
        int [] arr2 = new int[m];

        for(int i=0;i<m;i++)
            arr2[i]=kb.nextInt();
        System.out.print(T.solution(arr1,arr2));
    }
}
