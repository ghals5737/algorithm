import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak14620 {
    static int n,ans;
    static int[][] map;
    static boolean[][] v;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static boolean check(int x,int y){
        return x>=0&&x<n&&y>=0&&y<n;
    }
    static void dfs(int sum,int cnt){
        if(cnt==3){
            ans=Math.min(ans,sum);
            return;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!v[i][j]){
                    boolean flag=false;
                    for(int k=0;k<4;k++){
                        int nx=j+dx[k];
                        int ny=i+dy[k];
                        if(!(check(nx, ny)&&!v[ny][nx])){
                            flag=true;
                            break;
                        }
                    }
                    if(!flag){
                        v[i][j]=true;
                        int now=map[i][j];
                        for(int k=0;k<4;k++){
                            int nx=j+dx[k];
                            int ny=i+dy[k];
                            v[ny][nx]=true;
                            now+=map[ny][nx];
                        }
                        dfs(sum+now,cnt+1);
                        v[i][j]=false;
                        for(int k=0;k<4;k++){
                            int nx=j+dx[k];
                            int ny=i+dy[k];
                            v[ny][nx]=false;
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        StringBuilder sb=new StringBuilder();  
        n=Integer.parseInt(st.nextToken());
        map=new int[n][n];
        v=new boolean[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine()); 
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        ans=987654321;
        dfs(0,0);
        System.out.println(ans);
    }    
}
