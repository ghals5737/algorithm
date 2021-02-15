import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class beak12019 {
    static int n,m;
    static int[] arr;
    static int INF=987654321;
    static int[][][] dp=new int[101][101][101];        
    static int dp(int now,int cnt,int prev,int sum){
        if(now==n)return dp[now][cnt][prev]=sum*arr[now];
        if(dp[now][cnt][prev]!=-1)return dp[now][cnt][prev];
        dp[now][cnt][prev]=INF;
        if(cnt>0)dp[now][cnt][prev]=Math.min(dp[now][cnt][prev],dp(now+1, cnt-1,now,0));
        dp[now][cnt][prev]=Math.min(dp[now][cnt][prev],dp(now+1, cnt,prev,sum+arr[now]));
        return dp[now][cnt][prev]+=arr[now]*sum;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());  
        n=Integer.parseInt(st.nextToken());  
        m=Integer.parseInt(st.nextToken());
        arr=new int[n+1];     
        st=new StringTokenizer(bf.readLine());  
        for(int i=1;i<=n;i++)arr[i]=Integer.parseInt(st.nextToken());
        for(int i=0;i<=100;i++)for(int j=0;j<=100;j++)for(int k=0;k<=100;k++)dp[i][j][k]=-1;
        StringBuilder sb=new StringBuilder();
        sb.append(dp(1,m,0,0)+"\n");
        int cnt=m;int prev=0;               
        for(int i=1;i<n;i++){
            if(cnt==0)break;
            int a=dp[i+1][cnt][prev];
            int b=dp[i+1][cnt-1][i];
            if(a>=b){
                prev=i;
                sb.append(i+" ");
                cnt--;
            }            
        }        
        System.out.println(sb);
    }    
}
