#fib
"""
n=int(input("Enter a number:"))
a,b=0,1
print(a,end=" ")
print(b,end=" ")
for i in range(2,n):
    a,b=b,a+b
    print(b,end=" ")
print("\n%d th term is %d"%(n,b))

#list
l1=list(map(int,input("Enter the number(comma separator):").split(",")))
sum=0
for i in l1:
    sum+=i
print("Sum = ",sum)

#odd or even
a=int(input("Number :"))
print(a,"is","Even " if a%2==0 else "Odd")
"""
l1=input("Enter the text: ").split()
for i in l1:
    i.lower()
count=sum(1 for i in l1 if i.startswith('a')) 
print(count)