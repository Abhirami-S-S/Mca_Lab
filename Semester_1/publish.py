"""Create a class Publisher.Derive a class book(title,author) from publisher.
derive a class python(price,no_of_pages) from book.
WAP that display informations about a python
"""
"""
class Publisher:
    def __init__(self,name=None):
        self.name=name
    def getname(self,name):
        self.name=name
    def display(self):
        print("Name of Publisher : ",self.name)

class Book(Publisher):
    def __init__(self,title=None,author=None):
        self.title=title
        self.author=author
    def getBook(self,title,author,P_name):
        self.title=title
        self.author=author
        super().getname(P_name)
    def display(self):
        print("Name of Book     : ",self.title)
        print("Name of Author   : ",self.author)
        super().display()

class Python(Book):
    def __init__(self,price=0.0,no_of_pages=0):
        self.price=price
        self.no_of_pages=no_of_pages
    def getpython(self,price,no_of_pages):
        self.price=price
        self.no_of_pages=no_of_pages
    def display(self):
        super().display()
        print("Price of Book    : ",self.price)
        print("No of Pages      : ",self.no_of_pages)
        
#main
p1=Python()
t=input("Enter the Title of Book    : ")
a=input("Enter the Name of Author   : ")
b=input("Enter the Publisher        : ")
p1.getBook(t,a,b)
a=input("Enter the Price :")
b=input("Enter the number of pages  : ")
p1.getpython(a,b)
print("Book Details\n-------------------\n")
p1.display()
"""
class Publisher:
    def __init__(self, name="O'Reilly"):
        self.name = name

    def display(self):
        print("Publisher :", self.name)

class Book(Publisher):
    def __init__(self, title="Learning Python", author="Paul Barry"):
        super().__init__()
        self.title = title
        self.author = author

    def display(self):
        print("Book Title:", self.title)
        print("Author    :", self.author)
        super().display()

class Python(Book):
    def __init__(self,price=2000.0, pages=992):
        super().__init__()
        self.price = price
        self.pages = pages

    def display(self):
        super().display()
        print("Price     :", self.price)
        print("Pages     :", self.pages)

# main
p1 = Python()
print("Book Details\n-------------------")
p1.display()
