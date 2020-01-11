#include <iostream>
using namespace std;
int arr[3][8]={{6,7,12,-5,5,3,11,3},{-8,10,14,9,7,13,8,5},{11,12,7,4,8,-2,9,4}};
int dyn[10][4];
int getValue(int c,int d){
	if(d==1)
		return arr[0][c];
	else if(d==2)
		return arr[1][c];
	else if(d==3)
		return arr[2][c];
	else if(d==4)
		return (arr[0][c]+arr[2][c]);
}
bool isAble(int d,int i){
	if(d==1) return ((i==2)||(i==3));
	else if(d==2) return ((i==1)||(i==3)||(i==4));
	else if(d==3) return ((i==1)||(i==2));
	else if(d==4) return i==2;
}
int pebble(int c,int d){
	//printf("c:%d d:%d\n",c,d);
	if(dyn[c][d]!=-1) return dyn[c][d];
	else{
		if(c==0){
		dyn[0][d]=getValue(0,d);
		}
		else{
			int max=-999999;
			for(int i=1;i<=4;i++){
				if(isAble(d,i)){
					int tmp=pebble(c-1,i);
					if(max<tmp)
						max=tmp;
				}
			}
			//printf("max<%d>\n",max);
			dyn[c][d]= max+getValue(c,d);
		}
	}
	return dyn[c][d];
}
int main(){
	int max=-9999999;
	int idx=-1;
	
	for(int i=1;i<=4;i++){
		for(int k=0;k<10;k++)
			for(int a=0;a<4;a++)
			dyn[k][a]=-1;
		printf("direction:%d\n",i);
		int t=pebble(7,i);
		if(max<t){
			max=t;
			idx=i;
		}
	}
	cout<<"direction:"<<idx<<" "<<max;
	
	//cout<<pebble(7,2);
	return 0;
}
