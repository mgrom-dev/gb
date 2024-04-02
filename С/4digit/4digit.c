#include <stdio.h>
#include <stdlib.h>

#define PATH "./p.MD"
#define STR_LEN 1024

int count_row(FILE* file);
void read_rows(FILE* file, char strings[][STR_LEN]);
void save_rows(FILE* file, char strings[][STR_LEN], int count);
void print_stings(char strings[][STR_LEN], int count);
void sort_rows(char strings[][STR_LEN], int count);
void swap_rows(char str1[STR_LEN], char str2[STR_LEN]);
int compare_rows(char str1[STR_LEN], char str2[STR_LEN]);
void remove_duplicate_rows(char strings[][STR_LEN], int count);
int strlen(char str[STR_LEN]);

int main(){
    FILE* file = fopen(PATH, "r+");

    if (file != NULL) {
        int count_rec = count_row(file);
        char strings[count_rec][STR_LEN];

        read_rows(file, strings);
        sort_rows(strings, count_rec);
        //print_stings(strings, count_rec);
        save_rows(file, strings, count_rec);

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
    int len1 = strlen(str1), len2 = strlen(str2);
    for (int i = 0; i <= len1 || i <= len2; i++) {
        char tmp = str1[i];
        str1[i] = str2[i];
        str2[i] = tmp;
        if (i >= len1) str2[i] = '\0';
        if (i >= len2) str1[i] = '\0';
    }
}

// Сравнение строк
int compare_rows(char str1[STR_LEN], char str2[STR_LEN]) {
    int result = 0;
    int num1, num2;
    if (sscanf(str1, "%*[^0-9]%d", &num1) == 1 && sscanf(str2, "%*[^0-9]%d", &num2) == 1) {
        result = num1 > num2 ? 1 : (num1 < num2 ? -1 : 0);
    }
    else exit(1);
    return result;
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
void remove_duplicate_rows(char strings[][STR_LEN], int count) {
    char strings[count][STR_LEN];
    for (int i = 1; i < count; i++) {
        
    }
}