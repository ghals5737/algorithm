import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class beak1034 {
    static int n,m,k,ans;
    static int[][] map;
    static boolean compare(int[] a,int [] b){
        for(int i=0;i<m;i++){
            if(a[i]!=b[i])return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine()); 
            String s=st.nextToken();
            for(int j=0;j<m;j++){
                char c=s.charAt(j);
                map[i][j]=c-'0';
            }
        }
        st=new StringTokenizer(bf.readLine()); 
        k=Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<m;j++)if(map[i][j]==0)cnt++;            
            if(cnt<=k&&k%2==cnt%2){
                cnt=0;
                for(int j=0;j<n;j++){                    
                    if(compare(map[i],map[j]))cnt++;
                }
            }
            ans=Math.max(ans,cnt);
        }
        System.out.println(ans);
    }    
}
