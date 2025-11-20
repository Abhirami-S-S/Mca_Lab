class Rect:
    def __init__(self,length,breadth):
        self.length=length
        self.breadth=breadth
class Cuboid(Rect):
    def __init__(self,length,breadth,height):
        super().__init__(length,breadth)
        self.height=height
        self.volume=self.height*breadth*length
    def __le__(self,other):
        if(self.volume<=other.volume):
            print(f"Cuboid2 has greater volume ")
        elif other.volume<=self.volume:
            print("Cuboid1 has greater volume")
        else:
            print("Both have same volume")
c1=Cuboid(2,4,5)
c2=Cuboid(1,2,3)
c1<=c2