class flower:
    def __init__(self,name):
        self.name=name
f1=flower("Rose")
f2=flower("Lotus")
f1.patelColor="Red"

if hasattr(f1,"patelColor"):
    print(f"{f1.patelColor} {f1.name} ")
else:
    print("Unknown")
