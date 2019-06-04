from Login.models import Login
from django.http import HttpResponse
from django.shortcuts import render


# Create your views here.


def Signin_post(request):
    # if request.method == 'get':
    #     return render(request, 'login.html')
    username1 = request.POST.get('username')
    password1 = request.POST.get('password')
    # username1 = request.GET.get('username')
    # password1 = request.GET.get('password')

    # username1 = "qwe"
    # password1 = "123"
    # user = auth.authenticate(request , username = username , password = password)
    do_login = Login(username=username1, password=password1)
    do_login.save()
    return render(request, 'success.html')


def Signin_get(request):
    # if request.method == 'get':
    #     return render(request, 'login.html')
    username1 = request.GET.get('username')
    password1 = request.GET.get('password')
    print("--------------------" + username1)
    # username1 = "qwe"
    # password1 = "123"
    # user = auth.authenticate(request , username = username , password = password)
    do_login = Login(username=username1, password=password1)

    do_login.save()
    return HttpResponse("asd")


def Login_post(request):
    username1 = request.POST.get('username')
    password1 = request.POST.get('password')
    # user = auth.authenticate(request , username = username , password = password)
    print("+++++++++++++++++" + username1)
    print("+++++++++++++++++" + password1)
    do_login = Login.objects.filter(username=username1, password=password1)
    # do_login = Login.objects.filter(username = username1)
    for res in do_login:
        print("username:" + res.username)
        print("password:" + res.password)

    if do_login:
        return render(request, 'success.html')
    else:
        return render(request, 'failed.html')


def change_password(request):
    new_username = request.POST.get('username')
    new_password = request.POST.get('password')
    l = Login.objects.filter(username=new_username).first()
    l.password = new_password
    l.save()
    return render(request, 'success.html')
