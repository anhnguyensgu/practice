#include <iostream>
#include <vector>

using namespace std;

void solve() {
  int n;
  cin >> n;
  vector<int> a;
  int number;
  for(int i = 0; i < n; i++) {
    cin >> number;
    a.push_back(number);
  }

  int maxVal = -1000007;
  int remain = -1000007;
  for(int i = 1; i < n;) {
    if(a[i] < a[i - 1]) {
      int current = i - 1;
      int j = i;
      while(j < n && a[j] < a[current]){
        // cout<< j << endl;
        remain = max(remain, a[current] - a[j]);
        j++;
      }
      i = j;
    } else i++;
  }
  // int remain = maxVal - minVal;
  int result = 0;
  while(remain > 0) {
    remain = remain >> 1;
    result++;
  }
  cout << result << endl;
}

int main()
{
  int testCase;
  cin >> testCase;
  // cout<< "testCase " << testCase << endl;
  
  while(testCase > 0) {
    solve();
    testCase--;
  }
  return 0;
}