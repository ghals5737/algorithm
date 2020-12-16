import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class back1800 {
    static class Pair{
        int to;
        int cost;
        public Pair(int to,int cost){
            this.to=to;
            this.cost=cost;
        }
    }

    static int n,p,k;
    static ArrayList<Pair>[]edge;
    static int MAX= (int) 1e7;

    static boolean check(int mid){
        int [] dist=new int[n+1];
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(1,0));
        for(int i=0;i<=n;i++)dist[i]=987654321;
        dist[1]=0;       
        while(!q.isEmpty()){
            Pair nP=q.poll();
            int now=nP.to;
            int cost=nP.cost;
            if(dist[now]<cost)continue;
            for(Pair pp:edge[now]){
                int next=pp.to;
                int nCost=cost+(pp.cost>mid?1:0);
                if(dist[next]>nCost){
                    dist[next]=nCost;
                    q.add(new Pair(next,nCost));
                }
            }            
        }
        return dist[n]<=k;
    }

    static int binary(int left,int right){
        int result=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(check(mid)){                
                result=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        p=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        edge=new ArrayList[n+1];
        for(int i=0;i<=n;i++)edge[i]=new ArrayList<>();
        for(int i=0;i<p;i++){
            st=new StringTokenizer(bf.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            edge[from].add(new Pair(to,cost));
            edge[to].add(new Pair(from,cost));
        }
      
        System.out.println(binary(1,MAX));
    }
}