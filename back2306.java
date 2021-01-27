import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back2306 {
    static String s;
    static int[][] dp;

    static int solve(int l,int r){
        if(l>=r)return 0;
        if(dp[l][r]!=-1)return dp[l][r];        
        for(int k=l;k<r;k++){
            dp[l][r]=Math.max(dp[l][r],solve(l,k)+solve(k+1,r));
        }
        if((s.charAt(l)=='a'&&s.charAt(r)=='t')||(s.charAt(l)=='g'&&s.charAt(r)=='c')){
            dp[l][r]=Math.max(dp[l][r],solve(l+1,r-1)+2);
        }
        return dp[l][r];        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        s=st.nextToken();
        dp=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++)Arrays.fill(dp[i],-1);
        System.out.println(solve(0,s.length()-1));    
    }    
}
