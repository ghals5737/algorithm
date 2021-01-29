import java.util.*;

class Solution {
    static ArrayList<Integer>[]node;
    static int[] dist;
    static boolean[] check;
    static int max=0;
    static int V=0;
    static void dfs(int now){
        if(check[now])return;
        check[now]=true;
        if(max<dist[now]){
            max=dist[now];
            V=now;
        }
        for(int next:node[now]){
            if(!check[next]){
                dist[next]=dist[now]+1;
                dfs(next);
            }
        }
    }
    
    public int solution(int n, int[][] edges) {
        int answer = 0;
        node=new ArrayList[n+1];
        check=new boolean[n+1];
        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            node[edges[i][0]].add(edges[i][1]);
            node[edges[i][1]].add(edges[i][0]);
        }
        dist=new int[n+1];
        check=new boolean[n+1];
        V=0;
        dfs(1);
        dist=new int[n+1];
        check=new boolean[n+1];
        int num=V;
        V=0;
        max=0;             
        dfs(num);
        int cnt=0;                                                                                                                          
        for(int i=1;i<=n;i++){
            if(dist[i]==dist[V])cnt++;
        }                
        if(cnt==1){
            dist=new int[n+1];
            check=new boolean[n+1];
            num=V;
            V=0;
            max=0;             
            dfs(num);
            cnt=0;            
            for(int i=1;i<=n;i++){
                if(dist[i]==dist[V])cnt++;
            }   
            if(cnt==1){
                answer=dist[V]-1;
            }else if(cnt>=2){
                answer=dist[V];
            }else{
                answer=-1;
            }
        }
        else if(cnt>=2)answer=dist[V];
        else answer=-1;
        return answer;
    }
}
