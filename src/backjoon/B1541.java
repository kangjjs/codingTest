package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arrayList.add(x);
        }

        Collections.sort(arrayList);

        int ans=0;
        int sum=0;

        for(int x:arrayList){
            sum+=x;
            ans+=sum;
        }

        System.out.println(ans);
    }
}
