#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

void solve()
{
  int d, sumTime;
  cin >> d >> sumTime;

  int *result = new int[d];
  int *minTime = new int[d];
  int *maxTime = new int[d];

  int remain = sumTime;
  int left = d;
  int ave = sumTime / d;

  int minSum = 0;
  int maxSum = 0;

  int i = 0;
  while (left-- > 0)
  {
    cin >> minTime[i] >> maxTime[i];
    maxSum += maxTime[i];
    minSum += minTime[i];
    i++;
  }

  if (minSum <= sumTime && sumTime <= maxSum)
  {
    cout << "YES" << endl;
    for (int i = 0; i < d; i++) {
      int time = min(sumTime - minSum + minTime[i], maxTime[i]);
      sumTime -= (time - minTime[i]);
      cout << time << " ";
    }
  }
  else
  {
    cout << "NO" << endl;
  }
}

int main()
{
  solve();
}