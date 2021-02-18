import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak2157 {    
    static int n,m,k;
    static int[][] dist;
    static int[][] dp;
    static int INF=987654321;
    static int dp(int idx,int cnt){
        if(idx==n)return 0;
        if(cnt==m&&idx!=n)return -INF;
        if(dp[idx][cnt]!=-1)return dp[idx][cnt];
        dp[idx][cnt]=-INF;
        for(int i=idx+1;i<=n;i++){
            if(dist[idx][i]!=0){
                dp[idx][cnt]=Math.max(dp[idx][cnt],dp(i, cnt+1)+dist[idx][i]);
            }
        }    
        return dp[idx][cnt];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());       
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        dist=new int[301][301];                
        dp=new int[301][301];
        for(int i=0;i<n;i++)for(int j=0;j<m;j++)dp[i][j]=-1;
        for(int i=0;i<k;i++){
            st=new StringTokenizer(bf.readLine()); 
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            dist[from][to]=Math.max(dist[from][to],cost);
        }
        System.out.println(dp(1,1));
    }    
}
