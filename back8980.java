import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back8980 {
    static class Info{
        int start;
        int end;
        int w;
        public Info(int start,int end,int w){
            this.start=start;
            this.end=end;
            this.w=w;
        }
    }
    static int n,c,m;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        m=Integer.parseInt(st.nextToken());
        ArrayList<Info>list=new ArrayList<>();
        int[] cap=new int[n+1];
        for(int i=0;i<n+1;i++)cap[i]=c;

        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            list.add(new Info(start,end,w));
        }

        list.sort((Info a,Info b)->{
            if(a.end==b.end){
                return a.start-b.start;
            }else{
                return a.end-b.end;
            }
        });
        int ans=0;
        for(int i=0;i<m;i++){
            Info el=list.get(i);
            int min=987564321;
            for(int j=el.start;j<el.end;j++){
                 min=Math.min(cap[j],min);
            }
            if(min>=el.w){
                min=el.w;
            }
            for(int j=el.start;j<el.end;j++){
                cap[j]-=min;            
            }            
            ans+=min;
        }
        System.out.println(ans);
    }
}
