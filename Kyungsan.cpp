#include <iostream>
#include <vector>
using namespace std;
int N;
int K;
int* walkCost;
int* bicycleCost;
int* walkTime;
int* bicycleTime;
long dyn[101][100001];
long bike(int c,int t){
	int k=-1,a=-1,b=-1;
	if(c<0) return 0;
	if(dyn[c][t]!=-2) return dyn[c][t];
	else{
		if(t>=walkTime[c]){
			k=bike(c-1,t-walkTime[c]);
			if(k>=0)
				a=walkCost[c]+k;
		}
		if(t>=bicycleTime[c]){
			k=bike(c-1,t-bicycleTime[c]);
			if(k>=0)
				b=bicycleCost[c]+k;
		}
		k=(a>b)?a:b;
		dyn[c][t]= k;
	}
	return dyn[c][t];
}
int solution(int K,vector<vector<int> > travel){
	int N=travel.size();
	walkCost=new int[N];
	bicycleCost=new int[N];
	walkTime=new int[N];
	bicycleTime=new int[N];
	for(int s=0;s<101;s++)
		for(int t=0;t<100001;t++)
			dyn[s][t]=-2;
	for(int i=0;i<N;i++){
		walkTime[i]=travel.at(i).at(0);
		walkCost[i]=travel.at(i).at(1);
		bicycleTime[i]=travel.at(i).at(2);
		bicycleCost[i]=travel.at(i).at(3);
	}

	int a=bike(N-1,K);
	delete[] walkCost;
	delete[] bicycleCost;
	delete[] walkTime;
	delete[] bicycleTime;
	return a;
}
int main(){
	int k=1650;
	int tmp[3][4]={{500,200,200,100},{800,370,300,120},{700,250,300,90}};
	vector<vector<int> > vec;
	for(int i=0;i<3;i++){
		vector<int> tor;
		for(int j=0;j<4;j++){
			tor.push_back(tmp[i][j]);
		}
		vec.push_back(tor);
	}
	cout<<solution(k,vec);
	return 0;
}
