import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back18430 {
    static int n,m;
    static int[][] map;
    static int ans=0;
    static boolean[][] check;
    static int[][] dx={{-1,0},{-1,0},{0,1},{0,1}};
    static int[][] dy={{0,1},{0,-1},{-1,0},{1,0}};
    static void dfs(int x,int y,int sum){  
        if(x==m){
            x=0;
            y++;
        }
        if(y==n){
            ans=Math.max(sum,ans);
            return;
        }     
        for(int i=0;i<4;i++){
            boolean flag=false;
            for(int j=0;j<2;j++){
                 int nx=x+dx[i][j];
                 int ny=y+dy[i][j];
                 if (nx>=0&&nx<m&&ny>=0&&ny<n&&!check[ny][nx]&&!check[y][x])continue;
                 else flag=true;
            }
            if(!flag){
                check[y][x]=true;
                int ssum=0;
                for(int j=0;j<2;j++){
                    int nx=x+dx[i][j];
                    int ny=y+dy[i][j];
                    check[ny][nx]=true;
                    ssum+=map[ny][nx];                    
                }
                ssum+=map[y][x]*2;                                               
                dfs(x+1,y,sum+ssum);
                check[y][x]=false;
                for(int j=0;j<2;j++){
                    int nx=x+dx[i][j];
                    int ny=y+dy[i][j];
                    check[ny][nx]=false;                    
                }                
            }
        }
        dfs(x+1,y,sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new int[n][m];
        check=new boolean[n][m];

        for(int i=0;i<n;i++) {
             st=new StringTokenizer(bf.readLine());
             for(int j=0;j<m;j++){
                 map[i][j]=Integer.parseInt(st.nextToken());
             }
        }
        ans=0;
        dfs(0,0,0);
        
        System.out.println(ans);
    }    
}
