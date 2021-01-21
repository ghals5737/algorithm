import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class back16118 {
    static class Node{
        int to;
        int cost;
        public Node(int to,int cost){
            this.to=to;
            this.cost=cost;
        }
    }
    static int n,m;
    static int[] dist;
    static int[] dist2;
    static ArrayList<Node>[] node;
    static int INF=987654321;
    static void fox(int start){
        for(int i=0;i<=n;i++)dist[i]=INF;
        PriorityQueue<Node>pq=new PriorityQueue<>((Node a,Node b)->{return a.cost-b.cost;});
        pq.add(new Node(start,0));
        dist[start]=0;
        while(!pq.isEmpty()){
            Node n=pq.poll();
            int now=n.to;
            int cost=n.cost;
            for(Node el:node[now]){
                int next=el.to;
                int nextCost=cost+el.cost;
                if(dist[next]>nextCost){
                    dist[next]=nextCost;
                    pq.add(new Node(next,nextCost));
                }
            }            
        }
    }
    static void wolf(int start){
        for(int i=0;i<=n;i++)dist2[i]=INF;
        PriorityQueue<Node>pq=new PriorityQueue<>((Node a,Node b)->{return a.cost-b.cost;});
        pq.add(new Node(start,0));
        dist2[start]=0;
        boolean flag=false;
        while(!pq.isEmpty()){
            int size=pq.size();
            for(int i=0;i<size;i++){
                Node n=pq.poll();
                int now=n.to;
                int cost=n.cost;
                for(Node el:node[now]){
                    int next=el.to;
                    int nextCost=cost+el.cost;
                    if(dist2[next]>nextCost){
                        dist2[next]=nextCost;
                        pq.add(new Node(next,nextCost));
                    }
                }    
            }                    
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        node=new ArrayList[n+1];
        dist=new int[n+1];
        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            node[from].add(new Node(to, cost));
            node[to].add(new Node(from, cost));
        }
    }    
}
