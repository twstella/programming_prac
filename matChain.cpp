#include <iostream>
using namespace std;
int p[11]={1,1,2,3,4,5,6,7,8,9,10};
int matChain(int i,int j){
	if(i==j) return 0;
	int min=999999999;
	for(int k=i;k<j;k++){
		int tmp=matChain(i,k)+matChain(k+1,j)+p[i-1]*p[k]*p[j];
		if(min>tmp)
			min=tmp;
	}
	return min;
}
int main(){
	cout<<matChain(1,3);
	return 0;
}
