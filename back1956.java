import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back1956{
    static int n,m;
    static int[][] dp;
    static int INF=987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++)for(int j=0;j<=n;j++)if(i!=j)dp[i][j]=987654321;
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            dp[a][b]=c;
        }
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(dp[i][j]>dp[i][k]+dp[k][j])dp[i][j]=dp[i][k]+dp[k][j];
                }
            }
        }
        int tmp=INF;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i!=j&&dp[i][j]!=INF&&dp[j][i]!=INF){
                    tmp=Math.min(tmp,dp[i][j]+dp[j][i]);
                }
            }
        }
        if(tmp==INF)System.out.println(-1);
        else System.out.println(tmp);
    }
}