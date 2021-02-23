import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class beak15553 {
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine()); 
        int startNum=Integer.parseInt(st.nextToken());
        int t1=startNum;
        int t2=0;
        int cnt=0;
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=1;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            t2=Integer.parseInt(st.nextToken());
            int num=t2-t1-1;
            if(num!=0){
                pq.add(num);
            }else{
                cnt++;
            }
            t1=t2;
        }

        int tmp=n-cnt-k;        
        while(tmp-->0){
            n+=pq.poll();
        }
        System.out.println(n);
    }    
}
