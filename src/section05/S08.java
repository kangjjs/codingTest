package section05;

import java.util.*;

class Person{
    int id;
    int priority;
    public Person(int id, int priority){
        this.id=id;
        this.priority=priority;
    }
}
class Main {

    public int solution(int n,int m,int [] arr) {

        int answer = 0;
        Queue<Person> queue =new LinkedList<>();

        for(int i=0;i<n;i++){
            queue.offer(new Person(i,arr[i]));
        }

        while(!queue.isEmpty()){
            Person p = queue.poll();

            for(Person x: queue){
                if(x.priority>p.priority){
                    queue.offer(p);
                    p=null;
                    break;
                }
            }

            if(p!=null){
                answer++;
                if(p.id==m)
                    return answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();
        int [] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
        }

        System.out.print(T.solution(n,m,arr));
    }
}
