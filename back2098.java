import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back2098 {
    static int[][] dp;
    static int[][] w;
    static int n;
    static int max;
    static int INF=987654321;
    static int dfs(int idx,int state){
        if(max-1==state){
            if(w[idx][0]==0)return INF;
            else return w[idx][0];
        }
        if(dp[idx][state]!=INF)return dp[idx][state];
        for(int i=0;i<n;i++){
            int next=state|(1<<i);
            if(w[idx][i]==0||(state&(1<<i))!=0)continue;
            dp[idx][state]=Math.min(dfs(i,next)+w[idx][i],dp[idx][state]);
        }
        return dp[idx][state];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        max=(1<<n);   
        dp=new int[n][max];
        w=new int[n][n];      
        for(int i=0;i<n;i++){
            for(int j=0;j<max;j++){
                dp[i][j]=INF;
            }
        }
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                w[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dfs(0,1));
    }    
}
