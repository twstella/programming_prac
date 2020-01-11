#include <iostream>
#include <string>
using namespace std;
string str;
int** dyn;
int palin(int i,int j){
	if(dyn[i][j]!=-1)
		return dyn[i][j];
	else{
		//printf("%c,%c\n",str[i],str[j]);
		if(i>=j) dyn[i][j]= 0;
		else{
			char a=str[i];
			char b=str[j];
			if(a==b) dyn[i][j]= palin(i+1,j-1);
			else{
				int t=palin(i+1,j);
				int m=palin(i,j-1);
				int min=(t<m)?t:m;
				dyn[i][j]= 1+min;
			}
		}
	}
	return dyn[i][j];
}
	
int main(){
	int N;
	cin>>N>>str;
	dyn=new int*[N];
	for(int i=0;i<N;i++)
		dyn[i]=new int[N];
	for(int j=0;j<N;j++)
		for(int k=0;k<N;k++)
			dyn[j][k]=-1;
	cout<<palin(0,N-1);
	for(int s=0;s<N;s++)
		delete[] dyn[s];
	delete[] dyn;
	return 0;
}
