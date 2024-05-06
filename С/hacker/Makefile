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

clean:
	rm -f *.exe