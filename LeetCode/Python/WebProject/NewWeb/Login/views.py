from django.http import HttpResponse
# Create your views here.

from django.http import HttpResponse


# Create your views here.


# 数据库操作


def Signin(request):
    # if request.method == 'get':
    #     return render(request, 'login.html')

    username = "rty"
    password = "123"

    # user = auth.authenticate(request , username = username , password = password)

    do_login = Login(username=username, password=password)

    do_login.save()

    return HttpResponse("<p>数据添加成功！</p>")
