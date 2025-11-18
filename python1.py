a=int(input("Enter a number:"))
if (a==0) or (a==1):
    print("Factorial of",a,"is 1")
elif a<0:
    print("No Factorial for: ",a)
else:
    f=1
    for i in range(2,a+1):
        f*=i
    print("Factorial of ",a,"is ",f)
print(a if a==3 else a-1)