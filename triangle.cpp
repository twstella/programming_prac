#include <iostream>
using namespace std;

int** arr;
int N;
int** dyn;
int search(int i,int j){
	if(i>=N||j>i)
		return 0;
	if(dyn[i][j]!=-1) return dyn[i][j];
	else{
		int a=arr[i][j]+search(i+1,j);
		int b=arr[i][j]+search(i+1,j+1);
		int max=(a>b)?a:b;
		dyn[i][j]= max;
		
	}
	return dyn[i][j];
}
int main(){
	cin>>N;
	arr=new int*[N];
	dyn=new int*[N];
	for(int i=0;i<N;i++){
		arr[i]=new int[i+1];
		dyn[i]=new int[i+1];
	}
	for(int a=0;a<N;a++){
		for(int b=0;b<a+1;b++){
			cin>>arr[a][b];
			dyn[a][b]=-1;
		}
	}
	cout<<search(0,0);
	for(int j=0;j<N;j++){
		delete[] arr[j];
		delete[] dyn[j];
	}
	delete[] arr;
	delete[] dyn;
	return 0;
}
