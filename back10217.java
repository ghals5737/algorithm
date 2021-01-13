import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class back10217 {
    static class Node{
        int to;        
        int cost;
        int time;
        public Node(int to,int cost,int time){
            this.to=to;
            this.cost=cost;
            this.time=time;
        }
    }
    static int t,n,m,k;
    static ArrayList<Node>[] node;
    static int[][] dp;
    static int INF=987654321;
    
    static void dijk(){
        PriorityQueue<Node>pq=new PriorityQueue<>((Node a,Node b)->{return a.time-b.time;});
        pq.add(new Node(1,0,0));
        dp[1][0]=0;
        while(!pq.isEmpty()){
            Node e=pq.poll();
            int now=e.to;
            int cost=e.cost;
            int time=e.time;
            
            for(Node el:node[now]){
                int nextCost=cost+el.cost;
                int nextTime=time+el.time;
                int next=el.to;
                if(nextCost>m)continue;
                if(dp[next][nextCost]>nextTime){
                    for(int i=nextCost;i<=m;i++){                        
                        if(dp[next][i]>nextTime)dp[next][i]=nextTime;
                    }                    
                    pq.add(new Node(next,nextCost,nextTime));
                }
            }
        }        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        StringBuilder sb=new StringBuilder();
        
        t=Integer.parseInt(st.nextToken());
        for(int tt=0;tt<t;tt++){
            st=new StringTokenizer(bf.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());
            node=new ArrayList[n+1];
            dp=new int[n+1][m+1];
            for(int i=0;i<=n;i++)for(int j=0;j<=m;j++)dp[i][j]=INF;
            for(int i=0;i<=n;i++)node[i]=new ArrayList<>();

            for(int i=0;i<k;i++){
                st=new StringTokenizer(bf.readLine());
                int from=Integer.parseInt(st.nextToken());
                int to=Integer.parseInt(st.nextToken());
                int cost=Integer.parseInt(st.nextToken());
                int time=Integer.parseInt(st.nextToken());                
                node[from].add(new Node(to,cost,time));              
            }
            dijk();
            int min=INF;
            for(int i=0;i<=m;i++)min=Math.min(dp[n][i],min);
            if(min==INF)sb.append("Poor KCM\n");
            else sb.append(min+"\n");
        }
        System.out.print(sb);
    }    
}
