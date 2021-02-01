import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back2268 {
    static long[] seg=new long[4000001];
    static int n,m;
    static void update(int node,int start,int end,int idx,long val){
        if(idx<start||idx>end)return;
        if(start==end){
            seg[node]=val;
            return;
        }        
        int mid=(start+end)/2;
        update(node*2, start, mid, idx, val);
        update(node*2+1,mid+1,end,idx,val);
        seg[node]=seg[node*2]+seg[node*2+1];
        return;
              
    }
    static long query(int node,int start,int end,int left,int right){
        if(left>end||right<start)return 0;
        if(left<=start&&end<=right)return seg[node];
        int mid=(start+end)/2;
        long l=query(node*2, start,mid, left, right);
        long r=query(node*2+1,mid+1,end, left, right);
        return l+r;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int state=Integer.parseInt(st.nextToken());            
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(state==0){
               if(a>b){
                   int tmp=b;
                   b=a;
                   a=tmp;
               }
               sb.append(query(1,1,n,a,b)+"\n");
            }else{
               update(1,1,n,a,b);              
            }
        }
        System.out.println(sb);
    }    
}
