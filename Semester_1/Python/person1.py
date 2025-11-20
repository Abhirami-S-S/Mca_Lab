class Person:
    def __init__(self,name,roll):
        self.name=name
        self.roll=roll
    def display(self):
        print(f"Name           :{self.name}\nRoll No        :{self.roll}")
#
class Marks:
    def __init__(self,maths,computer):
        self.computer=computer
        self.maths=maths
    def display(self):
        print(f"Computer Marks :{self.computer}\nMaths Marks    :{self.maths}")

class Student(Person,Marks):
    def __init__(self,name="",roll=0,maths=0,computer=0):
        super().__init__(name, roll)
        Marks.__init__(self, maths, computer)
        self.percent=((self.maths+self.computer)/200)*100
    def display(self):
        print("Student Details")
        super().display()
        Marks.display(self)
        print("Percentage     :",self.percent)
        print("Pass/Fail      :",end="")
        print("Pass" if self.percent>50 else "Fail")
    def compare(self,other):
        if self.percent>other.percent:
            print(f"{self.name} has scored more percentage than {other.name}")
        elif self.percent<other.percent:
            print(f"{other.name} has scored more percentage than {self.name}")
        else:
            print(f"Both {self.name} and {other.name} have scored equal percentage")
#example usage
S1=Student("Anu",101,85,90)
S1.display()

S2=Student("Cinu",102,75,80)
S2.display()
S1.compare(S2)      
