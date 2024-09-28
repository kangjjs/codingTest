package programmers;

import java.util.*;

class ExpressBinaryTree {
    public boolean checkFull(String binary){
        int len = binary.length();
        if(len==1)
            return true;
        int mid = len/2;
        char node = binary.charAt(mid);

        String left = binary.substring(0,mid);
        String right = binary.substring(mid+1,len);

        if(node=='0'&&(left.contains("1")||right.contains("1")))
            return false;

        return checkFull(left) && checkFull(right);
    }

    public List<Integer> solution(long[] numbers) {
        List<Integer> answer = new ArrayList<>();

        for (long number : numbers) {
            String binary = Long.toBinaryString(number);
            int depth = (int)(Math.log(binary.length())/Math.log(2)) + 1;
            int fullBinary = (int)(Math.pow(2,depth)) - 1;

            while(binary.length()<fullBinary){
                binary='0'+binary;
            }

            if(checkFull(binary)){
                answer.add(1);
            }else{
                answer.add(0);
            }
        }

        return answer;
    }
}