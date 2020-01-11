#include<iostream>
#include<string>
#include<sstream>
#include<vector>
using namespace std;

int Answer;

int main(int argc, char** argv)
{
   int T, test_case;

   cin >> T;
   for(test_case = 0; test_case  < T; test_case++)
   {
        Answer = 0;
       string n;
       int num, number;
       vector<int>save;

       cin >> n;

       num = stoi(n);

    while(num != 0 && Answer < 4){
      Answer++;
      int k = n.length()-1;

      for(int i = 0; i < n.length()/2; i++){
          if(n[i] >= n[k]){
             n[i] = n[k];
         }
         else n[k] = n[i];
          k--;
      }


      number = stoi(n);
      save.push_back(number);
      num -= number;
      stringstream s;
      s << num;
      n = s.str();

      cout << save.front();
      }
      for(int j=0;j<save.size();j++){
      	cout<<save.at(j)<<" ";
      }
      cout<<endl;

      cout << "Case #" << test_case+1 << endl;
      if(Answer > 3) cout << Answer << endl;
      else {
         cout << Answer << " ";
         cout << endl;
      }

   }

   return 0;
}
