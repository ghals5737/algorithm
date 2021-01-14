import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back2186 {
    static int n,m,k;
    static char[][] map;
    static int[][][] dp;
    static String s;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};

    static int dfs(int x,int y,int cnt){
        if(cnt==s.length())return 1;
        if(dp[y][x][cnt]!=-1)return dp[y][x][cnt];            
        dp[y][x][cnt]=0;
        for(int i=0;i<4;i++){
            for(int j=1;j<=k;j++){
                int nx=x+dx[i]*j;
                int ny=y+dy[i]*j;              
                if(nx>=0&&nx<m&&ny>=0&&ny<n&&s.charAt(cnt)==map[ny][nx]){
                    dp[y][x][cnt]+=dfs(nx,ny,cnt+1);
                }
            }
        }
        return dp[y][x][cnt];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        map=new char[n][m];        
       
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            String str=st.nextToken();
            for(int j=0;j<m;j++){
                char c=str.charAt(j);
                map[i][j]=c;
            }
        }
        st=new StringTokenizer(bf.readLine());
        s=st.nextToken();
        dp=new int[n][m][s.length()];   
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int d=0;d<s.length();d++){
                    dp[i][j][d]=-1;
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==s.charAt(0)){                      
                    ans+=dfs(j,i,1);
                }
            }
        }
        System.out.println(ans);
    }    
}
