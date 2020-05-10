#include <iostream>

using namespace std;

void print(int *A, int n)
{
  for (int i = 0; i < n; i++)
  {
    cout << A[i] << " ";
  }
  cout << endl;
}

bool nextCombination(int *A, int n, int k)
{
  int i = k - 1;

  while (i >= 0 && A[i] == n - k + i + 1)
    i--;

  if (i >= 0)
  {
    A[i]++;

    for (int j = i + 1; j <= k; j++)
      A[j] = A[j - 1] + 1;

    return true;
  }
  else
  {
    return false;
  }
}

int main()
{
  int n, k;
  cin >> n >> k;

  int *A = new int[k];
  for (int i = 0; i < k; i++)
    A[i] = i + 1;

  do
  {
    print(A, k);
  } while (nextCombination(A, n, k));

  return 0;
}