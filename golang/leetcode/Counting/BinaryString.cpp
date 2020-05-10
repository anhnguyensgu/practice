#include <iostream>

using namespace std;

void printBinaryString(int *A, int n)
{
  for (int j = 0; j < n; j++)
    cout << A[j] << " ";
  cout << endl;
}

bool nextString(int *A, int n)
{
  int i = n - 1;
  while (i >= 0 && A[i] == 1)
    i--;

  if (i >= 0)
  {
    A[i] = 1;
    for (int j = i + 1; j < n; j++)
      A[j] = 0;
    return true;
  }
  else
    return false;
}

int main()
{
  int n;
  cin >> n;
  int *A = new int[n];
  for (int i = 0; i < n; i++)
  {
    A[i] = 0;
  }

  do
  {
    printBinaryString(A, n);
  } while (nextString(A, n));
  return 0;
}