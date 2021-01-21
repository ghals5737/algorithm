import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back1854 {
    static class Pair{
        int to;
        int cost;
        public Pair(int to,int cost){
            this.to=to;
            this.cost=cost;
        }        
    }
    static int n,m,k;
    static ArrayList<Pair>[] node;
    static PriorityQueue<Integer>[] heap;
    
    static void dijk(int start){
         PriorityQueue<Pair>pq=new PriorityQueue<>((Pair a,Pair b)->{return a.cost-b.cost;});
         pq.add(new Pair(start,0));
         heap[start].add(0);
         while(!pq.isEmpty()){
             Pair p=pq.poll();
             int now=p.to;
             int cost=p.cost;
             for(Pair el:node[now]){
                 int next=el.to;
                 int nextCost=cost+el.cost;
                 if(heap[next].size()<k){
                    heap[next].add(nextCost);
                    pq.add(new Pair(next,nextCost));
                 }
                 else if(heap[next].peek()>nextCost){
                     heap[next].poll();
                     heap[next].add(nextCost);
                     pq.add(new Pair(next,nextCost));
                 }
             }
         }
    }    

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());   
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        node=new ArrayList[n+1];
        heap=new PriorityQueue[n+1];
        for(int i=0;i<=n;i++){node[i]=new ArrayList<>();heap[i]=new PriorityQueue<>((a,b)->{return b-a;});}
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            node[from].add(new Pair(to, cost));           
        }
        dijk(1);
        StringBuilder sb=new StringBuilder();        
        for(int i=1;i<=n;i++){
            if(heap[i].size()==k)sb.append(heap[i].peek()+"\n");
            else sb.append(-1+"\n");
        }
        System.out.println(sb);
    }    
}
