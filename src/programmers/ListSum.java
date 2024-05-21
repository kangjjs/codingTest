package programmers;

import java.util.*;

class ListSum {

    static class Sum implements Comparable<Sum>{
        int l,r;

        public Sum(int l,int r){
            this.l=l;
            this.r=r;
        }

        @Override
        public int compareTo(Sum o){
            if((this.r-this.l)==(o.r-o.l))
                return this.l - o.l;
            return (this.r-this.l)-(o.r-o.l);
        }
    }

    public int[] solution(int[] sequence, int k) {

        int lt = 0;
        int rt = 0;
        int sum = 0;
        ArrayList<Sum> list = new ArrayList<>();
        while(lt<=rt){
            if(rt==sequence.length)
                break;
            sum+=sequence[rt];
            if(sum==k){
                list.add(new Sum(lt,rt));
                rt++;
            }else if(sum>k){
                sum-=sequence[lt];
                sum-=sequence[rt];
                lt++;
            }else{
                rt++;
            }
        }

        Collections.sort(list);

        return new int[]{list.get(0).l,list.get(0).r};
    }
}