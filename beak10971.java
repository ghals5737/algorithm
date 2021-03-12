import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak10971 {
	static int n;
	static int[][] cost;
	static boolean[] v;
	static int ans=Integer.MAX_VALUE;
	static void dfs(int now,int cnt,int sum,int end) {
		if(n-1==cnt) {
			if(cost[now][end]!=0) {
				ans=Math.min(ans,sum+cost[now][end]);
			}
			return;
		}
		v[now]=true;
		for(int i=0;i<n;i++) {			
			if(cost[now][i]==0||v[i])continue;
			dfs(i,cnt+1,sum+cost[now][i],end);
		}	
		v[now]=false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();		
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		cost=new int[n][n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				cost[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		v=new boolean[n];
		for(int i=0;i<n;i++) {			
			dfs(i,0,0,i);
		}
		System.out.println(ans);
	}
}
