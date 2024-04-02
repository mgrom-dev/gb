#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int lexicographic_sort(const void* a, const void* b) {
    return strcmp(*(const char**)a, *(const char**)b); 
}

int lexicographic_sort_reverse(const void* a, const void* b) {
    return strcmp(*(const char**)b, *(const char**)a); 
}

int sort_by_number_of_distinct_characters(const void* a, const void* b) {
    int i, len1, len2;
    char* str = *(char**)a;
    for(i = len1 = 0; str[i]; i++) {
        char* index = strchr(str, str[i]);
        if (index - str >= i) len1++;
    }
    str = *(char**)b;
    for(i = len2 = 0; str[i]; i++) {
        char* index = strchr(str, str[i]);
        if (index - str >= i) len2++;
    }
    if (len1 > len2) return 1;
    else if (len1 < len2) return -1;
    else return lexicographic_sort(a, b);
}

int sort_by_length(const void* a, const void* b) {
    if (strlen(*(const char**)a) > strlen(*(const char**)b)) return 1;
    else if (strlen(*(const char**)a) < strlen(*(const char**)b)) return -1;
    else return lexicographic_sort(a, b);
}

void string_sort(char** arr, const int len, int (*cmp_func)(const void* a, const void* b)) {
    qsort(arr, len, sizeof(char*), cmp_func);
}


int main() 
{
    int n;
    scanf("%d", &n);
  
    char** arr;
	arr = (char**)malloc(n * sizeof(char*));
  
    for(int i = 0; i < n; i++){
        *(arr + i) = malloc(1024 * sizeof(char));
        scanf("%s", *(arr + i));
        *(arr + i) = realloc(*(arr + i), strlen(*(arr + i)) + 1);
    }
  
    string_sort(arr, n, lexicographic_sort);
    for(int i = 0; i < n; i++)
        printf("%s\n", arr[i]);
    printf("\n");

    string_sort(arr, n, lexicographic_sort_reverse);
    for(int i = 0; i < n; i++)
        printf("%s\n", arr[i]); 
    printf("\n");

    string_sort(arr, n, sort_by_length);
    for(int i = 0; i < n; i++)
        printf("%s\n", arr[i]);    
    printf("\n");

    string_sort(arr, n, sort_by_number_of_distinct_characters);
    for(int i = 0; i < n; i++)
        printf("%s\n", arr[i]); 
    printf("\n");
}