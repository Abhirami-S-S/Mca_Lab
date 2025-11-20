#10.	Write lambda functions, each to find area of square, rectangle and triangle. 
square_a=lambda x:x*x
a=int(input("Enter the side of the square:"))
print("Area of square:",square_a(a))
rect_a=lambda a,b:a*b

l=int(input("Enter the length of the rectangle:"))
b=int(input("Enter the breadth of the rectangle:"))
print("Area of rectangle:",rect_a(l,b))

tri_a=lambda b,h:(1/2)*b*h
base=int(input("Enter the base of the triangle:"))
height=int(input("Enter the height of the triangle:"))
print("Area of triangle:",tri_a(base,height))


