package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

class DataAnalyze {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("code",0);
        hm.put("date",1);
        hm.put("maximum",2);
        hm.put("remain",3);

        int extIndex = hm.get(ext);
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] d:data){
            if(d[extIndex]<val_ext){
                list.add(d);
            }
        }

        int sortIndex = hm.get(sort_by);
        list.sort(Comparator.comparingInt(a -> a[sortIndex]));
        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}