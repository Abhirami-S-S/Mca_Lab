def fib_sum(n):
    a,b=0,1
    s=0
    print("Fibonacci Series\n",a,b,end=" ")
    for i in range(2,n):
        c=a+b
        print(c,end=" ")
        if(c%2==0):
            s+=c
        a=b
        b=c
    return s
n=int(input("Enter the limit: "))
print("\nSum of even terms :",fib_sum(n))