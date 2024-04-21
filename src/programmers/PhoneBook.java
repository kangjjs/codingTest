package programmers;

import java.util.HashMap;

public class PhoneBook {
    public boolean solution(String[] phone_book) {
        HashMap<String,Integer> hm = new HashMap<>();
        int idx = 0;
        for(String x : phone_book){
            hm.put(x,idx++);
        }

        for (String s : phone_book) {
            for (int j = 0; j < s.length(); j++) {
                if (hm.containsKey(s.substring(0, j)))
                    return false;
            }
        }

        return true;
    }
}
