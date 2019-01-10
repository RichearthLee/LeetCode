g_test_1 = 1
g_test_2 = 2

tg = globals()

# if tg.has_key('g_test_2'):
#     tg['g_test_2'] = 3
tg['g_test_2'] = 3

print (g_test_1)
print(g_test_2)