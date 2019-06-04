f = 0
while (f < 1000):
    path = "E:/test/"
    # os.mkdir(path+"test.txt")
    with open(path + "test.txt", 'w') as file_test:
        file_test.writelines("123")
    f = f + 1

print('end')

path = "E:/test/"
# os.mkdir(path+"test.txt")
with open(path + "test1.txt", 'w') as file_test:
    for i in range(0, 1000):
        file_test.writelines("123")
