import random

dict = {}
personer = []
felt_pekere = {0:0, 1:1, 2:2, 3:8, 4:4, 5:5, 6:6, 7:7, 8:8, 9:13, 10:2, 11:11, 12:12, 13:13, 14:14, 15:6}
for i in range(0,15):
    dict[i] = 0
for i in range(100000):
    personer.append(0)


for i in range(len(personer)):

    terning = random.randint(1,6)
    personer[i] += terning
    if personer[i] > 15:
        personer[i] -= 15
    for felt in felt_pekere:
        if personer[i] == felt:
            personer[i] = felt_pekere[felt]

    dict[personer[i]] += 1

print(dict)