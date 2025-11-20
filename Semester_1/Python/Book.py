class Book:
    def __init__(self,author,title):
        self.author=author
        self.title=title
def display1(b):
    print(f"{b.title} written by {b.author} is published by",end=" ")
    if(hasattr(b,"publisher\n")):
        print(b.publisher)
    else:
        print("Unknown Publisher \n")
b1=Book("Paul Barry","Learning Python")
b1.publisher="O'Reilly"
b2=Book("Allen B","Think Python")
print("Details of book1")
display1(b1)
print("Details of book2")
display1(b2)
