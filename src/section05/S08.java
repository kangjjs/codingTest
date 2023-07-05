package section05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S08 {

    class Person{
        int id;
        int priority;
        public Person(int id, int priority){
            this.id=id;
            this.priority=priority;
        }
    }

    public int solution(int n, int m, int[] arr) {
        int answer=0;
        Queue<Person> queue =new LinkedList<>();

        for(int i=0;i<n;i++){
            queue.offer(new Person(i,arr[i]));
        }

        while(!queue.isEmpty()){
            Person tmp =queue.poll();

            for(Person x:queue){
                if(x.priority>tmp.priority){
                    queue.offer(tmp);
                    tmp=null;
                    break;
                }
            }

            if(tmp!=null){
                answer++;
                if(tmp.id==m)
                    return answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        S08 T = new S08();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int [] arr =new int[n];

        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
        }

        System.out.print(T.solution(n,m,arr));
    }
}