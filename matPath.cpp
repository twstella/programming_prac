#include <iostream>
using namespace std;

int arr[4][4]={{6,7,12,5},{5,3,11,18},{7,17,3,3},{8,10,14,9}};
int path(int r,int c){
	if(r==-1||c==-1) return 0;
	else {
		printf("%d-%d(%d)\n",r,c,arr[r][c]);
		int a=path(r-1,c);
		int b=path(r,c-1);
		printf("<%d>\n",max(a,b));
		return arr[r][c]+max(a,b);
	}
}
int max(int a,int b){return (a>b)?a:b;}
int main(){
	cout<<path(3,3);
	return 0;
}
