import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak1693 {
    static int n;
    static long[][] dp=new long[100001][21];
    static ArrayList<Integer>[] node;
    static long dp(int prev,int now,int color){
        if(dp[now][color]!=-1)return dp[now][color];
        long result=0;
        dp[now][color]=color;
        for(int next:node[now]){
            if(prev!=next){
                long min=Long.MAX_VALUE;
                for(int i=1;i<=20;i++)if(i!=color)min=Math.min(min,dp(now,next,i));
                result+=min;
            }
        }
        return dp[now][color]+=result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());   
        n=Integer.parseInt(st.nextToken());
        node=new ArrayList[n+1];
        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
        for(int i=0;i<=n;i++)for(int j=0;j<=20;j++)dp[i][j]=-1;
        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);
        }   
        //System.out.println("?");
        long ans=Long.MAX_VALUE; 
        for(int i=1;i<=20;i++){
            ans=Math.min(ans,dp(0,1,i));
        }
        System.out.println(ans);
    }    
}
