import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back12837 {
    static int n,m;
    static int MAX=1000000;
    static long[] seg=new long[1000001*4];
    static void update(int node,int start,int end,int idx,int val){
        if(idx<start||end<idx)return;
        if(start==end){
            seg[node]+=val;
            return;
        }
        int mid=(start+end)/2;
        update(node*2, start, mid, idx, val);
        update(node*2+1, mid+1,end, idx, val);
        seg[node]=seg[node*2]+seg[node*2+1];        
    }
    static long query(int node,int start,int end,int left,int right){
        if(left>end||start>right)return 0;
        if(left<=start&&end<=right)return seg[node];
        int mid=(start+end)/2;
        long l=query(node*2, start, mid, left, right);
        long r=query(node*2+1,mid+1, end, left, right);
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
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            if(a==1){
                update(1,1,n,b,c);
            }else{
                sb.append(query(1,1,n,b,c)+"\n");
            }
        }
        System.out.println(sb);
    }    
}
