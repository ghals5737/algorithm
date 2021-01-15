import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class back11779 {
    static class Info{
        int next;
        int cost;
        public Info(int next,int cost){
            this.next=next;
            this.cost=cost;
        }
    }
    static int n,m;
    static int start,end;
    static ArrayList<Info>[]node;
    static int[] arr;
    static int[] dist;
    static int INF=987654321;

    static void dijk(){
        PriorityQueue<Info>pq=new PriorityQueue<>((Info a,Info b)->{return a.cost-b.cost;});
        pq.add(new Info(start,0));
        dist[start]=0;
        while(!pq.isEmpty()){
            Info el=pq.poll();
            int now=el.next;
            int cost=el.cost;                       
            for(Info e:node[now]){
                int next=e.next;
                int nextCost=e.cost+cost;
                if(dist[next]>nextCost){
                    dist[next]=nextCost;
                    arr[next]=now;                    
                    pq.add(new Info(next,nextCost));
                }
            }
        }
    }
    static String s="";
    static int dfs(int now,int cnt){
        if(now==0){            
            return 0;
        }        
        int num=dfs(arr[now],cnt+1);        
        s+=now+" ";
        return num+1;
    } 
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());   
        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        m=Integer.parseInt(st.nextToken());

        node=new ArrayList[n+1];
        arr=new int[n+1];
        dist=new int[n+1];
        for(int i=0;i<=n;i++){node[i]=new ArrayList<>();dist[i]=INF;}
        for(int i=0;i<m;i++){
             st=new StringTokenizer(bf.readLine());
             int from=Integer.parseInt(st.nextToken());
             int to=Integer.parseInt(st.nextToken());
             int cost=Integer.parseInt(st.nextToken());
             node[from].add(new Info(to,cost));                                     
        }
        st=new StringTokenizer(bf.readLine());
        start=Integer.parseInt(st.nextToken());
        end=Integer.parseInt(st.nextToken());
        dijk();        
        System.out.println(dist[end]);
        System.out.println(dfs(end,0));
        System.out.println(s);
    }    
}
