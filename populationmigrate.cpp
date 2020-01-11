#include <iostream>
#include <cmath>
#include <vector>
using namespace std;

int N,L,R;
int** arr;
int** visited;
vector<int> store;
bool checkBorder(int a,int b,int c,int d){
	int t=abs(arr[a][b]-arr[c][d]);
	return (t>=L)&&(t<=R);
}
int sum=0;
bool flag=true;
int num=1;
int movable(int r,int c){
	int t=0,m=0,p=0,u=0;
	bool f=false,l=false,a=false,g=false;
	if(r<0||c<0||r>=N||c>=N) return 0;
	else{
		sum+=arr[r][c];
		visited[r][c]=num;
		if(r-1>=0&&checkBorder(r,c,r-1,c)&&visited[r-1][c]==0){
			t=movable(r-1,c);
			f=true;
		}
		if(c-1>=0&&checkBorder(r,c,r,c-1)&&visited[r][c-1]==0){
			m=movable(r,c-1);
			l=true;
		}
		if(r+1<N&&checkBorder(r,c,r+1,c)&&visited[r+1][c]==0){
			p=movable(r+1,c);
			a=true;
		}
		if(c+1<N&&checkBorder(r,c,r,c+1)&&visited[r][c+1]==0){
			u=movable(r,c+1);
			g=true;
		}
		flag=(f||l||a||g);
		return 1+t+m+p+u;
	}
			
}
void change(int n){
	for(int i=0;i<N;i++)
		for(int j=0;j<N;j++)
			if(visited[i][j]==num)
				arr[i][j]=n;
}
bool color(){
	sum=0;
	int r;
	bool t=false,p=false;
	for(int a=0;a<N;a++)
		for(int b=0;b<N;b++)
			visited[a][b]=0;
	for(int i=0;i<N;i++){
		for(int j=0;j<N;j++){
			if(visited[i][j]==0){
				r=movable(i,j);
				t=p||flag;
				p=t;
				if(r>1){
					int m=sum/r;
					change(m);
				}
				sum=0;
				num++;
			}
		}
	}
	num=1;
	return t;
}
int main(){
	cin>>N>>L>>R;
	arr=new int*[N];
	visited=new int*[N];
	for(int i=0;i<N;i++){
		arr[i]=new int[N];
		visited[i]=new int[N];
	}
	for(int j=0;j<N;j++){
		for(int k=0;k<N;k++){
			cin>>arr[j][k];
			visited[j][k]=0;
		}
	}
	int cnt=0;
	bool t=true;
	while(t!=false){
		t=color();
		if(t==false) break;
		cnt++;
	}
	cout<<cnt;
	for(int s=0;s<N;s++){
		delete[] arr[s];
		delete[] visited[s];
	}
	delete[] arr;
	delete[] visited;
	return 0;
}
