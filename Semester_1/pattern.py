
num=int(input("Enter the limit :"))
for i in range(1,num+1):
    print("",end=" "*(2*(num-i)))
    for j in range(1,i+1):
        print(" * ",end=" ")
    print("\n")
"""
n=int(input("Enter a number:"))
for i in range(1,n+1):
    if n%i==0:
        print(i,end=" ")
print()
li=[i for i in range(1,n+1) if (n%i==0)]
print(li)
"""