#include <iostream>
#include <vector>

// Input: [1,2,3]
// Output:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

using namespace std;

// vector<vector<int>> result;
void printPermutationRecursion(vector<int> nums, int start, vector<vector<int > >& result)
{ 
  if (start == nums.size() - 1)
  {
    result.push_back(nums);
  }
  else
  {
    for (int i = start; i <= nums.size() - 1; i++)
    {
      swap(nums[start], nums[i]);
      printPermutationRecursion(nums, start + 1, result);
      swap(nums[start], nums[i]);
    }
  }
}

int main()
{
  vector<int> nums;
  nums.push_back(1);
  nums.push_back(2);
  nums.push_back(3);
  nums.push_back(4);
  vector<bool> visit;
  visit.push_back(false);
  visit.push_back(false);
  visit.push_back(false);
  // printPermutation(nums, 0);
  vector<vector<int > > result;
  printPermutationRecursion(nums, 0, result);
  for(vector<int> r : result) {
    for(int a : r) {
      cout << a << " ";
    }
    cout<< endl;
  }
  return 0;
}