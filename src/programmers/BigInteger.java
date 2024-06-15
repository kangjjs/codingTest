package programmers;

import java.util.Arrays;

public class BigInteger {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];

        for(int i=0;i<numbers.length;i++){
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str,(o1, o2)->(o2+o1).compareTo(o1+o2));
        if(str[0].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for(String x:str){
            sb.append(x);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        BigInteger b = new BigInteger();
        System.out.println(b.solution(new int[]{3,30,34,5,9}));
    }
}
