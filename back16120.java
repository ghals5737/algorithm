import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back16120 {
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        
        s=st.nextToken();
        int cnt=0;
        int idx=0;
        while(idx<s.length()){
            char c=s.charAt(idx);
            if(c=='P'){
                cnt++;
                idx++;
                continue;
            }
            if(idx+1<s.length()&&cnt>=2&&s.charAt(idx+1)=='P'){                
                cnt--;
                idx+=2;                
            }else{
                System.out.println("NP");
                return;
            }
        }        
        if(cnt==1)System.out.println("PPAP");
        else System.out.println("NP");
    }    
}
