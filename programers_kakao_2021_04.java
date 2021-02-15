public class programers_kakao_2021_04 {
   
        static long[][] dp=new long[201][201];
        static int INF=987654321;
        public long solution(int n, int s, int a, int b, int[][] fares) {
            long answer = INF;
            for(int i=1;i<=n;i++)for(int j=1;j<=n;j++)if(i!=j)dp[i][j]=INF;
            for(int[] arr:fares){
                dp[arr[0]][arr[1]]=arr[2];
                dp[arr[1]][arr[0]]=arr[2];          
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
            for(int i=1;i<=n;i++){
                long sum=dp[s][i]+dp[i][a]+dp[i][b];            
                answer=Math.min(sum,answer);
            }
            return answer;
        }
    
}
