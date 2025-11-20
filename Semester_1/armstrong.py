import math as m
def armstrong(n):
    r=0
    n1=n
    while(n!=0):
        d=n%10
        r=r+(d**3)
        n=n//10
    if(r==n1):
        return True
    else:
        return False
print("Armstrong number (100-500)")
for i in range(100,500):
    if(armstrong(i)):
        print(i,end=" ")
print()