#include <iostream>
using namespace std;
int p[11]={1,1,2,3,4,5,6,7,8,9,10};
int dyn[20][20];
int matChain(int i,int j){
	//printf("i:%d j:%d\n",i,j);
	if(dyn[i][j]!=-1)
		return dyn[i][j];
	else{
		if(i==j) dyn[i][j]= 0;
		else{
			int min=999999999;
			for(int k=i;k<j;k++){
				int tmp=matChain(i,k)+matChain(k+1,j)+p[i-1]*p[k]*p[j];
				if(min>tmp)
					min=tmp;
			}
			dyn[i][j]= min;
		}
	}
	return dyn[i][j];
}
int main(){
	for(int i=0;i<20;i++)
		for(int j=0;j<20;j++)
			dyn[i][j]=-1;
	cout<<matChain(1,3)<<endl;
	/*
	for(int a=0;a<20;a++){
		for(int b=0;b<20;b++)
			cout<<dyn[a][b]<<" ";
		cout<<endl;
	}
	*/
	return 0;
}
