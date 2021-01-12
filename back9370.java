import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back9370 {
    static class Node{
        int to;
        int cost;        
        public Node(int to,int cost){
            this.to=to;
            this.cost=cost;            
        }
    }
    static int tt,n,m,t,s,g,h;
    static int[] arr;
    static ArrayList<Node>[] node;
    static int[] S;
    static int[] G;
    static int[] H;
    static int INF=987654321;    
    static ArrayList<Integer>ans;

    static void dijk(int startX,int[] dist){
        Queue<Node>q=new LinkedList<>();
        q.add(new Node(startX,0));
        for(int i=0;i<=n;i++)dist[i]=INF;
        dist[startX]=0;
        while(!q.isEmpty()){
            Node el=q.poll();
            int now=el.to;
            int cost=el.cost;  
            
            for(Node e:node[now]){
                if(dist[e.to]>dist[now]+e.cost){
                    dist[e.to]=dist[now]+e.cost;
                    q.add(new Node(e.to,dist[e.to]));                              
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 

        tt=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        for(int t1=0;t1<tt;t1++){
            st=new StringTokenizer(bf.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            t=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(bf.readLine());
            s=Integer.parseInt(st.nextToken());
            g=Integer.parseInt(st.nextToken());
            h=Integer.parseInt(st.nextToken());
            node=new ArrayList[n+1];
            S=new int[n+1];
            G=new int[n+1];
            H=new int[n+1];

            arr=new int[t];
            for(int i=0;i<=n;i++)node[i]=new ArrayList<>();            
            for(int i=0;i<m;i++){
                st=new StringTokenizer(bf.readLine());
                int from=Integer.parseInt(st.nextToken());
                int to=Integer.parseInt(st.nextToken());
                int cost=Integer.parseInt(st.nextToken());
                node[from].add(new Node(to,cost));
                node[to].add(new Node(from,cost));
            }
            for(int i=0;i<t;i++){
                st=new StringTokenizer(bf.readLine());
                arr[i]=Integer.parseInt(st.nextToken());
            }           
            dijk(s,S);
            dijk(g,G);
            dijk(h,H);
            Arrays.sort(arr);
            for(int i:arr){
                //if(i==g||i==h||i==s)continue;                
                if((S[i]==S[g]+G[h]+H[i])||(S[i]==S[h]+H[g]+G[i])){
                    sb.append(i+" ");
                }
            }           
            sb.append("\n");
        }
        System.out.print(sb);
    }    
}
