#include <bits/stdc++.h>
using namespace std;
class SortedStack {
public:
  stack<int> s;
  void sort();
};

void printStack(stack<int> s) {
  while (!s.empty()) {
    printf("%d ", s.top());
    s.pop();
  }
  printf("\n");
}

int main() {
  int t;
  cin >> t;
  while (t--) {
    SortedStack *ss = new SortedStack();
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
      int k;
      cin >> k;
      ss->s.push(k);
    }
    ss->sort();
    printStack(ss->s);

    cout << "~" << "\n";
  }
}

void sorted_push(int top, stack<int> &s) {
  if (s.empty() || top > s.top()) {
    s.push(top);
    return;
  }
  int newtop = s.top();
  s.pop();
  sorted_push(top, s);

  s.push(newtop);
}

void SortedStack ::sort() {
  if (s.empty())
    return;
  int top = s.top();
  s.pop();
  sort();
  sorted_push(top, s);
}