import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak11062 {
    static int t,n;
    static int[] card;
    static int[][][] dp;
    static int dp(int l,int r,int flag){
        if(l>=r){
            if(flag==1)return dp[l][r][flag]=card[l];
            return 0;
        }
        if(dp[l][r][flag]!=-1)return dp[l][r][flag];      
        if(flag==1){
            dp[l][r][flag]=Math.max(dp(l+1, r, 1-flag)+card[l],dp(l, r-1, 1-flag)+card[r]);
        }else{
            dp[l][r][flag]=Math.min(dp(l+1, r, 1-flag),dp(l, r-1, 1-flag));
        }
        return dp[l][r][flag];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        t=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        for(int tt=0;tt<t;tt++){
            st=new StringTokenizer(bf.readLine()); 
            n=Integer.parseInt(st.nextToken());
            card=new int[n];
            st=new StringTokenizer(bf.readLine()); 
            for(int i=0;i<n;i++)card[i]=Integer.parseInt(st.nextToken());
            dp=new int[n][n][2];
            for(int i=0;i<n;i++)for(int j=0;j<n;j++)for(int k=0;k<2;k++)dp[i][j][k]=-1;
            sb.append(dp(0,n-1,1)+"\n");
        }
        System.out.println(sb);
    }    
}
