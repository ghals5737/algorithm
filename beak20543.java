import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak20543 {
    static long[][][][] dp;
    static int n;
    static int mod=1000000007;
    static long dp(int now,int cur,int prev,int flag){
        if(now==n-1){
            if(flag==1){
                return dp[now][cur][prev][flag]=1;
            }else{
                return dp[now][cur][prev][flag];
            }
        }
        if(dp[now][cur][prev][flag]!=0)return dp[now][cur][prev][flag];
        if(cur==0){
            dp[now][cur][prev][flag]+=dp(now+1,0,cur,flag)%mod;
            dp[now][cur][prev][flag]+=dp(now+1,1,cur,flag)%mod;
            dp[now][cur][prev][flag]+=dp(now+1,2,cur,1)%mod;
        }else if(cur==1){
            if(prev==0){
                dp[now][cur][prev][flag]+=dp(now+1,0,cur,flag)%mod;
                dp[now][cur][prev][flag]+=dp(now+1,1,cur,flag)%mod;
                dp[now][cur][prev][flag]+=dp(now+1,2,cur,1)%mod;
            }else{
                dp[now][cur][prev][flag]+=dp(now+1,0,cur,flag)%mod;
            }
        }else{
            if(prev==0){
                dp[now][cur][prev][flag]+=dp(now+1,0,cur,flag)%mod;
                dp[now][cur][prev][flag]+=dp(now+1,1,cur,flag)%mod;                
            }else{
                dp[now][cur][prev][flag]+=dp(now+1,0,cur,flag)%mod;
            }
        }        
        return dp[now][cur][prev][flag]=dp[now][cur][prev][flag]%mod;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        dp=new long[n+1][3][3][2];  
        System.out.println(dp(0,0,0,0));    
    }
}
