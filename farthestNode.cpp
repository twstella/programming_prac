#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int solution(int n,vector<vector<int> >edge){
	int answer=0;
	vector<int> adj[n];
	int dist[n];
	int visited[n];
	for(int i=0;i<edge.size();i++){
		int u=edge.at(i).at(0)-1;
		int v=edge.at(i).at(1)-1;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	for(int j=0;j<n;j++){
		dist[j]=99999;
		visited[j]=0;
	}
	dist[0]=0;
	int max=0;
	for(int a=0;a<n;a++){
		int e,m=99999,mInd=-1;
		for(int b=0;b<n;b++){
			if(m>dist[b]&&visited[b]==0){
				m=dist[b];
				mInd=b;
			}
		}
		e=mInd;
		visited[e]=1;
		for(int c=0;c<adj[e].size();c++){
			int t=adj[e].at(c);
			if(visited[t]==0&&dist[t]>dist[e]+1){
				dist[t]=dist[e]+1;
				max=dist[e]+1;
			}
		}
	}
	int cnt=count(dist,dist+n,max);
	answer=cnt;
	return answer;
}
int main(){
	vector<vector<int> > tmp;
	int a,b;
	int n;
	cin>>n;
	for(int i=0;i<7;i++){
		cin>>a>>b;
		vector<int> t;
		t.push_back(a);
		t.push_back(b);
		tmp.push_back(t);
	}
	cout<<solution(n,tmp);
	return 0;
}
