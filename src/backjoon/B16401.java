package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16401 {

    static int n,m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[arr.length-1];

        while(lt<=rt){
            int mid = (lt+rt) / 2;
            int cnt = 0;

            for(int x:arr){
                if(x>=mid){
                    cnt += x/mid;
                }
            }

            if(cnt>=n){
                lt = mid+1;
            }else{
                rt = mid-1;
            }
        }

        System.out.println(rt);
    }
}