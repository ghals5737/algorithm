import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak1456 {
    static boolean[] prime=new boolean[10000001];
    static long a,b;
    static ArrayList<Integer>list=new ArrayList<>();
    static void makePrime(){
        for(int i=2;i<10000001;i++){
            if(prime[i])continue;
            list.add(i);
            for(int j=i+i;j<10000001;j+=i){
                prime[j]=true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        a=Long.parseLong(st.nextToken());
        b=Long.parseLong(st.nextToken());
        long cnt=0;
        makePrime();
        for(int num:list){
            long now=num;            
            while(now<=b/num){
                now*=num;
                if(now>=a)cnt++;
            }
        }
        System.out.println(cnt);
    }    
}
