import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak5502 {
    static int n;
    static int[][] dp;
    static String a,b;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine()); 
        a=st.nextToken();
        b=new StringBuffer(a).reverse().toString();        
        dp=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            char aa=a.charAt(i);
            for(int j=0;j<n;j++){
                char bb=b.charAt(j);
                if(aa==bb)dp[i+1][j+1]=dp[i][j]+1;
                else dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
            }
        }
        System.out.println(n-dp[n][n]);
    }    
}
