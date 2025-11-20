def list_join(l,index=0):
    if(index>=(len(l))):
        return ""
    else:
        if index==(len(l)-1):
            return str(l[index])
        return str(l[index])+"-"+list_join(l,index+1)
l1=["a","b","c"]
print(list_join(l1))