#include<iostream>
#include <string>
using namespace std;
string A="abcbdab";
string B="bdcaba";
int dyn[10][10];
int LCS(int i,int j){
	if(i==-1||j==-1) return 0;
	if(dyn[i][j]!=-1)
		return dyn[i][j];
	else{
		if(A[i]==B[j]){
			//printf("A[%d]=%c B[%d]=%c\n",i,A[i],j,B[j]);
			dyn[i][j]= LCS(i-1,j-1)+1;
		}
		else{
			//printf("A[%d-1]=%c B[%d]=%c\n",i,A[i-1],j,B[j]);
			int a=LCS(i-1,j);
			//printf("A[%d]=%c B[%d-1]=%c\n",i,A[i],j,B[j-1]);
			int b=LCS(i,j-1);
			dyn[i][j]= (a>b)?a:b;
		}
		return dyn[i][j];
	}
}
int main(){
	//cout<<A.length()<<"   "<<B.length()<<endl;
	for(int i=0;i<10;i++)
		for(int j=0;j<10;j++)
			dyn[i][j]=-1;
	cout<<LCS(A.length()-1,B.length()-1);
	return 0;
}
