#!/usr/bin/python
import csv
import os

print("input the host predict file path:" )
file_path_predict = input()
print("input the host recall file path:" )
file_path_recall = input()

print("input the output path:")
csv_file = input()

try:
    f1 = open(file_path_predict , 'r')
    f2 = open (file_path_recall ,'r')
except :
    print("sourse file path error")

hosts_predict_dict=[]
with open(file_path_predict, 'r') as f:
  texts = f.readlines()
  for i in range(0, len(texts)):
    # "city"
    texts[i] = texts[i].strip('\n')
    hosts_predict_dict.append(texts[0].strip(),"predict")



hosts_recall_dict=[[]]
with open(file_path_predict, 'r') as f:
  texts = f.readlines()
  for i in range(0, len(texts)):
    # "host"
    texts[i] = texts[i].strip('\n')
    hosts_recall_dict.append([texts[0].strip(),"recall"])
 


#csv_data = hosts_predict_dict + hosts_recall_dict

#print(csv_data)

out1 = open(csv_file+"data1",'a', newline='')
out2 = open(csv_file+"data2",'a', newline='')

csv_write = csv.writer(out1,dialect='excel')

for rows in hosts_predict_dict:
    print(rows)
    csv_write.writerow(rows)
out1.close()

csv_write = csv.writer(out2,dialect='excel')

for rows in hosts_recall_dict:
    print(rows)
    csv_write.writerow(rows)

out2.close()


