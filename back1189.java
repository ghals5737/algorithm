import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back1189 {
    static int n,m,k,ans;
    static int[][] map;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static void dfs(int x,int y,int cnt){
        map[y][x]=1;
        if(x==m-1&&y==0&&cnt==k)ans++;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0&&nx<m&&ny>=0&&ny<n&&map[ny][nx]==0){
                dfs(nx,ny,cnt+1);
            }
        }
        map[y][x]=0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        map=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            String s=st.nextToken();
            for(int j=0;j<m;j++){
                char c=s.charAt(j);
                if(c=='T'){
                    map[i][j]=-1;
                }
            }
        }
        ans=0;
        dfs(0,n-1,1);
        System.out.println(ans);
    }    
}
