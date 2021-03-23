import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class beak10837 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        StringBuilder sb=new StringBuilder();  
        int n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine()); 
        int c=Integer.parseInt(st.nextToken());
        for(int i=0;i<c;i++){
            st=new StringTokenizer(bf.readLine()); 
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int d=Math.abs(a-b);
            int r=n-Math.max(a, b);
            if(a==b){
                sb.append("1\n");
            }else if(a<b){
                if(d-r<=1){
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }
            }else{
                if(d-r<=2){
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }
            }
        }
        System.out.print(sb);
    }    
}
