package section04;

import java.util.HashMap;
import java.util.Scanner;

public class S01 {

    public char solution(int n,String str){
        char answer=' ';
        HashMap<Character,Integer> hashMap =new HashMap<>();

        for(char c:str.toCharArray()){
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }

        int max=-1;

        for(char x:hashMap.keySet()){
            if(max<hashMap.get(x)){
                max=hashMap.get(x);
                answer=x;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();

        System.out.print(T.solution(n,str));
    }
}
