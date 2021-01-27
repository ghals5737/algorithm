import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back5721 {
    static int n,m,ans;
    static int[][] map;
        public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        while(true){
            st=new StringTokenizer(bf.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            if(n+m==0)break;                        
            int[] dp=new int[n+1];
            for(int i=1;i<=n;i++){
                st=new StringTokenizer(bf.readLine());
                int[] max=new int[m+1];
                for(int j=1;j<=m;j++){
                    max[j]=Integer.parseInt(st.nextToken());                    
                    if(j>=2){
                        max[j]=Math.max(max[j-2]+max[j],max[j-1]);
                    }
                }
                dp[i]=max[m];
                if(i>=2){
                    dp[i]=Math.max(dp[i-2]+dp[i],dp[i-1]);
                }
            }          
            sb.append((dp[n]+"\n"));
        }
        System.out.println(sb);        
    }    
}
