import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class beak15783 {
	static int n,m;
	static ArrayList<Integer>[] node;
	static boolean[] v;
	static Stack<Integer>s=new Stack<Integer>();
	static void dfs(int now,boolean flag) {
		if(v[now])return;
		v[now]=true;
		for(int next:node[now]) {
			if(!v[next]) {
				dfs(next,flag);
			}
		}
		if(flag)s.add(now);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();		
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		node=new ArrayList[n+1];
		v=new boolean[n];
		for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			node[from].add(to);			
		}
		for(int i=0;i<n;i++)dfs(i,true);
		v=new boolean[n];
		int ans=0;
		while(!s.isEmpty()) {
			int now=s.pop();
			if(v[now])continue;
			dfs(now,false);
			ans++;			
		}
		System.out.println(ans);
	}
}
