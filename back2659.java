import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back2659 {
    static int adw=0;
    static int[] aa={1000,100,10,1};  
    static int min=987654321;  
    static int cal(int start){
        String ss=start+"";
        int num=0;
        int idx=0;
        min=987654231;
        for(int i=0;i<4;i++){
            idx=i;
            num=0;
            for(int j=0;j<4;j++){
                int a=(idx+j)%4;
                char c=ss.charAt(a);
                num+=(c-'0')*aa[j];
            }
            min=Math.min(min,num);            
        } 
        return min;       
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());    
        
        for(int i=0;i<4;i++){
            adw+=Integer.parseInt(st.nextToken())*aa[i];        
        }
        adw=cal(adw);
        int ans=0;
        for(int i=1111;i<=adw;i++){
            if(cal(i)==i)ans++;
        }
        System.out.println(ans);
    }    
}
