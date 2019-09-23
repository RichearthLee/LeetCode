def addone(n: int):
    return n+1

# arr = [1, 2, 3, 4]
# for i in arr:
#     i = addone(i)
# print(arr)
#
# for i in range(len(arr)):
#     arr[i] = addone(arr[i])
# print(arr)

# arr = list()
# arr.append("123")
# arr.append("234")
# arr.append("123")
# print(arr)
# arr = set(arr)
# print(arr)
# arr = list(arr)
# print(arr)
import time


def printnums(n):
    while True:
        print(n)
        # time.sleep(1)

from concurrent.futures import ThreadPoolExecutor

t = ThreadPoolExecutor(max_workers=4)
for i in range(2):
    t.submit(printnums, (i))






