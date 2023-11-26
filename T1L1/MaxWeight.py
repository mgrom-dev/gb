weights = [1, 8, 3, 6, 2]
max_weight = 0
for v in weights:
    if v > max_weight:
        max_weight = v
print("Max weight is: ", max_weight)