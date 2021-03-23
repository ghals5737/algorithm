import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class beak14908 {
    static class Pair{
        int num;        
        double cost;
        Pair(int num,double cost){
            this.num=num;            
            this.cost=cost;
        }
    }
    
    static int n;
    static int[] arr;
    static PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
        if(a.cost==b.cost)return a.num-b.num;
        else return Double.compare(a.cost, b.cost);
    });
        public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        StringBuilder sb=new StringBuilder();  
        n=Integer.parseInt(st.nextToken());
        arr=new int[n+1];
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(bf.readLine()); 
            int t=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            pq.add(new Pair(i, ((double)t)/s));
        }
        
        while(!pq.isEmpty()){
            sb.append(pq.poll().num+" ");
        }
        System.out.println(sb);
    }    
}
