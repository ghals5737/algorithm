import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak2615 {
    static int n=19;
    static int[][] map=new int[19][19];
    static int[] dx={1,1,0,-1};
    static int[] dy={0,1,1,1};
    static int ax,ay;
    static boolean isAble(int x,int y){
        return x>=0&&x<n&&y>=0&&y<n;
    }
    static boolean check(int x,int y,int mod){
        int num=map[y][x];
        ax=x;
        ay=y;
        if(isAble(x-dx[mod], y-dy[mod])){
            if(map[y-dy[mod]][x-dx[mod]]==num)return false;
        }
        for(int i=0;i<5;i++){
            int nx=x+i*dx[mod];
            int ny=y+i*dy[mod];
            if(ax>nx){
                ax=nx;
                ay=ny;
            }
            if(isAble(nx,ny)&&map[ny][nx]==num)continue;
            return false;
        }
        if(isAble(x+5*dx[mod], y+5*dy[mod])){
            if(map[y+5*dy[mod]][x+5*dx[mod]]==num)return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
       
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==0)continue;
                for(int k=0;k<4;k++){
                    if(check(j, i, k)){
                        System.out.println(map[i][j]);
                        System.out.println((ay+1)+" "+(ax+1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
