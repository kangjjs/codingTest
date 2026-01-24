package programmers;

public class VideoPlayer {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int start = convertSeconds(pos);
        int opStart = convertSeconds(op_start);
        int opEnd = convertSeconds(op_end);
        int videoLen = convertSeconds(video_len);

        if(check(start,opStart,opEnd)){
            start = opEnd;
        }

        for(String command:commands){
            if(command.equals("next")){
                start+=10;
                if(start>videoLen)
                    start=videoLen;
            }else{
                start-=10;
                if(start<0)
                    start=0;
            }
            if(check(start,opStart,opEnd)){
                start = opEnd;
            }
        }

        return convertTime(start);
    }

    static int convertSeconds(String time){
        String[] s= time.split(":");
        int m = Integer.parseInt(s[0]) * 60;
        int se = Integer.parseInt(s[1]);
        return m+se;
    }

    static String convertTime(int time){
        int m = time/60;
        int s = time%60;
        String minute;
        String second;
        if(m<10)
            minute="0"+m;
        else
            minute=String.valueOf(m);
        if(s<10)
            second="0"+s;
        else
            second=String.valueOf(s);
        return minute+":"+second;
    }

    static boolean check(int start,int opStart,int opEnd){
        return opStart<= start && start<= opEnd;
    }
}
