package section10;

import java.util.Scanner;

public class S06 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();
        int [] dy=new int[m+1];

        for (int i = 0; i < n; i++) {
            int s = kb.nextInt();
            int t = kb.nextInt();

            for(int j=m;j>=t;j--){
                dy[j]=Math.max(dy[j],dy[j-t]+s);
            }
        }

        System.out.println(dy[m]);
    }
}
