#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
  vector<int> nextLargerElement(vector<int> &arr) {
    int n = arr.size();
    stack<int> st;
    vector<int> ans(n);
    for (int i = n - 1; i >= 0; i--) {
      while (!st.empty() && st.top() <= arr[i]) {
        st.pop();
      }

      ans[i] = (st.empty() ? -1 : st.top());

      st.push(arr[i]);
    }

    return ans;
  }
};

int main() {
  int t;
  cin >> t;
  cin.ignore();
  while (t--) {
    vector<int> a;
    string input;
    getline(cin, input);
    stringstream ss(input);
    int num;
    while (ss >> num)
      a.push_back(num);
    Solution obj;
    vector<int> result = obj.nextLargerElement(a);
    for (int i = 0; i < result.size(); i++) {
      if (i != 0)
        cout << " ";
      cout << result[i];
    }
    cout << endl;
    cout << "~" << endl;
  }
  return 0;
}