#include <iostream>
#include <vector>

using namespace std;

void solve() {
  int n;
  cin >> n;
  if (n % 2 != 0) {
    cout << "NO";
  } else {
    if(n == 2) {
      cout << "NO";
    } else {
      cout << "YES";
    }
  }
}

int main()
{
  solve();
}