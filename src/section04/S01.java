package section04;

import java.util.*;
class S01 {

    public char solution(int n,String str){

        char answer=' ';
        int max=0;

        HashMap<Character,Integer> hm =new HashMap<>();

        for(Character x:str.toCharArray()){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }

        for(Character x:hm.keySet()){
            if(hm.get(x)>max){
                max=hm.get(x);
                answer=x;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        String str = kb.next();

        System.out.print(T.solution(n,str));
    }
}

