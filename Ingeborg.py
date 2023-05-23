import random

dictionary = {}
person_liste = []
rounds = 20

for i in range(16):
    dictionary[i] = 0
for i in range(100000):
    person_liste.append(0)
    dictionary[0] += 1

for i in range(rounds):
    for person in person_liste:
        terning = random.randint(1,7)
        for i in range(1, terning):
            dictionary[person] -= 1
            if person == 15:
                person = -1
            dictionary[person + 1] += 1
            person += 1


print(dictionary)