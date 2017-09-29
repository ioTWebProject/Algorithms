# Hello World program in Python
import random
comp = 0
exch = 0
def merge(a,b):
    """ Function to merge two arrays """
    c = []
    global comp 
    global exch
    while len(a) != 0 and len(b) != 0:
        comp +=1
        if a[0] < b[0]:
            exch +=1
            c.append(a[0])
            a.remove(a[0])
        else:
            c.append(b[0])
            exch+=1
            b.remove(b[0])
    if len(a) == 0:
        c += b
    else:
        c += a
    return c

# Code for merge sort
a = []
def mergesort(x):
    """ Function to sort an array using merge sort algorithm """
    if len(x) == 0 or len(x) == 1:
        return x
    else:
        middle = len(x)/2
        a = mergesort(x[:middle])
        b = mergesort(x[middle:])
        return merge(a,b)

for i in range(0,100):
   randomnumber = random.randint(10,100)
   a.append(randomnumber)
print(a)
print(mergesort(a))
print("Numbers of comp: ",comp)
print("Numbers of exch: ",exch)
