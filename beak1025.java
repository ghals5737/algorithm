import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak1025 {
    static int n,m;
    static int ans=-1;
    static int[][] map;
    static boolean check(int x,int y){
        return x>=1&&x<=m&&y>=1&&y<=n;
    }   
    static boolean isAble(int n){
        int num=(int)Math.sqrt(n);
        return n==num*num;
    } 
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(bf.readLine()); 
            String s=st.nextToken();
            for(int j=1;j<=m;j++){
                char c=s.charAt(j-1);
                map[i][j]=c-'0';
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                for(int y=-n;y<=n;y++){
                    for(int x=-m;x<=m;x++){
                        if(y==0&&x==0)continue;
                        int nx=j;
                        int ny=i;
                        int num=0;
                        while(check(nx, ny)){
                            num*=10;
                            num+=map[ny][nx];
                            if(isAble(num))ans=Math.max(ans, num);
                            nx+=x;
                            ny+=y;
                        }
                        if(isAble(num))ans=Math.max(ans, num);
                    }
                }
            }  
        }
        System.out.println(ans);
    }    
}
