import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back2638 {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static int cheese;
    static void dfs(int x,int y){
        visited[y][x]=true;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0&&nx<m&&ny>=0&&ny<n&&!visited[ny][nx]&&map[ny][nx]==0){
                dfs(nx,ny);
            }
        }
    }
    static void delete(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==1){
                    int cnt=0;
                    for(int k=0;k<4;k++){
                        int nx=j+dx[k];
                        int ny=i+dy[k];
                        if(nx>=0&&nx<m&&ny>=0&&ny<n&&visited[ny][nx]){
                            cnt++;
                        }
                    }
                    if(cnt>=2){
                        map[i][j]=0;
                        cheese--;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        
        cheese=0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==1)cheese++;
            }
        }
        int ans=0;
        while(cheese>0){
            visited=new boolean[n][m];
            dfs(0,0);
            delete();
            ans++;           
        }
        System.out.println(ans);
    }    
}
