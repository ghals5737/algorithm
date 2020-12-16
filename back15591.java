import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class back15591{
    static class Point{
        int to;
        int cost;
        public Point(int to,int cost){
            this.to=to;
            this.cost=cost;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        ArrayList<Point>[] edge=new ArrayList[n+1];
        for(int i=0;i<=n;i++)edge[i]=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            int from=sc.nextInt();
            int to=sc.nextInt();
            int cost=sc.nextInt();
            edge[from].add(new Point(to,cost));
            edge[to].add(new Point(from,cost));            
        }
        for(int i=0;i<m;i++){
            boolean[] visited=new boolean[n+1];
            Queue<Integer>q=new LinkedList<>();
            int k=sc.nextInt();
            int v=sc.nextInt();
            q.add(v);
            visited[v]=true;
            int cnt=0;
            while(!q.isEmpty()){
                int now=q.poll();
                for(Point p:edge[now]){
                    if(!visited[p.to]&&p.cost>=k){
                        cnt++;
                        visited[p.to]=true;
                        q.add(p.to);
                    }
                }
            }
            System.out.println(cnt);
        }                        
    }
}