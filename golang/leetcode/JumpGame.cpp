#include <iostream>
#include <vector>

using namespace std;

int jump(vector<int> &nums)
{
  int result = 0;
  int maxJump = 0;
  int furtheristJump = 0;
  for(int i = 0; i < nums.size() - 1; i++) {
    furtheristJump = max(furtheristJump, i + nums[i]);
    if (i == maxJump) {
      result++;
      maxJump = furtheristJump;
    }
  }
  return result;
}

int main()
{
  return 0;
}