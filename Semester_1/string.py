s=input("Enter a string (minimum length 7 and odd length ):")
if(len(s)<7 and len(s)%2==0):
    print("Invalid Input")
else:
    n=len(s)//2
    print(s[n-1:n+2])
