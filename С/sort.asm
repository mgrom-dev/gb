extern ExitProcess
extern GetStdHandle
extern WriteFile
extern CryptGenRandom

section .data
    message db "Random number: ", 0
    newline db 13, 10, 0
    buffer rb 4

section .text
global _start
_start:
    ; Получение дескриптора стандартного вывода
    mov rcx, -11           ; STD_OUTPUT_HANDLE
    call GetStdHandle
    mov rdi, rax           ; Сохраняем дескриптор в rdi для использования в WriteFile

    ; Генерация случайного числа
    mov rcx, 4              ; Размер буфера для числа (в байтах)
    mov rdx, buffer         ; Адрес буфера для числа
    mov r8, rcx             ; Передача размера буфера в r8 (необходимо для x64 вызовов функций)
    call CryptGenRandom     ; Вызов функции CryptGenRandom

    ; Преобразование случайного числа к диапазону от 1 до 1000
    mov eax, dword [buffer] ; Загружаем случайное число в eax
    and eax, 0x3FF          ; Ограничиваем число до 0-999
    inc eax                 ; Увеличиваем число на 1 для диапазона от 1 до 1000

    ; Преобразование числа в строку и вывод на консоль
    mov rbx, rax            ; Сохраняем число для вывода в rbx
    mov rcx, message        ; Адрес строки "Random number: "
    call print_string       ; Выводим строку
    mov rax, rbx            ; Загружаем число обратно в rax
    call print_number       ; Выводим число
    mov rcx, newline        ; Адрес строки с переводом строки
    call print_string       ; Выводим перевод строки

    ; Завершение программы
    xor ecx, ecx
    call ExitProcess

print_string:
    ; Вывод строки на консоль
    mov rdx, -1             ; Определение длины строки (-1 для ASCIIZ)
    call WriteFile
    ret

print_number:
    ; Преобразование числа в строку и вывод на консоль
    push rbx                ; Сохраняем rbx
    mov r8, 10              ; Основание системы счисления (10 для десятичной)
    xor rcx, rcx            ; Сбрасываем rcx
    lea rdx, [rsp-10]       ; Адрес буфера для строки (10 байт)
.convert_loop:
    inc rcx                 ; Увеличиваем счетчик цифр
    xor rax, rax            ; Сбрасываем rax
    div r8                  ; Делим число на основание системы счисления
    add dl, '0'             ; Преобразуем остаток в ASCII и добавляем к строке
    mov [rdx+rcx], dl       ; Сохраняем цифру в строку
    test rax, rax           ; Проверяем, достигли ли нуля
    jnz .convert_loop       ; Если нет, продолжаем конвертирование
    ; Разворачиваем строку в обратном порядке
    lea rsi, [rdx+rcx]      ; Конечный адрес строки
    lea rdi, [rdx]          ; Начальный адрес строки
    dec rcx                 ; Уменьшаем rcx, чтобы не включать нуль-терминатор
.reverse_loop:
    mov al, [rdi]           ; Загружаем символ из начала строки
    mov dl, [rsi]           ; Загружаем символ из конца строки
    mov [rdi], dl           ; Перемещаем символ из конца строки в начало
    mov [rsi], al           ; Перемещаем символ из начала строки в конец
    inc rdi                 ; Переходим к следующему символу в начале строки
    dec rsi                 ; Переходим к предыдущему символу в конце строки
    cmp rdi, rsi            ; Проверяем, достигли ли середины строки
    jl .reverse_loop        ; Если нет, продолжаем разворачивание
    pop rbx                 ; Восстанавливаем rbx
    ret
