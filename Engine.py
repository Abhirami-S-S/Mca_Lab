"""Create a class Engine(_power) and Wheel(_size).
Derive a class Car(_model) from Engine and Wheel.
WAP that display informations about a Car using method overriding.
"""
class Engine:
    def __init__(self,power=100):
        self._power=power
    def display(self):
        print("Engine Power  : ",self._power,"HP")
class Wheel:
    def __init__(self,size=15):
        self._size=size
    def display(self):
        print("Wheel Size    : ",self._size,"inches")
class Car(Engine,Wheel):
    def __init__(self,model="Sedan"):
        self._model=model
        Engine.__init__(self)
        Wheel.__init__(self)
    def display(self):
        print("Car Model     : ",self._model)
        Engine.display(self)
        Wheel.display(self)
        
#main
c1=Car()
print("\nCar Details\n-------------------\n")
c1.display()    