package ch01;

import java.util.*;
class Ch08 {
    public int[] solution(int[] enter, int[] exit){
        int n=enter.length;
        int [] enterIndex=new int[n];

        for(int i=0;i<n;i++){
            enterIndex[enter[i]-1]=i;
        }

        int [] enterTime = new int[n];
        int [] exitTime = new int[n];
        int count=0;

        for(int i=0,j=0;i<n;i++){
            while(j<n&&j<=enterIndex[exit[i]-1]){
                enterTime[enter[j]-1]=count++;
                j++;
            }
            exitTime[exit[i]-1]=count++;
        }

        int [] answer =new int[n];

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(!(exitTime[i]<enterTime[j]||exitTime[j]<enterTime[i])){
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ch08 T = new Ch08();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}