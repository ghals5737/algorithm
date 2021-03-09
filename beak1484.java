import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());  
        int g=Integer.parseInt(st.nextToken());
        long s=1;
        long e=1;
        boolean flag=false;
        while(true){
            long num=e*e-s*s;
            if(num==g){
                System.out.println(e);
                flag=true;
            }
            if(e-s==1&&num>g)break;
            if(num>g)s++;
            else e++;
        }
        if(!flag)System.out.println(-1);
    }    
}
