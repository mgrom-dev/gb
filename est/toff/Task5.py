min_val, max_val = input().split(" ")
min_val = int(min_val)
max_val = int(max_val)

count = 0
num_str = str(min_val)
k = len(num_str)
num = min_val
i = int(num_str[0])

while num <= max_val:
    try:
        num = int(str(i % 10) * k)
    except ValueError:
        break
    if num > max_val:
        break
    count += 1
    i += 1
    if i % 10 == 0:
        k += 1
        i += 1

print(count)
