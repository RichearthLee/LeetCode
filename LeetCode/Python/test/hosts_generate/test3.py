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
  for res in texts:
      hosts_predict_dict.append(res.strip()+" predict")




hosts_recall_dict=[]
with open(file_path_recall, 'r') as f:
  texts = f.readlines()
  for res in texts:
      hosts_recall_dict.append(res.strip()+" recall")


csv_data = hosts_predict_dict + hosts_recall_dict

print(csv_data)

out = open(csv_file,'a')

#csv_write = csv.writer(out,dialect='excel')

for rows in csv_data:
    print(rows)
    out.write(rows+"\n")
out.close()