import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak9252 {
    static int[][] dp;
    static String a,b;
    static int n,m;
    static void print(int i,int j){
        if(dp[i][j]==0)return;
        if(a.charAt(i-1)==b.charAt(j-1)){
            print(i-1,j-1);
            System.out.print(a.charAt(i-1));
        }else{
            if(dp[i-1][j]>dp[i][j-1])print(i-1, j);
            else print(i, j-1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        a=st.nextToken();
        st=new StringTokenizer(bf.readLine()); 
        b=st.nextToken();
        n=a.length();
        m=b.length();
        dp=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            char aa=a.charAt(i);
            for(int j=0;j<m;j++){
                char bb=b.charAt(j);
                if(aa==bb)dp[i+1][j+1]=dp[i][j]+1;
                else dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
            }
        }
        System.out.println(dp[n][m]);
        print(n,m);
    }    
}
