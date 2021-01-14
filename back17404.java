import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class back17404 {
    static int[][] cost,dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        cost=new int[n][3];
        dp=new int[n][3];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<3;j++){
                cost[i][j]=Integer.parseInt(st.nextToken());                
            }
        }   
        int ans=987654312;             
        for(int c=0;c<3;c++){
            for(int i=0;i<3;i++){
                if(i==c)dp[0][i]=cost[0][i];
                else dp[0][i]=987654312;
            }
            for(int i=1;i<n;i++){
                dp[i][0]=cost[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
                dp[i][1]=cost[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
                dp[i][2]=cost[i][2]+Math.min(dp[i-1][1],dp[i-1][0]);                
            }
            for(int i=0;i<3;i++){
                if(i!=c)ans=Math.min(ans,dp[n-1][i]);
            }
        }
        System.out.println(ans);
    }    
}
