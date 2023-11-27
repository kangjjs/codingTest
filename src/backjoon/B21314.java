package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B21314 {

    public static String findMin(String str, int size, int  k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) == 'M') {
                k = i;
                while (k < str.length() && str.charAt(k) == 'M')
                    k++;
                sb.append(1);
                for (; i + 1 < k; i++) {
                    sb.append(0);
                }

                i = k - 1;
            } else {
                sb.append(5);
            }
        }

        return sb.toString();
    }

    public static String findMax(String str, int size, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) == 'M') {
                k = i;
                while (k < size && str.charAt(k) == 'M')
                    k++;
                if (k == size) {
                    for (; i < k; i++)
                        sb.append(1);
                } else {
                    sb.append(5);
                    for (; i < k; i++)
                        sb.append(0);
                }

                i = k;
            } else {
                sb.append(5);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int size = str.length();
        System.out.println(findMax(str,size,0));
        System.out.println(findMin(str,size,0));
    }
}
