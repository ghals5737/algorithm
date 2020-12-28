import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back2164 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        int cnt=0;
        while(true){
            if(cnt%2==0){
                q.poll();
            }else{
                int num=q.poll();
                q.add(num); 
            }
            cnt++;
            if(q.size()==1){
                System.out.println(q.poll());
                return;
            }
        }        
    }
}
