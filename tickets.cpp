#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<vector<string> > tickets) {
    vector<string> answer;
    return answer;
}
int main(){
	vector<vector<string> >tickets;
	string start,end;

	for(int i=0;i<3;i++){
		vector<string> tmp;
		cin>>start>>end;
		tmp.push_back(start);
		tmp.push_back(end);
		tickets.push_back(tmp);
	}
	solution(tickets);
	for(int j=0;j<3;j++){
		cout<<tickets.at(j).at(0)<<" "<<tickets.at(j).at(1)<<endl;
	}
	return 0;
}
		
		
