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


# def printnums(n):
#     while True:
#         print(n)
#         # time.sleep(1)
#
# from concurrent.futures import ThreadPoolExecutor
#
# t = ThreadPoolExecutor(max_workers=4)
# for i in range(2):
#     t.submit(printnums, (i))


# import re
# s = "www.123.com?nuW=1"
# index = re.search("www", s)
# index.span()
# print(index.span()[0])
# try:
#     print(s[0:index.span()[0]])
# except Exception as e:
#     print("error")

#生成一个字典
# d = {'name': 'Tom', 'age': 10, 'Tel': 110}
# # print(d['name'])
# # print('name' in d.keys())

# from redis import Redis
#
# conn = Redis(host="9.110.84.27", port="6379", password="dbadmin", db=0)
# res = conn.hget("ai.baidu.com", "title")
# print(res.decode(encoding="utf-8"))






