import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class beak2553 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        long num=1;
        for(int i=1;i<=n;i++){
            num*=i;
            num%=100000000;
            while(num%10==0)num/=10;
        }
        System.out.println(num%10);
    }    
}
