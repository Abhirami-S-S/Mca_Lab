import math as m
try:
    n=int(input("Enter the number to check : "))
    if n<0:
        raise ValueError("Negative Number")
    if(m.log2(n).is_integer()):
        print(n,"is power of 2.")
except ValueError as ve:
        print("Error:",ve)
