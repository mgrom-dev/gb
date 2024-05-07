# отключаем вывод команд при сборке целей
MAKEFLAGS += --silent
# при := значение вычисляется сразу
GCC := gcc -Werror -Wextra -Wall -std=c11
# макрос, который используется также как переменные
define COMMANDS
	$(GCC) $< -o $@
	./$@
	rm -f $@.exe $@
endef

# Sorting by bubbles
bubble_sort2: bubble_sort2.c
	$(COMMANDS)

# Functions with a variable number of parameters
var_func: var_func.c
	$(COMMANDS)

# Repeat symbols
mumbling: mumbling.c
	$(COMMANDS)

# Sort structures
struct_enums: struct_enums.c
	$(GCC) $< -o $@
	echo "3 7 24 25 5 12 13 3 4 5" | ./$@
	rm -f $@.exe $@

clean:
	rm -f *.exe