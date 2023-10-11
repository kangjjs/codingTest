package section04;

import java.util.*;

class S04 {

    public int solution(String str1,String str2) {

        int answer=0;
        int n=str2.length()-1;

        int lt=0;
        HashMap<Character,Integer> hm =new HashMap<>();
        HashMap<Character,Integer> h =new HashMap<>();

        for(char x:str2.toCharArray()){
            h.put(x,h.getOrDefault(x,0)+1);
        }

        for(int i=0;i<n;i++){
            hm.put(str1.charAt(i),hm.getOrDefault(str1.charAt(i),0)+1);
        }

        for(int rt=n;rt<str1.length();rt++){
            hm.put(str1.charAt(rt),hm.getOrDefault(str1.charAt(rt),0)+1);
            if(h.equals(hm))
                answer++;
            hm.put(str1.charAt(lt),hm.get(str1.charAt(lt))-1);
            if(hm.get(str1.charAt(lt))==0)
                hm.remove(str1.charAt(lt));
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        S04 T = new S04();
        Scanner kb = new Scanner(System.in);

        String str1 = kb.next();
        String str2 = kb.next();

        System.out.print(T.solution(str1,str2));
    }
}

