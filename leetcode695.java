// class Solution {
//     int[] dx={0,1,0,-1};
//     int[] dy={-1,0,1,0};
//     boolean[][] v;
//     int n,m;
//     boolean isAble(int x,int y){
//         return x>=0&&y>=0&&x<m&&y<n;
//     }
//     int dfs(int x,int y,int[][] grid){
//         v[y][x]=true;
//         int res=1;
//         for(int i=0;i<4;i++){
//             int nx=x+dx[i];
//             int ny=y+dy[i];
//             if(isAble(nx,ny)&&!v[ny][nx]&&grid[ny][nx]==1){
//                 res+=dfs(nx,ny,grid);
//             }
//         }        
//         return res;
//     }
//     public int maxAreaOfIsland(int[][] grid) {
//         n=grid.length;
//         m=grid[0].length;
//         v=new boolean[n][m];
//         int ans=0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(grid[i][j]==1&&!v[i][j])ans=Math.max(ans,dfs(j,i,grid));
//             }
//         }
//         return ans;
//     }
// }
