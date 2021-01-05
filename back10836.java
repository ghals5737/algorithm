import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back10836 {
    static int n,m;
    static int[] arr;    

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[2*n-1];
        
        for(int i=0;i<2*n-1;i++)arr[i]=1;
        for(int t=0;t<m;t++){
            st=new StringTokenizer(bf.readLine());           
            int[] w=new int[3];
            for(int i=0;i<3;i++)w[i]=Integer.parseInt(st.nextToken());
            int idx=0;            
            for(int i=0;i<2*n-1;i++){
                while(w[idx]==0)idx++;
                arr[i]+=idx;
                w[idx]--;
            }              
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==0) sb.append(arr[n-1-i]+" ");                
                else sb.append(arr[n-1+j]+" ");                
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }    
}
