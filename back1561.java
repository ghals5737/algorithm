import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back1561 {
    static int n,m;
    static int[] arr;
    static void binary(){

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());  
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[m];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<m;i++)arr[i]=Integer.parseInt(st.nextToken());
        
    }    
}
