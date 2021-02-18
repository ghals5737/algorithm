import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak1562 {
    static int n;
    static long[][][] dp;
    static long mod=1000000000;
    static long dp(int level, int num,int stat){
        if(level==n){
            if(stat==(1<<10)-1)return 1;
            else return 0;
        }
        if(dp[level][num][stat]!=0)return dp[level][num][stat];
        if(num-1>=0)dp[level][num][stat]+=dp(level+1, num-1, stat|(1<<(num-1)));
        if(num+1<=9)dp[level][num][stat]+=dp(level+1, num+1, stat|(1<<(num+1)));
        return dp[level][num][stat]=dp[level][num][stat]%mod;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        dp=new long[105][10][(1<<10)];
        long ans=0;
        for(int i=1;i<=9;i++){
            ans+=dp(1,i,(1<<i));
            ans%=mod;
        }
        System.out.println(ans);
    }    
}
