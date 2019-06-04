import os
import time
from datetime import datetime

from apscheduler.schedulers.background import BackgroundScheduler


def tick():
    print('Tick! The time is: %s' % datetime.now())


def func_1():
    print("1111111111111111")


if __name__ == '__main__':
    scheduler = BackgroundScheduler(job_defaults={'coalesce': False, 'max_instances': 2})
    scheduler.add_job(tick, 'interval', seconds=3)

    scheduler.start()
    print('Press Ctrl+{0} to exit'.format('Break' if os.name == 'nt' else 'C'))

    scheduler.add_job(func_1, 'interval', seconds=3)
    try:
        # This is here to simulate application activity (which keeps the main thread alive).
        while True:
            time.sleep(2)
    except (KeyboardInterrupt, SystemExit):
        # Not strictly necessary if daemonic mode is enabled but should be done if possible
        scheduler.shutdown()
