from django.http import HttpResponse

from testapp.models import Test


# 数据库操作

def testdb(request):
    test1 = Test(name='runoob')
    test1.save()
    return HttpResponse("<p>数据添加成功！</p>")

# def testdb(request):
#     test1 = Login(username='runoob', password='123')
#     test1.save()
#     return HttpResponse("<p>数据添加成功！</p>")
