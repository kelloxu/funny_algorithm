from Solution188 import Solution188
from Solution714 import Solution714


def main():
    sol = Solution188()
    k, prices = 2, [2, 4, 1]
    print(sol.max_profit(k, prices))  # 2
    k, prices = 2, [3, 2, 6, 5, 0, 3]
    print(sol.max_profit(k, prices))  # 7

    sol1 = Solution714()
    prices, fee = [1, 3, 2, 8, 4, 9], 2
    print(sol1.max_profit(prices, fee))  # 8
    print(sol1.max_profit_optimize(prices, fee))  # 8


if __name__ == '__main__':
    main()
