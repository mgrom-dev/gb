FLAGS = -Wall -Wextra -Werror -std=c11

all: sort

sort: sort.c
	gcc $(FLAGS) $<

# Примерный путь к C# Compiler
# C:\Windows\Microsoft.NET\Framework\v4.0.30319\csc.exe
sortcs: sort.cs
	csc /out:$@.exe $<
	./$@.exe

sortJava: Sort.java
	javac $^
	java Sort

# Hello world на Asm
helloWorldAsm:
	.\nasm-2.16.01\nasm.exe -f win64 hello_world.asm -o hello_world.o
	ld hello_world.o -o hello_world.exe -L C:\Windows\System32 -l kernel32
	.\hello_world.exe

# Sort на Asm
sortAsm:
	.\nasm-2.16.01\nasm.exe -f win64 sort.asm -o sort.o
	ld sort.o -o sort.exe -L C:\Windows\System32 -l kernel32 advapi32
	.\sort.exe

# Sort with threads in C
sortThreadC: bubble_sort_threads.c
	gcc $(FLAGS) $< -o ./$@.exe -pthread
	./$@.exe

clean:
	rm -rf *.exe *.o *.obj