package section01;

import java.util.*;
class S10 {

    public int[] solution(String str,char c){

        ArrayList<Integer> arrayList = new ArrayList<>();

        int [] answer = new int[str.length()];

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==c)
                arrayList.add(i);
        }

        for(int i=0;i<str.length();i++){
            answer[i]=Integer.MAX_VALUE;
            for(int x:arrayList){
                answer[i]=Math.min(answer[i],Math.abs(i-x));
            }
        }

        return answer;
    }

    public static void main(String[] args){
        S10 T = new S10();
        Scanner kb = new Scanner(System.in);

        String str=kb.next();
        char c = kb.next().charAt(0);

        for(int x:T.solution(str,c)){
            System.out.print(x+" ");
        }
    }
}
