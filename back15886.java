import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back15886 {
    static int n,m,k;
    static int[][] dp;
    static String ans="";
    static int count(int A,int B){
        if(A==0||B==0)return 1;
        if(dp[A][B]!=0)return dp[A][B];
        dp[A][B]=Math.min(count(A-1,B)+count(A, B-1),1000000001);
        return dp[A][B];
    }
    static void solve(int A,int B,int skip){
        if(A==0){
            for(int i=0;i<B;i++)ans+='z';
            return;
        }
        if(B==0){
            for(int i=0;i<A;i++)ans+='a';
            return;            
        }
        int idx=count(A-1, B);
        if(skip<idx){
            ans+='a';
            solve(A-1,B,skip);
        }else{
            ans+='z';
            solve(A,B-1,skip-idx);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        dp=new int[n+1][m+1];
        dp[1][0]=dp[0][1]=1;
        boolean flag=false;
        if(k>count(n,m)){
            System.out.println(-1);
            return;
        }
        solve(n,m,k-1);
        System.out.println(ans);
    }
}
