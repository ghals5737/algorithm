import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back3109 {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static boolean flag;
    static int ans;
    static int[] dx={1,1,1};
    static int[] dy={-1,0,1};

    static void dfs(int x,int y){        
        visited[y][x]=true;
        if(x==m-1){
            ans++;
            flag=true;
            return;
        }
        for(int k=0;k<3;k++){
            int nx=x+dx[k];
            int ny=y+dy[k];
            if(nx>=0&&nx<m&&ny>=0&&ny<n&&!visited[ny][nx]&&map[ny][nx]==0){
                dfs(nx,ny);
                if(flag)return;
            }
        }
    }
  
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new int[n][m];
        visited=new boolean[n][m];
        ans=0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            String s=st.nextToken();
            for(int j=0;j<m;j++){
                char c=s.charAt(j);
                if(c=='.'){
                    map[i][j]=0;
                }else{
                    map[i][j]=-1;
                }
            }
        }
        for(int i=0;i<n;i++){
            flag=false;
            dfs(0,i);
        }
        System.out.println(ans);
    }
}
