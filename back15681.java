import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back15681 {
    static int n,r,q;
    static int[] dp;
    static boolean[] visited;
    static ArrayList<Integer>[] node;
    static int dfs(int now){
        if(dp[now]!=0)return dp[now];
        visited[now]=true;
        int sum=1;
        for(int next:node[now]){
            if(!visited[next]){
                sum+=dfs(next);
            }
        }
        dp[now]=sum;
        return dp[now];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        
        n=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());
        q=Integer.parseInt(st.nextToken());
        node=new ArrayList[n+1];
        dp=new int[n+1];
        visited=new boolean[n+1];
        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
        for(int i=1;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);
        }
        dfs(r);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<q;i++){
            st=new StringTokenizer(bf.readLine());
            int now=Integer.parseInt(st.nextToken());
            sb.append(dp[now]+"\n");
        }
        System.out.println(sb);
    }    
}
