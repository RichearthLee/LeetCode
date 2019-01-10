print("input the portal file path:" )
file_path_predict = input()
print("input the hosts file path:" )
file_path_recall = input()

print("input the output path:")
csv_file = input()

try:
    f1 = open(file_path_predict , 'r')
    f2 = open (file_path_recall ,'r')
except :
    print("source file path error")

hosts_predict_dict=[]
with open(file_path_predict, 'r') as f:
  texts = f.readlines()
  for i in range(0, len(texts)):
    # "city"
    texts[i] = texts[i].strip('\n')
    hosts_predict_dict.append(texts[0].strip()+" predict")



hosts_recall_dict=[]
with open(file_path_predict, 'r') as f:
  texts = f.readlines()
  for i in range(0, len(texts)):
    # "host"
    texts[i] = texts[i].strip('\n')
    hosts_recall_dict.append(texts[0].strip()+" recall")



#csv_data = hosts_predict_dict + hosts_recall_dict

#print(csv_data)

out1 = open(csv_file+"data1",'a')
out2 = open(csv_file+"data2",'a')

#csv_write = csv.writer(out1,dialect='excel')

for rows in hosts_predict_dict:
    print(rows)
    out1.write(rows+"\n")
out1.close()

#csv_write = csv.writer(out2,dialect='excel')

for rows in hosts_recall_dict:
    print(rows)
    out2.write(rows+"\n")
out2.close()




file_path_portal = csv_file+"data1"
file_path_host = csv_file+"data2"

#csv_file = 'host_infos.csv'
hosts_info_dict={}
with open(file_path_portal, 'r') as f:
  texts = f.readlines()
  for i in range(0, len(texts)):
    # "city", "data center", "operator", "ip", "sn" 
    segments = texts[i].strip('\n').split()
    hosts_info_dict[segments[3].strip()] = (segments[4], segments[0], segments[1], segments[2])
  f.close()
csv_data = []
with open(file_path_host, 'r') as f:
  ip_infos = f.readlines()
  for i in range(0, len(ip_infos)):
    segments = ip_infos[i].strip('\n').split()
    ip = segments[0].strip()
    group = segments[1].strip()
    host_info = hosts_info_dict.get(ip)
    print host_info
    if host_info:
      structed_data = []
      structed_data.append(host_info[0])
      # add inter net ip
      structed_data.append(ip)
      # add outer net ip
      structed_data.append('')
      # add cpu info
      structed_data.append('')
      # add memory info
      structed_data.append('')
      # add disk info
      structed_data.append('')

      structed_data.append(group)
      structed_data.append(host_info[2])
      structed_data.append(host_info[3])
      structed_data.append(host_info[1])
      csv_data.append(structed_data)
  f.close()
print len(csv_data)
with open(csv_file, 'w') as f:
  writer = csv.writer(f)
  writer.writerows(csv_data)
  f.close()