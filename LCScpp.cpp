#include<iostream>
#include <string>
using namespace std;
string A;
string B;
int LCS(int i,int j){
	//printf("A[%d]=%c B[%d]=%c\n",i,A[i],j,B[j]);
	if(i==-1||j==-1) return 0;
	else if(A[i]==B[j]){
		int k= LCS(i-1,j-1)+1;
		//cout<<k<<endl;
		return k;
	}
	else{
		//printf("A[%d-1]=%c B[%d]=%c\n",i,A[i-1],j,B[j]);
		int a=LCS(i-1,j);
		//printf("A[%d]=%c B[%d-1]=%c\n",i,A[i],j,B[j-1]);
		int b=LCS(i,j-1);
		int max= (a>b)?a:b;
		//printf("A[%d]=%c B[%d]=%c max=%d\n",i,A[i],j,B[j],max);
		return max;
	}
}
int main(){

	cin>>A>>B;
	cout<<A.length()<<"   "<<B.length()<<endl;
	cout<<LCS(A.length()-1,B.length()-1);
	return 0;
}
