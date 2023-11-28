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

print('Если друзья идут навстречу друг другу, то собака пробежит', count, 'раз')

count = 0
distance = 10_000
friend = 2

while distance > 10:
    distance = 0

print('Если друзья идут в одну сторону, то собака пробежит', count, 'раз')