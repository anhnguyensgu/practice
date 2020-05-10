#include <iostream>
#include <vector>

using namespace std;

bool isPermutation(string s1, string s2)
{
  if (s1.length() > s2.length())
    return false;

  vector<int> count1(26);

  for (int i = 0; i < s1.length(); i++)
  {
    count1[s1[i] - 'a']++;
  }

  for (int i = 0; i <= s2.length() - s1.length(); i++) {
    vector<int> count2(26);
    for (int j = 0; j < s1.length(); j++)
    {
      count2[s2[j + i] - 'a']++;
    }

    bool isTheSame = true;  
    for (int j = 0; j < 26; j++)
    {
      if (count1[j] != count2[j])
      {
        isTheSame = false;
        break;
      }
    }

    if (isTheSame == true) {
      return isTheSame;
    }
  }
  return false;
}

int main()
{
  string str, str2;
  cin >> str >> str2;
  cout << isPermutation(str, str2) << endl;
}