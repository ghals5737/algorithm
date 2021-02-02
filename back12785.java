import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back12785 {
    static int n1,m1,n2,m2;
    static long[][] map;
    static int n,m;
    static int mod=1000007;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());                    
        m1=Integer.parseInt(st.nextToken());
        n1=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());                    
        m2=Integer.parseInt(st.nextToken());
        n2=Integer.parseInt(st.nextToken());
        map=new long[n1][m1];
        for(int i=0;i<n1;i++)map[i][0]=1;
        for(int i=0;i<m1;i++)map[0][i]=1;
        for(int i=1;i<n1;i++){
            for(int j=1;j<m1;j++){
                map[i][j]=(map[i-1][j]+map[i][j-1])%mod;                
            }
        }            
        System.out.println((map[n2-1][m2-1]*map[n1-n2][m1-m2])%mod);
    }    
}
