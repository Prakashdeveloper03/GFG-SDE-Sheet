#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
  int celebrity(vector<vector<int>> &mat) {
    int n = mat.size();
    int a = 0;
    int b = n - 1;
    while (a < b) {
      if (mat[a][b] == 1) {
        a++;
      } else {
        b--;
      }
    }
    int can = a;
    for (int i = 0; i < n; i++) {
      if (i != can) {
        if (mat[can][i] == 1 || mat[i][can] == 0) {
          return -1;
        }
      }
    }
    return can;
  }
};

int main() {
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    vector<vector<int>> M(n, vector<int>(n, 0));
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        cin >> M[i][j];
      }
    }
    Solution ob;
    cout << ob.celebrity(M) << endl;
    cout << "~" << endl;
  }
}