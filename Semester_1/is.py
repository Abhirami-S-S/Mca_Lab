a=input("Enter :").split(',')
result=[]
for c in a:
    if " " in c:
        result.append(True)
    else:
        result.append(False)
print(result)