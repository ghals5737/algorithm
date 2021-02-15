import java.util.LinkedList;
import java.util.Queue;

public class programmers_kakao_2021_05 {
    static int[] sub=new int[360001];
    static int convert(String time){
        int h=Integer.parseInt(time.substring(0,2));
        int m=Integer.parseInt(time.substring(3,5));
        int s=Integer.parseInt(time.substring(6,8));        
        return h*3600+m*60+s;
    }
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        for(String str:logs){
            int start=convert(str.substring(0,8));
            int end=convert(str.substring(9,17));
            for(int i=start;i<end;i++)sub[i]++;
        }
        Queue<Integer>q=new LinkedList<>();
        int len=convert(play_time);
        int adv=convert(adv_time);
        long sum=0;
        long maxSum=0;
        int ans=0;
        for(int i=0;i<adv;i++){
            sum+=sub[i];
            q.add(sub[i]);
        }
        maxSum=sum;
        for(int i=adv;i<len;i++){
            sum+=sub[i];
            q.add(sub[i]);
            sum-=q.poll();
            if(maxSum<sum){
                maxSum=sum;
                ans=i-adv+1;
            }
        }
        int s=(ans%60);
        ans/=60;
        int m=(ans%60);
        ans/=60;
        int h=ans;       
        answer=String.format("%02d",h)+":"+String.format("%02d",m)+":"+String.format("%02d",s);
        return answer;
    }

}
