import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back12784 {
    static class Pair{
        int to;
        int cost;
        public Pair(int to,int cost){
            this.to=to;
            this.cost=cost;
        }
    }
    static int t,n,m;
    static ArrayList<Pair>[] node;
    
    static int INF=987654321;
    static int dfs(int prv,int now,int dst){
        int ret=0;
        for(Pair el:node[now]){
            if(prv!=el.to){
                ret+=dfs(now,el.to,el.cost);
            }
        }
        if(ret==0)ret=dst;
        return Math.min(ret,dst);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        t=Integer.parseInt(st.nextToken());
        while(t-->0){
            st=new StringTokenizer(bf.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            node=new ArrayList[n+1];            
            for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
            for(int i=0;i<m;i++){
                st=new StringTokenizer(bf.readLine());
                int from=Integer.parseInt(st.nextToken());
                int to=Integer.parseInt(st.nextToken());
                int cost=Integer.parseInt(st.nextToken());
                node[from].add(new Pair(to,cost));
                node[to].add(new Pair(from,cost));
            }
            System.out.println(m==0?0:dfs(0,1,INF));
        }
    }    
}
