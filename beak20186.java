import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak20186 {
    static int n,k;
    static PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b.compareTo(a));
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        int sum=((k-1)*k)/2;
        int ans=0;
        st=new StringTokenizer(bf.readLine()); 
        for(int i=0;i<n;i++)pq.add(Integer.parseInt(st.nextToken()));
        for(int i=0;i<k;i++)ans+=pq.poll();        
        System.out.println(ans-sum);
    }    
}
