import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back1600 {
	static class Pair{
		int x;
		int y;
		int cnt;
		public Pair(int x,int y,int cnt) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}
	static int k,m,n;
	static int[][] map;
	static int[][][] visited;
	static int[] dx1= {0,1,0,-1};
	static int[] dy1= {-1,0,1,0};
	static int[] dx2= {1,2,2,1,-1,-2,-2,-1};
	static int[] dy2= {-2,-1,1,2,2,1,-1,-2};
	static boolean check(int x,int y) {
		return x>=0&&x<m&&y>=0&&y<n;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		k=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		
		map=new int[n][m];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		Queue<Pair>q=new LinkedList<>();
		visited=new int[n][m][k+1];
		q.add(new Pair(0,0,0));
		visited[0][0][0]=1;
		while(!q.isEmpty()) {
			Pair p=q.poll();
			int x=p.x;
			int y=p.y;
			int cnt=p.cnt;
			if(x==m-1&&y==n-1) {
				System.out.println(visited[y][x][cnt]-1);
				return;
			}
			if(cnt<k) {
				for(int i=0;i<8;i++) {
					int nx=x+dx2[i];
					int ny=y+dy2[i];
					if(check(nx,ny)&&visited[ny][nx][cnt+1]==0&&map[ny][nx]==0) {
						visited[ny][nx][cnt+1]=visited[y][x][cnt]+1;
						q.add(new Pair(nx,ny,cnt+1));						
					}
				}
			}
			for(int i=0;i<4;i++) {
				int nx=x+dx1[i];
				int ny=y+dy1[i];
				if(check(nx,ny)&&visited[ny][nx][cnt]==0&&map[ny][nx]==0) {
					visited[ny][nx][cnt]=visited[y][x][cnt]+1;
					q.add(new Pair(nx,ny,cnt));						
				}
			}
		}
		System.out.println(-1);
		return;		
	}

}
