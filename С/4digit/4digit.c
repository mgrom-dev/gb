#include <stdio.h>
#include <stdlib.h>

#define PATH "./p.MD"
#define STR_LEN 32

int count_row(FILE* file);
void read_rows(FILE* file, char strings[][STR_LEN]);
void save_rows(FILE* file, char strings[][STR_LEN], int count);
void print_stings(char strings[][STR_LEN], int count);
void sort_rows(char strings[][STR_LEN], int count);
void swap_rows(char str1[STR_LEN], char str2[STR_LEN]);
int compare_rows(char str1[STR_LEN], char str2[STR_LEN]);
int getNumFromRow(char str1[STR_LEN]);
void remove_duplicate_rows(char strings[][STR_LEN], int* count);
int strlen(char str[STR_LEN]);
void strcopy(char resource[STR_LEN], char target[STR_LEN]);

int main(){
    FILE* file = fopen(PATH, "r+");

    if (file != NULL) {
        int count_rec = count_row(file);
        char strings[count_rec][STR_LEN];

        read_rows(file, strings);
        sort_rows(strings, count_rec);
        remove_duplicate_rows(strings, &count_rec);
        print_stings(strings, count_rec);
        //save_rows(file, strings, count_rec);

        fclose(file);
    }

    return 0;
}

// Количество строк в файле
int count_row(FILE* file) {
    int count = 0;
    char str[STR_LEN];
    fseek(file, 0, SEEK_SET);
    while (fscanf(file, "%[^\n]%*c", str) == 1) count++;
    fseek(file, 0, SEEK_SET);
    return count;
}

// Чтение строк
void read_rows(FILE* file, char strings[][STR_LEN]) {
    fseek(file, 0, SEEK_SET);
    for (int i = 0; fscanf(file, "%[^\n]%*c", strings[i]) == 1;  i++) ;
    fseek(file, 0, SEEK_SET);
}

// Вывод строк
void print_stings(char strings[][STR_LEN], int count) {
    for (int i = 0; i < count; i++)
        printf("%s %d\n", strings[i], strlen(strings[i]));
}

// Сортировка строк
void sort_rows(char strings[][STR_LEN], int count) {
    for (int i = 0; i < count; i++) {
        for (int j = i + 1; j < count; j++) {
            if (compare_rows(strings[i], strings[j]) > 0)
                swap_rows(strings[i], strings[j]);
        }
    }
}

// Поменять строки между собой местами
void swap_rows(char str1[STR_LEN], char str2[STR_LEN]) {
    char tmp[STR_LEN];
    strcopy(str1, tmp);
    strcopy(str2, str1);
    strcopy(tmp, str1);
}

// получить номер из строки
int getNumFromRow(char str1[STR_LEN]) {
    int result;
    if (sscanf(str1, "%*[^0-9]%d", &result) != 1) result = -1;
    return result;
}

// Сравнение строк
int compare_rows(char str1[STR_LEN], char str2[STR_LEN]) {
    int num1 = getNumFromRow(str1);
    int num2 = getNumFromRow(str2);
    if (num1 == -1 || num2 == -1)
        exit(1);
    return num1 > num2 ? 1 : (num1 < num2 ? -1 : 0);
}

// Длина строки
int strlen(char str[STR_LEN]) {
    int length = 0;
    while(str[length++] != '\0') ;
    return --length;
}

// Запись строк в файл
void save_rows(FILE* file, char strings[][STR_LEN], int count) {
    fseek(file, 0, SEEK_SET);
    for (int i = 0, l = strlen(strings[i]); i < count; i++, l = strlen(strings[i])) {
        if (i > 0) fputc('\n', file);
        fwrite(strings[i], sizeof(char), l, file);
    }
    fseek(file, 0, SEEK_SET);
}

// Удаление дубликатов строк
void remove_duplicate_rows(char strings[][STR_LEN], int* count) {
    int index = 0;
    char new_strings[*count][STR_LEN];
    for (int i = 0; i < *count; i++) {
        int duplicate = 0;
        for (int j = 0; j < i - 1; j++) {
            printf("%d %d %s %d\n", getNumFromRow(strings[i]), getNumFromRow(strings[j]), strings[j], j);
            if (getNumFromRow(strings[i]) == getNumFromRow(strings[j])) {
                
                duplicate = 1;
                break;
            }
        }
        if (duplicate == 0)
            strcopy(strings[i], new_strings[index++]);
    }
    *count = index;
    for (int i = 0; i < index; i++) {
        strcopy(new_strings[i], strings[i]);
    }
}

// Копирование строки
void strcopy(char resource[STR_LEN], char target[STR_LEN]) {
    int len1 = strlen(resource), len2 = strlen(target);
    for (int i = 0; i <= len1 || i <= len2; i++) {
        char tmp = resource[i];
        resource[i] = target[i];
        target[i] = tmp;
        if (i >= len1) target[i] = '\0';
        if (i >= len2) resource[i] = '\0';
    }
}