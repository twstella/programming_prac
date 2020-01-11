#include <iostream>
using namespace std;
int N;
int Findmin(int a,int b,int c){
	int min=a;
	if(min>b) min=b;
	if(min>c) min=c;
	return min;
}
int* dyn;
int count(int n){
	if(dyn[n]!=-1) return dyn[n];
	else{
		if(n==1) dyn[n]= 0;
		else{
			int a=99999999;
			if(n%3==0) a=1+count(n/3);
			int b=99999999;
			if(n%2==0) b=1+count(n/2);
			int c=1+count(n-1);
			dyn[n]= Findmin(a,b,c);
		}
	}
	return dyn[n];
}

int main(){
	cin>>N;
	dyn=new int[N+1];
	for(int i=0;i<N+1;i++)
		dyn[i]=-1;
	cout<<count(N);
	delete[] dyn;
	return 0;
}
