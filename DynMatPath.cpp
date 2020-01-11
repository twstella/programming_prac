#include <iostream>
using namespace std;

int arr[4][5]={{0,6,7,12,5},{0,5,3,11,18},{0,7,17,3,3},{0,8,10,14,9}};
int dyn[10][10];
int path(int r,int c){
	if(dyn[r][c]!=-1)
		return dyn[r][c];
	else{
		if(r==0||c==0) dyn[r][c]=arr[r][c];
		else {
			//printf("%d-%d(%d)\n",r,c,arr[r][c]);
			int a=path(r-1,c);
			int b=path(r,c-1);
			//printf("<%d>\n",max(a,b));
			dyn[r][c]= arr[r][c]+max(a,b);
		}
	}
	return dyn[r][c];
}
int max(int a,int b){return (a>b)?a:b;}
int main(){
	for(int i=0;i<10;i++)
		for(int j=0;j<10;j++)
			dyn[i][j]=-1;
	cout<<path(3,4);
	return 0;
}
