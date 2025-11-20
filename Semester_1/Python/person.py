"""Create a class Person(name,age)with a constuctor and a method display.
Create a class Employee(Empid) from person"""
class Person:
    def __init__(self,name='Anu',age=25):
        self.name=name
        self.age=age
    def display(self):
        print("Name     : ",self.name)
        print("Age      : ",self.age)
        
class Employee(Person):
    def __init__(self,id=101):
        super().__init__()
        self.Empid=id
    def display(self):
        super().display()
        print("Employee ID  : ",self.Empid)

class Faculty(Employee):
    def __init__(self,dept="Computer Application"):
        super().__init__()
        self.dept=dept
    def display(self):
        super().display()
        print("Department   : ",self.dept)

class Researcher:
    @staticmethod
    def can_do_research():
        return "person can do research"

class Professor(Faculty,Researcher):
    def __init__(self):
        super().__init__()
        
        
p1=Professor()
p1.display()
print(p1.can_do_research())

