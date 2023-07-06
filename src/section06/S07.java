package section06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class S07 {

    public int[] [] solution(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return Integer.compare(o1[1],o2[1]);
                return Integer.compare(o1[0],o2[0]);
            }
        });

        return arr;
    }

    public static void main(String[] args) {
        S07 T = new S07();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0]=kb.nextInt();
            arr[i][1]=kb.nextInt();
        }

        for(int[] x:T.solution(arr)){
            System.out.println(x[0]+" "+x[1]);
        }
    }
}
