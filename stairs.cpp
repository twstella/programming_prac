#include <iostream>
using namespace std;
int N;
int* stairs;
int dyn[300][2];
int climb(int i,int j){
	if(i<=-1||j>=2) return 0;
	if(dyn[i][j]!=-1)
		return dyn[i][j];
	else{
		int a=stairs[i]+climb(i-1,j+1);
		int b=stairs[i]+climb(i-2,0);
		int max=(a>b)?a:b;
		dyn[i][j]= max;
	}
	return dyn[i][j];
}
		
int main(){
	cin>>N;
	stairs=new int[N];
	for(int j=0;j<300;j++)
		for(int k=0;k<2;k++)
			dyn[j][k]=-1;
	for(int i=0;i<N;i++)
		cin>>stairs[i];
	cout<<climb(N-1,0);
	return 0;
}
