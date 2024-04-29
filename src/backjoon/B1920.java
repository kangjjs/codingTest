package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920 {

    static int[] arr;

    static boolean binarySearch(int x){
        int lt = 0;
        int rt = arr.length-1;

        while(lt<=rt){
            int mid = (lt + rt) / 2;

            if(x>arr[mid]){
                lt = mid+1;
            }else if(x<arr[mid]){
                rt = mid-1;
            }else{
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr =new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<m;i++){
            if(binarySearch(Integer.parseInt(st.nextToken())))
                sb.append("1").append('\n');
            else
                sb.append("0").append('\n');
        }

        System.out.println(sb);
    }
}
