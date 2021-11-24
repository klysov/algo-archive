def binary_search(input_list, target):
    low = 0
    high = len(input_list) - 1
    while low <= high:
        current_position = (high + low) // 2
        guess = input_list[current_position]
        if guess == target:
            return current_position
        elif guess > target:
            high = current_position - 1
        else:
            low = current_position + 1
    return None


def binary_search_recursive(input_list, target, start, end):
    if start > end:
        return None
    middle = (start + end) // 2
    if input_list[middle] == target:
        return middle
    elif input_list[middle] > target:
        return binary_search_recursive(input_list, target, start, middle - 1)
    elif input_list[middle] < target:
        return binary_search_recursive(input_list, target, middle + 1, end)


input_lst = sorted([3, 2, 1, 6, 7, 9])
print(input_lst)

print(binary_search(input_lst, 1))
print(binary_search(input_lst, 0))
print(binary_search(input_lst, 7))

print()

print(binary_search_recursive(input_lst, 7, 0, len(input_lst)))
print(binary_search_recursive(input_lst, 1, 0, len(input_lst)))
print(binary_search_recursive(input_lst, 0, 0, len(input_lst)))
