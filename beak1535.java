import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class beak1535 {
    static int n;
    static int[] cost;
    static int[] joy;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        cost=new int[n];
        joy=new int[n];
        dp=new int[n][101];
        st=new StringTokenizer(bf.readLine()); 
        for(int i=0;i<n;i++)cost[i]=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine()); 
        for(int i=0;i<n;i++)joy[i]=Integer.parseInt(st.nextToken());
        for(int i=0;i<=100;i++)if(i-cost[0]>0)dp[0][i]=joy[0];
        for(int i=1;i<n;i++){
            for(int j=0;j<101;j++){
                dp[i][j]=dp[i-1][j];
                if(j-cost[i]>0){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-cost[i]]+joy[i]);
                }
            }
        }
        System.out.println(dp[n-1][100]);
    }    
}
