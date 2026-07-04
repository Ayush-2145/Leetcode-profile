#include <algorithm>
class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& a) {
      int m=0;
      int c=0;
      for(int i=0;i<a.size();i++){
        if(a[i]==1){
            c++;
            m=max(m, c);
        } else{
            c=0;
        }
      } 
      return m; 
    }
};