import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back11812 {
    static int k,q;
    static long n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());  
        n=Long.parseLong(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        q=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<q;i++){
            st=new StringTokenizer(bf.readLine());
            long a=Long.parseLong(st.nextToken());
            long b=Long.parseLong(st.nextToken());
            if(k==1){
                sb.append(Math.abs(a-b)+"\n");  
            }else{
                long cnt=0;
                while(a!=b){
                    if(a>b){
                        a=(a-2)/k+1;
                    }else{
                        b=(b-2)/k+1;
                    }
                    cnt++;
                }
                sb.append(cnt+"\n");
            }
        }
        System.out.println(sb);
    }   
}
