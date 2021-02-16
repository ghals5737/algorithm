import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak17492 {
    static int n;
    static int[][] map;
    static int[] dx={0,1,1,1,0,-1,-1,-1};
    static int[] dy={-1,-1,0,1,1,1,0,-1};
    static boolean flag;
    static boolean check(int x,int y){
        return x>=0&&x<n&&y>=0&&y<n;
    }
    static void dfs(int cnt){
        if(flag)return;
        if(cnt==1){
            flag=true;
            return;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==2){
                    int x=j;
                    int y=i;
                    for(int k=0;k<8;k++){
                        int nx=x+dx[k];
                        int ny=y+dy[k];
                        int nx2=x+2*dx[k];
                        int ny2=y+2*dy[k];
                        if(check(ny,nx)&&check(ny2,nx2)&&map[ny][nx]==2&&map[ny2][nx2]==0){
                            map[ny][nx]=0;
                            map[y][x]=0;
                            map[ny2][nx2]=2;
                            dfs(cnt-1);
                            map[y][x]=2;
                            map[ny2][nx2]=0;
                            map[ny][nx]=2;
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());  
        n=Integer.parseInt(st.nextToken());
        map=new int[n][n];
        int cnt=0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());  
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==2)cnt++;
            }
        }
        dfs(cnt);
        if(flag)System.out.println("Possible");
        else System.out.println("Impossible");
    }    
}
