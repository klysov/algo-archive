def selection_sort(arr):
    for i in range(len(arr)):
        smallest = i
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[smallest]:
                smallest = j
        temp = arr[i]
        arr[i] = arr[smallest]
        arr[smallest] = temp


array = [5, 3, 6, 2, 10]
selection_sort(array)
print(array)
