import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak11560 {
    static int t,k,n;
    static long[][] dp=new long[25][300];
    static void go(int idx){
        if(idx>20){
            return;
        }
        int i = 0;
        while(dp[idx-1][i] != 0){
            long now_coe = dp[idx-1][i];
            for(int root = 0; root <= idx; root++){
                int next_root = i + root;
                dp[idx][next_root] = dp[idx][next_root] + (now_coe * 1);
            }
            i++;
        }
        go(idx+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());   
        t=Integer.parseInt(st.nextToken());
        dp[0][0]=1;        
        go(1);
        for(int tt=0;tt<t;tt++){
            st=new StringTokenizer(bf.readLine()); 
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            System.out.println(dp[a][b]);
        }
    }    
}
