def sum_recursive(input_list):
    if len(input_list) == 0:
        return 0
    elif len(input_list) == 1:
        return input_list[0]
    else:
        return input_list[0] + sum_recursive(input_list[1:])


print(sum_recursive([1, 2, 3, 4, 5]))
