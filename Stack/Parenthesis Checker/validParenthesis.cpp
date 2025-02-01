#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
  bool isBalanced(string &s) {
    stack<char> paren;
    bool flag = true;
    int n = s.length();
    paren.push(s[0]);
    for (int i = 1; i < n; ++i) {
      if (s[i] == ')' || s[i] == '}' || s[i] == ']') {
        if (paren.empty()) {
          flag = false;
          break;
        } else if ((s[i] == ')' && paren.top() != '(') ||
                   (s[i] == '}' && paren.top() != '{') ||
                   (s[i] == ']' && paren.top() != '[')) {
          flag = false;
          break;
        } else {
          paren.pop();
        }
      } else {
        paren.push(s[i]);
      }
    }
    return flag && paren.empty();
  }
};

int main() {
  int t;
  string a;
  cin >> t;
  while (t--) {
    cin >> a;
    Solution obj;
    if (obj.isBalanced(a))
      cout << "true" << endl;
    else
      cout << "false" << endl;

    cout << "~"
         << "\n";
  }
}