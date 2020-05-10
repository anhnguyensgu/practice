#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void rotateWithReverseAlgorithm(vector<int> &nums, int k)
{
  k = k % nums.size();
  reverse(nums.begin(), nums.end());
  reverse(nums.begin(), nums.begin() + k);
  reverse(nums.begin() + k, nums.end());
}

void rotateArrayWith(vector<int> &nums, int k) {
  k = k % nums.size();
  int size = nums.size() - 1;
  int start = 0;
  int count = 0;
  while(count < nums.size()) {
    int current = start;
    int prev = nums[current];
    do {
      int next = (current + k) % nums.size();
      int temp = nums[next];
      nums[next] = prev;
      prev = temp;
      current = next;
      count++;
    } while(start != current);
    start++;
  }
}

int main()
{
  vector<int> nums;
  for (int i = 1; i <= 7; ++i)
    nums.push_back(i);

  rotateArrayWith(nums, 3);

  for(int n : nums)
    cout<< n << endl;
  return 0;
}