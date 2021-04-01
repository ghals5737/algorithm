import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak1500 {
    static long s,k;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        s=Long.parseLong(st.nextToken());
        k=Long.parseLong(st.nextToken());
        long num=s/k;
        long ans=1;
        long n=s%k;
        long cnt=0;
        while(n>cnt++){
            ans*=(num+1);            
        }        
        cnt=0;
        n=k-n;
        while(n>cnt++){
            ans*=num;
        }        
        System.out.println(ans);
    }    
}
