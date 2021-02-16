import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak17494 {
    static int n,m;
    static int[][] dp;
    static int[] w,h;    

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());   
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
       
        w=new int[n+1];
        h=new int[n+1];
        int sum=0;
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(bf.readLine()); 
            w[i]=Integer.parseInt(st.nextToken());
            h[i]=Integer.parseInt(st.nextToken());                                    
            sum+=w[i];
        }        
        if(sum<m){
            System.out.println("죄송합니다 한승엽 병장님");
            return ;
        }
        dp=new int[n+1][sum+1];
        //for(int i=0;i<=sum;i++)dp[1][i]=;  
        dp[1][w[1]]=h[1];      
        for(int i=2;i<=n;i++){
            int ww=w[i];
            int hh=h[i];            
            if(dp[i][ww]==0)dp[i][ww]=hh;
            else dp[i][ww]=Math.min(dp[i][ww],hh);            
            for(int j=0;j<=sum;j++){               
               if(dp[i-1][j]>0&&j+ww<=sum){
                   if(dp[i][j]==0)dp[i][j]=dp[i-1][j];
                   else dp[i][j]=Math.min(dp[i][j],dp[i-1][j]);
                   if(dp[i-1][j+ww]==0)dp[i][j+ww]=dp[i-1][j]+hh;                  
                   else {
                       dp[i][j+ww]=Math.min(dp[i-1][j]+hh,dp[i-1][j+ww]);                                                          
                   }
               }
               
            }            
        }
       int ans=987654312;
       for(int i=m;i<=sum;i++)if(dp[n][i]>0)ans=Math.min(ans,dp[n][i]);     
       System.out.println(ans);
    }    
}
