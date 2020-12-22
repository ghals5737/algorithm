import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back1113 {
    static int n,m,h;
    static int[][][] map;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};

    static void dfs(int x,int y,int h){
        visited[y][x]=true;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0&&nx<m&&ny>=0&&ny<n&&!visited[ny][nx]&&map[h][ny][nx]==2){
                dfs(nx,ny,h);                
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        h=0;
        map=new int[51][n][m];
        arr=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            String s=st.nextToken();
            for(int j=0;j<m;j++){
                char c=s.charAt(j);
                int num=c-'0';
                arr[i][j]=num;
                h=Math.max(h, num);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int num=arr[i][j];
                for(int k=0;k<num;k++)map[k][i][j]=1;
                for(int k=num;k<h;k++)map[k][i][j]=2;
            }
        }
        int hh=h-1;
        while(hh>=0){
            visited=new boolean[n][m];
            for(int i=0;i<m;i++)if(map[hh][0][i]==2&&!visited[0][i])dfs(i,0,hh);
            for(int i=0;i<m;i++)if(map[hh][n-1][i]==2&&!visited[n-1][i])dfs(i,n-1,hh);
            for(int i=0;i<n;i++)if(map[hh][i][0]==2&&!visited[i][0])dfs(0,i,hh);
            for(int i=0;i<n;i++)if(map[hh][i][m-1]==2&&!visited[i][m-1])dfs(m-1,i,hh);
            for(int i=0;i<n;i++)for(int j=0;j<m;j++)if(visited[i][j])map[hh][i][j]=0;
            hh--;
        }
        int ans=0;
        for(int k=0;k<h;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[k][i][j]==2)ans++;
                }
            }
        }
        System.out.println(ans);
    }    
}
