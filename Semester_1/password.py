import re
"""def valid(s):
    if len(s)<6 or len(s) > 16 :
        return False
    if not re.search(r"[a-z]",s):
        return False
    if not re.search(r"[A-Z]",s):
        return False
    if not re.search(r"[0-9]",s):
        return False
    if not re.search(r"[@#$]",s):   
        return False
    if re.search(r"[^a-zA-Z0-9@#$]",s):
        return False
    return True
a=input("Enter password :")
if valid(a):
    print("Valid Password")
else:
    print("Invalid Password")
"""

def valid(s):
    pattern = r"^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$])[A-Za-z0-9@#$]{6,16}$"
    return re.match(pattern, s)

a = input("Enter password : ")

if valid(a):
    print("Valid Password")
else:
    print("Invalid Password")
