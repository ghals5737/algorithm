import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class beak14618 {
    static class Pair{
        int to;
        int cost;
        public Pair(int to,int cost){
            this.to=to;
            this.cost=cost;
        }
    }
    static int n,m;
    static int a,b;
    static int[] check,dist;
    static ArrayList<Pair>[] node;
    static int INF=987654321;
    static void dijk(int start){
        dist=new int[n+1];
        for(int i=0;i<=n;i++)dist[i]=INF;
        PriorityQueue<Pair>pq=new PriorityQueue<>((Pair a,Pair b)->{return a.cost-b.cost;});
        dist[start]=0;
        pq.add(new Pair(start,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int now=p.to;
            int cost=p.cost;
            for(Pair el:node[now]){
                int next=el.to;
                int nextCost=cost+el.cost;
                if(dist[next]>nextCost){
                    dist[next]=nextCost;
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
        st=new StringTokenizer(bf.readLine());
        a=Integer.parseInt(st.nextToken());     
        st=new StringTokenizer(bf.readLine());
        b=Integer.parseInt(st.nextToken());     
        check=new int[n+1];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<b;i++){            
            check[Integer.parseInt(st.nextToken())]=1;     
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<b;i++){            
            check[Integer.parseInt(st.nextToken())]=2; 
        }
        node=new ArrayList[n+1];
        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();        
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            node[from].add(new Pair(to, cost));
            node[to].add(new Pair(from,cost));
        }
        dijk(a);
        int aMin=INF;
        int bMin=INF;
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++){
            if(check[i]==1)aMin=Math.min(dist[i],aMin);
            if(check[i]==2)bMin=Math.min(dist[i],bMin);
        }
        if(aMin!=INF||bMin!=INF){            
            if(aMin<=bMin){
                sb.append("A\n"+aMin+"\n");
            }else{
                sb.append("B\n"+bMin+"\n");
            }
        }else{
            sb.append("-1\n");
        }
        System.out.print(sb);       
    }    
}
