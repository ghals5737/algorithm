import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back18427 {
    static int n,m,h;
    static int[][] dp;
    static ArrayList<Integer>[] block;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());
        dp=new int[51][1001];
        block=new ArrayList[n+1];
        for(int i=0;i<=n;i++)block[i]=new ArrayList<>();
        for(int i=1;i<=n;i++){
             st=new StringTokenizer(bf.readLine());
             while(st.hasMoreTokens()){
                 String s=st.nextToken();
                 block[i].add(Integer.parseInt(s));
             }                                          
        }       
        for(int i=0;i<=n;i++)dp[i][0]=1;        
        for(int i=1;i<=n;i++){          
            for(int j=1;j<=h;j++){
                for(int num:block[i]){
                    if(j-num>=0){
                        dp[i][j]+=dp[i-1][j-num];
                        dp[i][j]%=10007;
                    }                    
                }
                dp[i][j]+=dp[i-1][j];
                dp[i][j]%=10007;
            }            
        }        
        System.out.println(dp[n][h]);        
    }
}