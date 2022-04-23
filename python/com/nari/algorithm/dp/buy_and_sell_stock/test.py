from _188_best_time_to_buy_and_sell_stock_iv import Solution


def main():
    sol = Solution()
    k, prices = 2, [2, 4, 1]
    print(sol.max_profit(k, prices))
    k, prices = 2, [3, 2, 6, 5, 0, 3]
    print(sol.max_profit(k, prices))


if __name__ == '__main__':
    main()
