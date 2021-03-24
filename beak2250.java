import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class beak2250 {
    static class Node{
        int p;
        int left=0;
        int right=0;
        Node(int p){
            this.p=p;
        }
    }   
    static Node[] node;  
    static int n,maxLevel,point;  
    static int[] maxL,minL;
    static void inorder(int now,int level){
        maxLevel=Math.max(maxLevel,level);
        if(node[now].left!=-1){
            inorder(node[now].left, level+1);
        }
        minL[level]=Math.min(minL[level], point);
        maxL[level]=point;
        point++;
        if(node[now].right!=-1){
            inorder(node[now].right, level+1);
        }           
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        StringBuilder sb=new StringBuilder();  
        n=Integer.parseInt(st.nextToken());
        node=new Node[n+1];
        maxL=new int[n+1];
        minL=new int[n+1];
        for(int i=0;i<=n;i++){
            node[i]=new Node(-1);
            maxL[i]=0;
            minL[i]=n;
        }
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(bf.readLine()); 
            int num=Integer.parseInt(st.nextToken());
            int l=Integer.parseInt(st.nextToken());
            int r=Integer.parseInt(st.nextToken());
            node[num].left=l;
            node[num].right=r;
            if(node[num].left!=-1)node[l].p=num;
            if(node[num].right!=-1)node[r].p=num;
        }
        point=1;
        for(int i=1;i<=n;i++){
            if(node[i].p==-1){
                inorder(i,1);
                break;
            }
        }
        int ansL=1;
        int ansD=maxL[1]-minL[1]+1;
        for(int i=2;i<=maxLevel;i++){
            int nowD=maxL[i]-minL[i]+1;
            if(nowD>ansD){
                ansD=nowD;
                ansL=i;
            }
        }
        System.out.print(ansL+" ");
        System.out.println(ansD);
    }    
}
