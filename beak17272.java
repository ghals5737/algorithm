import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak17272 {
    static int n,m;
    static String ans,guess;
    static int[][] dp;
    static boolean check(int a,int b){
        char aa=guess.charAt(a-1);
        char bb=ans.charAt(b-1);
        if(aa==bb)return true;
        else if(aa=='i'&&(bb=='i'||bb=='j'||bb=='l'))return true;
        else if(aa=='v'&&(bb=='v'||bb=='w'))return true;        
        else return false;
    }
    static int solve(){
        dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++)dp[i][0]=i;
        for(int i=0;i<=m;i++)dp[0][i]=i;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(check(i,j)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());  
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());  
        guess=st.nextToken();
        st=new StringTokenizer(bf.readLine());          
        ans=st.nextToken();
        System.out.println(solve());        
    }        
}
