from django.shortcuts import render
from django.http import HttpResponse
from django.contrib import auth
# Create your views here.

from Login.models import Login

#数据库操作


def Signin(request):
    # if request.method == 'get':
    #     return render(request, 'login.html')
    
    username = "rty"
    password = "123"

    #user = auth.authenticate(request , username = username , password = password)

    do_login = Login(username = username , password = password)

    do_login.save()

    
    return HttpResponse("<p>数据添加成功！</p>")