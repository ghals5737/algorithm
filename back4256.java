import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back4256 {
    static int n;
    static int[] in,pre;
    
    static void post(int root,int s,int e){
        for(int i=s;i<e;i++){
            if(in[i]==pre[root]){   
                post(root+1,s,i);
                post(root+1+i-s,i+1,e);
                System.out.print(pre[root]+" ");
            }      
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int tc=Integer.parseInt(st.nextToken());
        for(int t=0;t<tc;t++){
             st=new StringTokenizer(bf.readLine());
             n=Integer.parseInt(st.nextToken());

             in=new int[n];
             pre=new int[n];
             st=new StringTokenizer(bf.readLine());
             for(int i=0;i<n;i++){
                 pre[i]=Integer.parseInt(st.nextToken());
             }
             st=new StringTokenizer(bf.readLine());
             for(int i=0;i<n;i++){
                in[i]=Integer.parseInt(st.nextToken());
            }

            post(0, 0, n);
            System.out.println();
        }
    }    
}
