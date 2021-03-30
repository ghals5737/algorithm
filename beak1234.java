import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class beak1234 {
    static long[][][][] dp=new long[11][101][101][101];
    static int n,R,G,B;
    static long[] fac=new long[11];
    static int[][] lev={{1,0,0},{0,1,0},{0,0,1},{1,1,0},{1,0,1},{0,1,1},{1,1,1}};
    static long solve(int l,int r,int g,int b){
        if(l==n+1)return 1;
        if(dp[l][r][g][b]!=-1)return dp[l][r][g][b];
        dp[l][r][g][b]=0;
        for(int i=0;i<7;i++){
            if(l%(i/3+1)!=0)continue;
            int m=l/(i/3+1);
            int nr=r-lev[i][0]*m;
            int ng=g-lev[i][1]*m;
            int nb=b-lev[i][2]*m;
            if(nr<0||nb<0||ng<0)continue;
            long cnt=fac[l]/(fac[lev[i][0]*m]*fac[lev[i][1]*m]*fac[lev[i][2]*m]);
            dp[l][r][g][b]+=cnt*solve(l+1,nr,ng,nb);
        }
        return dp[l][r][g][b];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine());        
        n=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        G=Integer.parseInt(st.nextToken());
        B=Integer.parseInt(st.nextToken());
        for(int i=0;i<=10;i++)for(int j=0;j<=100;j++)for(int ii=0;ii<=100;ii++)for(int jj=0;jj<=100;jj++)dp[i][j][ii][jj]=-1;
        fac[0]=1;
        for(int i=1;i<=n;i++){
            fac[i]=i*fac[i-1];
        }
        System.out.println(solve(1,R,G,B));
    }    
}
