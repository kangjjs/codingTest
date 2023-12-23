package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arrayList1 = new ArrayList<>();
        List<Integer> arrayList2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0)
                arrayList1.add(x);
            else
                arrayList2.add(x);
        }

        arrayList1.sort(Collections.reverseOrder());
        Collections.sort(arrayList2);

        int ans = 0;
        int i = 0;

        while (i < arrayList1.size()) {
            if (i + 1 < arrayList1.size() && arrayList1.get(i) != 1 && arrayList1.get(i+1) != 1)
                ans += arrayList1.get(i++) * arrayList1.get(i++);
            else
                ans += arrayList1.get(i++);
        }

        i = 0;
        while(i<arrayList2.size()){
            if(i+1<arrayList2.size()){
                ans+=arrayList2.get(i++)*arrayList2.get(i++);
            }else{
                ans+=arrayList2.get(i++);
            }
        }

        System.out.println(ans);
    }
}
