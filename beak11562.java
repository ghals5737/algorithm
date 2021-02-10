import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak11562 {
    static int n,m,k;
    static int[][] dp;
    static int INF=987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());   
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++)for(int j=1;j<=n;j++)if(i!=j)dp[i][j]=INF;    
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());   
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            if(c==1){
                dp[a][b]=0;
                dp[b][a]=0;
            }else{
                dp[a][b]=0;
                dp[b][a]=1;
            }
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
        st=new StringTokenizer(bf.readLine());                  
        int k=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<k;i++){
            st=new StringTokenizer(bf.readLine());   
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            sb.append(dp[start][end]+"\n");
        }
        System.out.println(sb);
    }    
}
