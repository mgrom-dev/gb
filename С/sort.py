import random
import time

# 40850 ms over 2000MB
def main():
    array = [0] * 100000000
    randomize_array(array, 1000)
    start_time = time.time()
    sort_array_frequency(array)
    end_time = time.time()
    print("time sort:", (end_time - start_time) * 1000)
    print(array[0], ":", array[999999])

def randomize_array(array, bound):
    for i in range(len(array)):
        array[i] = random.randint(0, bound)

def sort_array(array):
    array.sort()

def sort_array_frequency(array):
    size = len(array)
    frequency_array = [0] * size
    freq_size = 0

    for i in range(size):
        index = array[i]
        frequency_array[index] += 1
        if index > freq_size:
            freq_size = index
    freq_size += 1

    # Fill the final array based on the created frequency array
    index = 0
    for i in range(freq_size):
        for r in range(frequency_array[i]):
            array[index] = i
            index += 1

main()