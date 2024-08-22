# Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
# Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.
#User function Template for python3

from typing import List
from collections import defaultdict
class Solution:
    def findOrder(self, alien_dict: List[str], N: int, K: int) -> str:
        # Your implementation here
        adj=defaultdict(set)
        ind=defaultdict(int)
        char=set()
        for ix,ve in enumerate(alien_dict):
            if ix+1==N:
                continue
            cur=list(ve)
            nxt=list(alien_dict[ix+1])
            char.update(cur+nxt)
            for a,b in zip(cur,nxt):
                if a==b:
                    continue
                if b not in adj[a]:
                    ind[b]+=1
                    adj[a].add(b)
                break
        q=[]
        for c in char:
            if ind[c]==0:
                q.append(c)
        ret=[]
        while q:
            cur=q.pop()
            ret.append(cur)
            for nxt in adj[cur]:
                ind[nxt]-=1
                if ind[nxt]==0:
                    q.append(nxt)
        return ret




#{ 
 # Driver Code Starts
#Initial Template for Python 3


class sort_by_order:

    def __init__(self, s):
        self.priority = {}
        for i in range(len(s)):
            self.priority[s[i]] = i

    def transform(self, word):
        new_word = ''
        for c in word:
            new_word += chr(ord('a') + self.priority[c])
        return new_word

    def sort_this_list(self, lst):
        lst.sort(key=self.transform)


if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        line = input().strip().split()
        n = int(line[0])
        k = int(line[1])

        alien_dict = [x for x in input().strip().split()]
        duplicate_dict = alien_dict.copy()
        ob = Solution()
        order = ob.findOrder(alien_dict, n, k)
        s = ""
        for i in range(k):
            s += chr(97 + i)
        l = list(order)
        l.sort()
        l = "".join(l)
        if s != l:
            print(0)
        else:
            x = sort_by_order(order)
            x.sort_this_list(duplicate_dict)

            if duplicate_dict == alien_dict:
                print(1)
            else:
                print(0)

# } Driver Code Ends