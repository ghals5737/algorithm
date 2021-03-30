
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
public class beak1725 {
    static int n;
    static PriorityQueue<Integer>pq1=new PriorityQueue<>();
    static PriorityQueue<Integer>pq2=new PriorityQueue<>((a,b)->b.compareTo(a));
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        StringBuilder sb=new StringBuilder(); 
        n=Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine()); 
            int num=Integer.parseInt(st.nextToken());
            pq1.add(num);
            pq2.add(num);
        }
        int sum=0;
        if(pq1.size()==1){
            System.out.println(0);
            return;
        }
        while(true){
            int num=pq1.poll()+pq1.poll();
            sum+=num;
            if(pq1.isEmpty())break;
            pq1.add(num);
        }
        System.out.println(sum);
    }
}
