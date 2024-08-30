# The n-queens puzzle is the problem of placing n queens on a (n×n) chessboard such that no two queens can attack each other.
# Given an integer n, find all distinct solutions to the n-queens puzzle. Each solution contains distinct board configurations of the n-queens placement, where the solutions are a permutation of [1,2,3..n] in increasing order, here the number in the ith place denotes that the ith-column queen is placed in the row with that number. For eg below figure represents a chessboard [3 1 4 2].
#User function Template for python3

class Solution:
    
    def nQueenChecker(self,i,j,n,board):
        
        for c in range(j-1,-1,-1): 
            if board[i][c] == 'Q': return False
            
        for r in range(i-1,-1,-1):
            if board[r][j] == 'Q': return False
            
        r,c = i-1,j-1
        
        while r >= 0 and c >= 0:
            
            if board[r][c] == 'Q': return False
            
            r,c = r - 1,c - 1
            
        r,c = i-1,j+1
        
        while r >= 0 and c < n:
            
            if board[r][c] == 'Q': return False
            
            r,c = r-1,c+1
            
        return True
        
    
    
    def solver(self,r,c,n,board,arr=None,result=None):
        
        if arr is None: arr = []
        if result is None: result = []
        
        if r == n: 
            result.append(arr[:])
            return 
        
        for j in range(n):
            if self.nQueenChecker(r,j,n,board):
                board[r][j] = 'Q'
                arr.append(j+1)
                self.solver(r+1,j,n,board,arr,result)
                board[r][j] = '.'
                arr.pop()
                
    
            
        return result
                
    
    def nQueen(self, n):
        
        board = [['.']*n for _ in range(n)]
        return self.solver(0,0,n,board)
        # code here


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n = int(input())
        
        ob = Solution()
        ans = ob.nQueen(n)
        if(len(ans) == 0):
            print("-1")
        else:
            for i in range(len(ans)):
                print("[",end="")
                for j in range(len(ans[i])):
                    print(ans[i][j],end = " ")
                print("]",end = " ")
            print()
                
# } Driver Code Ends