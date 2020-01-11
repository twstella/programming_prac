#include <iostream>
using namespace std;
int dyn[1000];
int fibo(int n){
	dyn[0]=1;
	dyn[1]=1;
	for(int i=2;i<1000;i++)
		dyn[i]=dyn[i-1]+dyn[i-2];
	return dyn[n];
}

int main(){

	cout<<fibo(5);
	return 0;
}
