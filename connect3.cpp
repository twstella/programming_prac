#include <iostream>
#include <set>
#include <string>
#include <sstream>

using namespace std;

int arr[4][4];
int fr,fc;
set<string> myset;
bool checkEnd(int r,int c,int color){
	if ((c-2 >=0) &&
				(arr[r][c-1]== color) && (arr[r][c-2]== color))
				return true;
	if ((c-1 >=0) && (c+1 <4) &&
				(arr[r][c-1]== color) && (arr[r][c+1]== color))
				return true;
	if ((c+2 < 4) &&
				(arr[r][c+1]== color) && (arr[r][c+2]== color))
				return true;

	if ((r-2 >=0) &&
		(arr[r-2][c]== color) && (arr[r-1][c]== color))
				return true;
	if ((r-1 >=0) && (r+1 <4) &&
				(arr[r-1][c]== color) && (arr[r+1][c]== color))
				return true;
	if ((r+2 < 4) &&
				(arr[r+1][c]== color) && (arr[r+2][c]== color))
				return true;
	if ((r-2 >=0) && (c-2 >=0) &&
			(arr[r-2][c-2]== color) && (arr[r-1][c-1]== color))
				return true;
	if ((r-1 >=0) && (c-1 >=0) && (r+1 <4) && (c+1 <4) &&
			(arr[r-1][c-1]== color) && (arr[r+1][c+1]== color))
				return true;
	if ((r+2 <4) && (c+2 <4) &&
			(arr[r+2][c+2]== color) && (arr[r+1][c+1]== color))
				return true;
   	if ((r-2 >=0) && (c+2 <4) &&
			(arr[r-2][c+2]== color) && (arr[r-1][c+1]== color))
				return true;
	if ((r-1 >=0) && (c+1 <4) && (r+1 <4) && (c-1 >=0) &&
				(arr[r-1][c+1]== color) && (arr[r+1][c-1]== color))
					return true;
	if ((r+2 <4) && (c-2 >=0) &&
				(arr[r+2][c-2]== color) && (arr[r+1][c-1]== color))
					return true;

	return false;
}
			
int getRow(int i){
	for(int j=0;j<4;j++){
		if(arr[j][i]==-1) return j;
	}
	return -1;
}
int cnt=0;
string toString(){
	string str="";
	for(int i=0;i<4;i++)
		for(int j=0;j<4;j++){
			stringstream tmp;
			tmp<<arr[i][j];
			str+=tmp.str();
		}
			
	return str;
}
void place(int turn){
	int t,i;
	string str;
	for(int i=0;i<4;i++){
		t=getRow(i);
		if(t!=-1){
			if(checkEnd(t,i,turn+1)){
				if(t==fr&&i==fc&&turn==1){
					str=toString();
					if(myset.count(str)==0){
						myset.insert(str);
						cnt++;
					}
				}
			}
			else{
				arr[t][i]=turn+1;
				place((turn+1)%2);
				arr[t][i]=-1;
			}
		}
	}
}
int main(){
	int x;
	for(int i=0;i<4;i++)
		for(int j=0;j<4;j++)
			arr[i][j]=-1;
	cin>>x>>fr>>fc;
	fr--;
	fc--;
	arr[0][x-1]=1;
	cnt=0;
	place(1);
	cout<<cnt;
	return 0;
}
