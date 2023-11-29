count = 0
distance = 10_000
firstFriendSpeed = 1
secondFriendSpeed = 2
dogSpeed = 5
friend = 2
time = 0

while distance > 10:
    if friend == 1:
        time = distance / (firstFriendSpeed + dogSpeed)
        friend = 2
    else:
        time = distance / (secondFriendSpeed + dogSpeed)
        friend = 1
    distance = distance - (firstFriendSpeed + secondFriendSpeed) * time
    count += 1

print('По предложенному алгоритму решения задачи из лекции: если друзья идут навстречу друг другу, то собака пробежит', count, 'раз')

count = 0
distance = 10_000
distanceDog = 0
while distance > 10:
    distance -= firstFriendSpeed + secondFriendSpeed
    distanceDog += dogSpeed
    if distanceDog >= distance:
        count += 1
        distanceDog = 0

print('По более правильному алгоритму: если друзья идут навстречу друг другу, то собака пробежит', count, 'раз')

count = 0
distance = 10_000
distanceDog = 0

while distance > 10:
    distance -= secondFriendSpeed - firstFriendSpeed
    distanceDog += dogSpeed
    if distanceDog >= distance:
            count += 1
            distanceDog = 0

print('Если друзья идут в одну сторону, то собака пробежит', count, 'раз')