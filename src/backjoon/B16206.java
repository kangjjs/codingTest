package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B16206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> cakes1 = new ArrayList<>();
        ArrayList<Integer> cakes2 = new ArrayList<>();


        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x % 10 == 0)
                cakes1.add(x);
            else
                cakes2.add(x);
        }

        int ans = 0;
        int cut, piece;

        cakes1.sort(Comparator.naturalOrder());

        for (int cake : cakes1) {
            if (M <= 0)
                break;
            piece = cake / 10;
            cut = piece - 1;

            if(M<cut){
                cut = M;
                piece = cut;
                if(cake-(piece*10) == 10)
                    piece++;
            }

            M-=cut;
            ans+=piece;
        }

        for(int cake: cakes2){
            if(M<=0)
                break;

            piece = cake/10;
            cut = piece;

            if(M < cut){
                cut = M;
                piece = cut;
            }
            M -= cut;
            ans += piece;
        }

        System.out.println(ans);
    }
}
