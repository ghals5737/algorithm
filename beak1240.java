import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak1240 {
    static class Pair{
        int next;
        int cost;
        Pair(int next,int cost){
            this.next=next;
            this.cost=cost;
        }
    }
    static ArrayList<Pair>[] node;
    static boolean[] v;
    static int n,m,ans;
    static void dfs(int now,int end,int cost){
        if(now==end){
            ans=cost;
            return;
        }
        v[now]=true;
        for(Pair p:node[now]){
            if(v[p.next])continue;
            dfs(p.next,end,cost+p.cost);
        }    
        v[now]=false;    
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine());
        StringBuilder sb=new StringBuilder();
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        node=new ArrayList[n+1];
        v=new boolean[n+1];
        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(bf.readLine()); 
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            node[from].add(new Pair(to,cost));
            node[to].add(new Pair(from,cost));
        }
        for(int i=0;i<m;i++){                 
            st=new StringTokenizer(bf.readLine()); 
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            dfs(start, end, 0);
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }    
}
