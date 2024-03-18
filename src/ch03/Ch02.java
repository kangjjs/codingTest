package ch03;

import java.util.Stack;

class Ch02 {
    public String solution(String s){
        StringBuilder answer = new StringBuilder();
        Stack<String> st =new Stack<>();

        for(char x:s.toCharArray()){
            if(x==')'){
                String str ="";
                while(!st.isEmpty()) {
                    String y =st.pop();
                    if(y.equals("(")) {
                        String num ="";
                        while (!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                            num+=st.pop()+num;
                        }

                        String res="";
                        int cnt;

                        if(num.equals(""))
                            cnt=1;
                        else
                            cnt=Integer.parseInt(num);
                        for(int i=0;i<cnt;i++)
                            res+=str;
                        st.push(res);
                        break;
                    }
                    str+=y;
                }
            }else{
                st.push(String.valueOf(x));
            }
        }

        for(String x:st){
            answer.append(x);
        }

        return answer.toString();
    }

    public static void main(String[] args){
        Ch02 T = new Ch02();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}