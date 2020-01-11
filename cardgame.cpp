#include <iostream>
using namespace std;
int* arr;
int N;
int dyn[1001][1001];
int* score;
int func(int i,int j){
	int sum;
	if(i>0) sum=score[j]-score[i-1];
	else sum=score[j];
	if(dyn[i][j]!=-1) return dyn[i][j];
	else{
		if(i==j) return arr[i];

		int r;
		int r1=func(i+1,j);
		int r2=func(i,j-1);
		if(r1<r2) r=sum-r1;
		else r=sum-r2;
			dyn[i][j]= r;
	}
	return dyn[i][j];
}

	
int main(){
	int t;
	cin>>t;
	for(int j=0;j<t;j++){
		cin>>N;
		arr=new int[N];
		score=new int[N];
		for(int a=0;a<1001;a++)
			for(int b=0;b<1001;b++)
				dyn[a][b]=-1;
		for(int i=0;i<N;i++)
			cin>>arr[i];
		score[0]=arr[0];
		for(int c=1;c<N;c++)
			score[c]=score[c-1]+arr[c];
		cout<<func(0,N-1)<<endl;
		delete[] arr;
		delete[] score;
	}
	
	return 0;
}
