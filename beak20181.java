import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak20181 {
    static int n,k;
    static long[] arr,dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        arr=new long[n+1];
        dp=new long[n+1];
        st=new StringTokenizer(bf.readLine()); 
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());            
        }
        long sum=0;
        for(int r=1,l=0;r<=n;r++){
            sum+=arr[r];
            dp[r]=dp[r-1];
            while(sum>=k){
                dp[r]=Math.max(dp[r-1],Math.max(dp[r],dp[l]+sum-k));
                sum-=arr[++l];
            }
        }
        System.out.println(dp[n]);
    }    
}
