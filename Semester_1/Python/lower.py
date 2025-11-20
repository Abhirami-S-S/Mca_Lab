import re
def arrange(s):
    l="".join([c for c in s if c.islower()])
    u="".join([c for c in s if c.isupper()])
    return l+u
def arrange1(s):
    l="".join(re.findall(r"[a-z]",s))
    u="".join(re.findall(r"[^a-z]",s))
    return l+u
a=input("Enter string :")
print("New String :",arrange(a))
print("New String1 :",arrange1(a))