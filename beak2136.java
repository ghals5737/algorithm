import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class beak2136 {
    static int n,m;
    static class Pair{
        int num;
        int d;
        Pair(int num,int d){
            this.num=num;
            this.d=d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        StringBuilder sb=new StringBuilder();  
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        PriorityQueue<Pair>pq=new PriorityQueue<>((Pair a,Pair b)->{return a.d-b.d;});
        PriorityQueue<Pair>pq1=new PriorityQueue<>((Pair a,Pair b)->{return a.d-b.d;});
        int cnt=0;
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(bf.readLine()); 
            int num=i;
            int d=Integer.parseInt(st.nextToken());
            pq.add(new Pair(num,Math.abs(d)));
            if(num<0){
                cnt++;
            }
        }
        int k=1;
        while(k++<cnt){
            pq.poll();            
        }
        Pair left=pq.poll();
        Pair right=pq.poll();
        if(left.d>m-right.d)System.out.println(left.num+" "+left.d);
        else System.out.println(right.num+" "+(m-right.d));        
    }    
}
