import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak9944 {
    static int n,m,max,ans;
    static boolean[][] map;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static boolean check(int x,int y){
        return x>=0&&x<m&&y>=0&&y<n;
    }
    static void dfs(int x,int y,int cnt,int r){
         if(cnt==max){             
             ans=Math.min(r,ans);
             return;
         }
         for(int i=0;i<4;i++){
             int nx=x+dx[i];
             int ny=y+dy[i];
             int nCnt=0;
             while(check(nx, ny)&&!map[ny][nx]){
                 nCnt++;
                 map[ny][nx]=true;
                 nx+=dx[i];
                 ny+=dy[i];
             }
             if(nCnt==0)continue;
             dfs(nx-dx[i],ny-dy[i],cnt+nCnt,r+1);
             nx-=dx[i];
             ny-=dy[i];
             for(int j=0;j<nCnt;j++){
                 map[ny][nx]=false;
                 nx-=dx[i];
                 ny-=dy[i];
             }
         }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=null;
        int t=0;
        String input="";
        StringBuilder sb=new StringBuilder();
        while((input=bf.readLine())!= null){
            st=new StringTokenizer(input);
            t++;
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            map=new boolean[n][m];
            max=0;
            for(int i=0;i<n;i++){
                st=new StringTokenizer(bf.readLine());
                String str=st.nextToken();
                for(int j=0;j<m;j++){
                    char c=str.charAt(j);
                    if(c=='*'){
                        map[i][j]=true;
                    }else{
                        max++;
                    }                
                }
            }
            ans=987654321;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(!map[i][j]){
                        map[i][j]=true;
                        dfs(j, i, 1, 0);
                        map[i][j]=false;
                    }
                }
            }            
            if (ans == 987654321) {
				System.out.println("Case " + String.valueOf(t) + ": -1");
			} else {
				System.out.println("Case " + String.valueOf(t) + ": " + ans);
			}
        }        
    }    
}
