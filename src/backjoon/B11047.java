package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());

        ArrayList<Integer> money =new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            money.add(m);
        }

        Collections.reverse(money);
        int cnt=0,ans=0;

        while (true){
            if(price<money.get(cnt))
                cnt++;
            else{
                price-=money.get(cnt);
                ans++;
            }

            if(price==0)
                break;
        }

        System.out.println(ans);
    }
}
