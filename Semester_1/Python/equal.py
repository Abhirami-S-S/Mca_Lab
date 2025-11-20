def near_equal(s1,s2):
    if s1.lower()==s2.lower():
        return True
    if ((len(s1)==len(s2))):
        n=len(s1)
        m=0
        i=0
        while(i<n):
            if(s1[i]!=s2[i]):
                m+=1
            i+=1
        if(m>1):
            return False
        else:
            return True
        
a=input("enter a string:").lower()
b=input("enter a string:").lower()
if near_equal(a,b):
    print("Near Equal")
else:
    print("Not Equal")