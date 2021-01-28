import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back7570 {
    static int n;
    static int[] dp=new int[1000005];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());  
        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());  
        int ans=0;
        for(int i=0;i<n;i++){
            int num=Integer.parseInt(st.nextToken());
            dp[num]=dp[num-1]+1;                        
            ans=Math.max(ans,dp[num-1]+1);
        }
        System.out.println(n-ans);
    }    
}
