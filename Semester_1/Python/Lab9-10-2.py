#5.	Write a program to remove all odd indexed characters from a given string.
"""
def remove(s):
    s1=''.join([s[i] for i in range(len(s)) if i%2!=0])
    return s1
s=input("Enter the string: ")
print(remove(s))
"""
#Write a program that count the number of strings where string length is 2 or more and the first and last characters are same.
"""
def count(s):
    c=0
    print("Strings with same first and last character: ",end="")
    for i in s:
        if len(i)>=2 and i[0]==i[-1]:
            c+=1
            print(i,end=" ")
    return c
l=input("Enter the text: ").split(',')
print("\nCount of strings with same first and last character: ",count(l))
"""
# Write a program that counts odd and even numbers in a given list.
"""
def count(list1):
    e,o=0,0
    for i in list1:
        e=e+1 if list1[i]%2==0 else e
        o=o+1 if list1[i]%2!=0 else o
    return e,o
list1=list(map(int,input("Enter the list elements separated by comma: ").split(',')))
print("Even count: ",count(list1)[0])
print("Odd count: ",count(list1)[1])
"""
#Write a function to get a new string from a given string by adding ‘Is’ to the beginning of the input string. If the given string already begins with ‘Is’, return the input string unchanged.
"""
def change(s1):
    if s1[:2] != 'is':
        s1='is'+s1
    return s1
    
s1=input("Enter the text: ")
s1=s1.lower()
print("Changed %s" %change(s1) if s1!=change(s1) else " %s Unchanged" %change(s1))
"""
"""
9.	Write lambda functions:
(a) To find largest of 2 numbers
(b)  To check the input number is divisible by 5
(c) To remove all strings with length < 5 from a list of strings
(d)  To increment a list of integers by 10% if the number is greater than 1000 else by 5%.
"""
l=lambda x,y: x if x>y else y
a=int(input("Enter first number: "))
b=int(input("Enter second number: "))
print("Greater number is: ",l(a,b))

d=lambda x: x if x%5==0 else 0
a=int(input("Enter a number: "))
print("%d is divisible by 5" %a if d(a) else "%d is not divisible by 5" %a)

l1=input("Enter the string(comma separator):").split(',')
l2=[i.lower() for i in l1]
l1=list(filter(lambda x: len(x)>5,l2))
print("New List:",l1)

l1=list(map(int,input("Enter the numbers(comma separator):").split(',')))
increase=lambda x: x+(x*.1) if x>1000 else x+(x*.05)
l2=list(map(increase,l1))
l2=list(map(int,l2))
print("New List:",l2)
