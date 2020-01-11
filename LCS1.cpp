#include <iostream>
#include <string>
using namespace std;

string s1;
string s2;
string ans="";
int dyn[1000][1000];
int preI[1000][1000];
int preJ[1000][1000];
int LCS(int i,int j){
	if(i==-1||j==-1) return 0;
	
	if(dyn[i][j]!=-1){
		return dyn[i][j];
	}
	else{
		if(s1[i]==s2[j]){
			ans.append(1,s1[i]);
			dyn[i][j]= LCS(i-1,j-1)+1;
		}
		else{
			int a=LCS(i-1,j);
			int b=LCS(i,j-1);
			int max=(a>b)?a:b;
			dyn[i][j]=max;
		}
	}
	return dyn[i][j];
}
void reverse(string& s){
	int end=s.length()-1;
	for(int i=0;i<=((0+end)/2);i++){
		char t=s[i];
		s[i]=s[end-i];
		s[end-i]=t;
	}
}
int main(){
	for(int i=0;i<1000;i++)
		for(int j=0;j<1000;j++)
			dyn[i][j]=-1;
	cin>>s1>>s2;
	cout<<LCS(s1.length()-1,s2.length()-1)<<endl;
	for(int a=0;a<6;a++){
		for(int b=0;b<6;b++)
			printf("%3d ",dyn[a][b]);
		cout<<endl;
	}
	cout<<ans;
	return 0;
}
