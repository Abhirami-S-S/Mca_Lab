
def compare(a, b):
    a = sorted(a)   # correct
    b = sorted(b)
    return a == b

l1 = input("Enter the Elements with : ").split(",")
l2 = input("Enter the Elements with : ").split(",")

# normalize (lowercase + remove spaces)
l1 = [c.lower().strip() for c in l1]
l2 = [c.lower().strip() for c in l2]

if compare(l1, l2):
    print("Both are same")
else:
    print("Both are different")
