import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class beak17270 {
    static class Node{
        int to;
        int cost;
        public Node(int to,int cost){
            this.to=to;
            this.cost=cost;
        }        
    }
    static int n,m;
    static int a,b;
    static ArrayList<Node>[] node;
    static int[] d1,d2;
    static int INF=987654321;
    static void djik(int start,int[] d){
        for(int i=0;i<=n;i++)d[i]=INF;
        d[start]=0;
        PriorityQueue<Node>pq=new PriorityQueue<>((Node a,Node b)->{return a.cost-b.cost;});
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node el=pq.poll();
            int now=el.to;
            int cost=el.cost;
            for(Node e:node[now]){
                int next=e.to;
                int nextCost=cost+e.cost;
                if(d[next]>nextCost){
                    d[next]=nextCost;
                    pq.add(new Node(next,nextCost));
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
        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            node[from].add(new Node(to,cost));
            node[to].add(new Node(from,cost));
        }
        st=new StringTokenizer(bf.readLine());
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        d1=new int[n+1];
        d2=new int[n+1];
        djik(a,d1);        
        djik(b,d2);        
        int min=INF;
        Queue<Integer>q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(i==a||i==b)continue;
            int sum=d1[i]+d2[i];
            min=Math.min(sum,min);            
        }
        for(int i=1;i<=n;i++){
            if(i==a||i==b)continue;
            int sum=d1[i]+d2[i];
            if(min==sum)q.add(i);
        }
        int minA=INF;
        while(!q.isEmpty()){
            int now=q.poll();
            int da=d1[now];
            int db=d2[now];
            if(da<=db){
                minA=Math.min(da,minA);
            }
        }        
        if(minA==INF)System.out.println(-1);
        else{
            for(int i=1;i<=n;i++){
                if(i==a||i==b)continue;                
                if(minA==d1[i]){
                    System.out.println(i);
                    return;
                }
            }
        }
    }    
}
