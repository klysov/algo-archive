def factorial_recursive(number):
    if number == 1:
        return 1
    else:
        return number * factorial_recursive(number - 1)


def factorial(number):
    result = number
    current_element = number - 1
    while current_element != 1:
        result *= current_element
        current_element -= 1
    return result


print(factorial_recursive(5))
print(factorial(5))
