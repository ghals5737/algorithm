import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class back2610 {
    static int n,m;
    static ArrayList<Integer>[] node;
    static int dp[][];
    static int INF=987654321;
    static boolean[] visitied;
    static PriorityQueue<Integer>pq;
    static void dfs(int now){
        if(visitied[now])return;
        pq.add(now);
        visitied[now]=true;
        for(int next:node[now])dfs(next);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        m=Integer.parseInt(st.nextToken());
        node=new ArrayList[n+1];
        visitied=new boolean[n+1];
        dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
        for(int i=1;i<=n;i++)for(int j=1;j<=n;j++)if(i!=j)dp[i][j]=INF;
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);
            dp[a][b]=1;
            dp[b][a]=1;
        }       
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(dp[i][j]>dp[i][k]+dp[k][j]){
                        dp[i][j]=dp[i][k]+dp[k][j];
                    }
                }
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(!visitied[i]){
                pq=new PriorityQueue<>();
                dfs(i);
                int min=INF;
                int head=0;
                while(!pq.isEmpty()){
                    int num=pq.poll();
                    int max=0;
                    for(int j=1;j<=n;j++){
                        if(dp[num][j]!=INF&&j!=num)max=Math.max(max,dp[num][j]);
                    }
                    if(max<min){
                        head=num;
                        min=max;
                    }
                }
                ans.add(head);
            }            
        }
        StringBuilder sb=new StringBuilder();
        sb.append(ans.size()+"\n");
        ans.sort((a,b)->{return a-b;});
        for(int num:ans)sb.append(num+"\n");
        System.out.println(sb);
    }    
}
