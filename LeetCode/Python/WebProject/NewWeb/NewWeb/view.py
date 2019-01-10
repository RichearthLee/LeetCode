from django.http import HttpResponse,HttpResponseRedirect
from django.template import RequestContext, loader
from django.shortcuts import render, redirect
 
# def hello(request):
#     return HttpResponse()

# def index(request):
#     t1 = loader.get_template('../Template/index.html')
#     context = RequestContext(request)
#     return HttpResponse(t1.render(context))

def index(request):
    return render(request,'login.html')

# def login(Request):
#     return render(request,'login.html')