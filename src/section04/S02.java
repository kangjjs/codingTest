package section04;

import java.util.HashMap;
import java.util.Scanner;

public class S02 {

    public String solution(String str1,String str2){
        HashMap<Character,Integer> hashMap1 =new HashMap<>();
        HashMap<Character,Integer> hashMap2 =new HashMap<>();

        for(char x:str1.toCharArray()){
            hashMap1.put(x,hashMap1.getOrDefault(x,0)+1);
        }

        for(char x:str2.toCharArray()){
            hashMap2.put(x,hashMap2.getOrDefault(x,0)+1);
        }

        boolean flag=true;

        for(char x:hashMap1.keySet()){
            if(!(hashMap1.get(x).equals(hashMap2.get(x))))
                flag=false;
        }

        if(flag)
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args) {
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);
        String str1 = kb.next();
        String str2 = kb.next();

        System.out.print(T.solution(str1,str2));
    }
}
