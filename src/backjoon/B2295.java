package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class B2295 {

    static int[] arr;
    static ArrayList<Integer> list;

    static boolean search(int x) {
        int lt = 0;
        int rt = list.size() - 1;
        int mid;

        while (lt < rt) {
            mid = (lt + rt) / 2;

            if(list.get(mid) < x ){
                lt = mid+1;
            }else if(list.get(mid) > x){
                rt = mid -1;
            }else{
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list.add(arr[i] + arr[j]);
            }
        }

        Arrays.sort(arr);
        Collections.sort(list);
        int answer = 0;

        for(int i = n-1;i>=0;i--){
            for (int j = 0; j < i; j++) {
                int x = arr[i] - arr[j];

                if(search(x) && answer < arr[i]){
                    answer = arr[i];
                }
            }
        }

        System.out.println(answer);
    }
}
