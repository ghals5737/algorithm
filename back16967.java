import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back16967 {
    static int n,m,nn,mm;
    static int[][] a,b;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        nn=Integer.parseInt(st.nextToken());
        mm=Integer.parseInt(st.nextToken());

        b=new int[n+nn][m+mm];
        for(int i=0;i<n+nn;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<m+mm;j++){
                b[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        a=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i>=nn&&j>=mm){
                    a[i][j]=b[i][j]-a[i-nn][j-mm];
                }else{
                    a[i][j]=b[i][j];
                }
            }
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(a[i][j]+" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }   
}
