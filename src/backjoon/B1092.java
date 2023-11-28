package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> cranes =new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());

        ArrayList<Integer> boxes =new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        cranes.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        int ans = 0;

        if(cranes.get(0)<boxes.get(0)){
            System.out.println("-1");
            return;
        }

        while (!boxes.isEmpty()) {
            int boxIndex=0,craneIndex=0;

            while(craneIndex<n){
                if(boxIndex==boxes.size())
                    break;
                if(cranes.get(craneIndex)>=boxes.get(boxIndex)){
                    boxes.remove(boxIndex);
                    craneIndex++;
                }else
                    boxIndex++;
            }

            ans++;
        }

        System.out.println(ans);
    }
}
