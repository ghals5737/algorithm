import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class beak1461 {
    static PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
    static PriorityQueue<Integer>pq1=new PriorityQueue<>((a,b)->a-b);
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine()); 
        int max=0;
        for(int i=0;i<n;i++){
            int num=Integer.parseInt(st.nextToken());
            if(num>0)pq.add(num);
            else pq1.add(num);
            max=Math.max(Math.abs(num),max);
        }
        int ans=0;        
        while(!pq.isEmpty()){
          ans+=pq.poll()*2;              
          for(int i=0;i<m-1&&!pq.isEmpty();i++)pq.poll();
        }
        while(!pq1.isEmpty()){
            ans+=Math.abs(pq1.poll())*2;                        
            for(int i=0;i<m-1&&!pq1.isEmpty();i++)pq1.poll();
          }
        System.out.println(ans-max);
    }    
}
