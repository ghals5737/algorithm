import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class beak1094 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        int leng=64;
        int cnt=0;
        while(leng>0){
            if(leng>n){
                leng/=2;
            }else{
                cnt++;
                n-=leng;
            }
        }
        System.out.println(cnt);
    }    
}
