import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak2413 {
    static int n;
    static int[] arr;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        arr=new int[n];
        v=new boolean[n];
        st=new StringTokenizer(bf.readLine()); 
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());            
        }                
        for(int i=0;i<n-1;i++){
            int tmp=arr[i];
            for(int j=i+1;j<n;j++){
                if(tmp-1==arr[j]&&!v[i]&&!v[j]){
                    arr[i]=arr[j];
                    arr[j]=tmp;
                    v[i]=v[j]=true;
                }
            }
        
        }
        for(int i=0;i<n;i++)System.out.print(arr[i]+" ");        
    }    
}
