## https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/?envType=problem-list-v2&envId=dsa-linear-shoal-monotonic-stack


class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        stack = []

        for i, price in enumerate(prices):
            if len(stack) is 0 or price > prices[stack[-1]]:
                stack.append(i)
            
            else:
                while len(stack) is not 0 and price <= prices[stack[-1]]:
                    prices[stack[-1]] = prices[stack[-1]] - price
                    stack.pop()
                
                stack.append(i)
        
        while len(stack) is not 0:
            prices[stack[-1]] = prices[stack[-1]]
            stack.pop()

        return prices