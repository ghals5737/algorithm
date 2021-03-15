import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak17779 {
    static int n;
    static int[][] map,copyMap;     
    static int solve(int sx,int sy){
        int d1=sy;
        int d2=n-sy;
        for(int i=1;i<=d1;i++){
            for(int j=1;j<=d2;j++){
                copyMap=new int[n][n];
                
            }
        }
        return 0;
    }   
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        map=new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine()); 
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans=Math.min(ans,solve(j,i));
            }
        }
    }    
}
