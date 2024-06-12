package programmers;

import java.util.*;
public class ReMenu {
    static HashMap<String,Integer> hm = new HashMap<>();
    static StringBuilder sb;

    static void dfs(int w,int l,int j,String order){
        if(l==w){
            hm.put(sb.toString(),hm.getOrDefault(sb.toString(),0)+1);
        }else{
            for(int i=j;i<order.length();i++){
                sb.append(order.charAt(i));
                dfs(w,l+1,i+1,order);
                sb.delete(l,l+1);
            }
        }
    }

    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> list = new ArrayList<>();
        for(int i =0;i<orders.length;i++){
            char[] c = orders[i].toCharArray();
            Arrays.sort(c);
            orders[i] = String.valueOf(c);
        }

        for (int j : course) {
            hm = new HashMap<>();
            int max = Integer.MIN_VALUE;
            for (String order : orders) {
                sb = new StringBuilder();
                if (order.length() >= j)
                    dfs(j, 0, 0, order);
            }

            for (Map.Entry<String, Integer> entry : hm.entrySet()) {
                max = Math.max(max, entry.getValue());
            }

            for (Map.Entry<String, Integer> entry : hm.entrySet()) {
                if (max >= 2 && entry.getValue() == max)
                    list.add(entry.getKey());
            }
        }

        Collections.sort(list);

        return list;
    }
}
