import time

from apscheduler.schedulers.blocking import BlockingScheduler


# def my_job():
#     while(True):
#         print (time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time())))
#         time.sleep(3)

def my_job():
    print (time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time())))


def func_1():
    print("11111111111111111111111")


def func_2():
    while (True):
        path = "E:/test/"
        # os.mkdir(path+"test.txt")
        with open(path + "test.txt", 'w') as file_test:
            file_test.writelines("123")


sched = BlockingScheduler()
# sched.add_job(my_job, 'interval', seconds=2,id='1')
# sched.add_job(func_1,'interval',seconds=2,id='2')
sched.add_job(func_2, 'interval', seconds=2, id='3')

# sched.pause_job('1')
# time.sleep(5)
# sched.resume_job('1')
# sched.remove_job('1')
print (sched.get_jobs())
sched.start()

print('end')
# sched.resume_job('1')

sched.shutdown(wait=False)
