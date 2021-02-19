import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class beak18234 {
    static class Pair{
        long num;
        long p;
        public Pair(long num,long p){
            this.num=num;
            this.p=p;
        }
    }
    static int n,t;
    static PriorityQueue<Pair>pq=new PriorityQueue<>((Pair a,Pair b)->{
        if(a.p<b.p)return -1;
        else if(a.p==b.p)return 0;
        else return 1;
    });
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        t=Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine()); 
            long num=Long.parseLong(st.nextToken());
            long p=Long.parseLong(st.nextToken());
            pq.add(new Pair(num,p));
        }
        long ans=0;
        int i=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            ans+=p.num+p.p*(t-n+i++);
        }
        System.out.println(ans);
    }    
}
