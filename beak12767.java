import java.util.HashSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class beak12767 {
    static HashSet<String>set=new HashSet<>();
    static int n,m;
    static class Tree{
        int num;
        Tree left=null;
        Tree right=null;
        Tree(int num){
            this.num=num;
        }
    }
    static Tree head;
    static String s;
    static void insert(Tree now,int num){
        if(now.num<num){
            if(now.left!=null)insert(now.left,num);
            else now.left=new Tree(num);
        }else{
            if(now.right!=null)insert(now.right,num);
            else now.right=new Tree(num);
        }
    }
    static void search(Tree now,int cnt,String str){
        s+=(cnt+str);
        if(now.left!=null)search(now.left,cnt+1,"L");
        if(now.right!=null)search(now.right,cnt+1,"R");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        int ans=0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            s="";
            for(int j=0;j<m;j++){
                int num=Integer.parseInt(st.nextToken());
                if(j==0){
                    head=new Tree(num);                    
                }else{
                    insert(head, num);
                }
            }
            search(head,1,"L");
            if(!set.contains(s)){
                ans++;
                set.add(s);
            }
        }
        System.out.println(ans);
    }    
}
