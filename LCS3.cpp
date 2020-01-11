#include <iostream>
using namespace std;
string str1;
string str2;
string str3;
int dyn[100][100][100];
int Findmax(int i,int j,int k){
 	int max=i;
 	if(max<j)
		max=j;
	if(max<k)
		max=k;
	return max;
}
int LCS(int i,int j,int k){
	if(i==-1||j==-1||k==-1)
		return 0;
	//printf("str1[%d]=%c str2[%d]=%c str3[%d]=%c\n",i,str1[i],j,str2[j],k,str3[k]);
	if(dyn[i][j][k]!=-1)
		return dyn[i][j][k];
	else{
		if(str1[i]==str2[j]&&str2[j]==str3[k])
			dyn[i][j][k]= 1+LCS(i-1,j-1,k-1);
		else{
			int a=LCS(i-1,j,k);
			int b=LCS(i,j-1,k);
			int c=LCS(i,j,k-1);
			int max=Findmax(a,b,c);
			dyn[i][j][k]=max;
		}
	}
	return dyn[i][j][k];
}

int main(){
	for(int i=0;i<100;i++)
		for(int j=0;j<100;j++)
			for(int k=0;k<100;k++)
				dyn[i][j][k]=-1;
	cin>>str1>>str2>>str3;
	cout<<LCS(str1.length()-1,str2.length()-1,str3.length()-1);
	return 0;
}
