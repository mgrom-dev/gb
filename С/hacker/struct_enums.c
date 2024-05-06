#include <math.h>
#include <stdio.h>
#include <stdlib.h>

struct triangle {
    int a;
    int b;
    int c;
};

typedef struct triangle triangle;

/* вычисление плозади треуголника */
double area(triangle tr) {
    double p = (double) (tr.a + tr.b + tr.c) / 2;
    return sqrt(p * (p - tr.a) * (p - tr.b) * (p - tr.c));
}

/* сортировка структур */
void sort_by_area(triangle* tr, int n) {
    int swapped = 0;
    do {
        swapped = 0;
        for (int i = 1; i < n; i++)
            if (area(tr[i]) < area(tr[i - 1])) {
                triangle tmp = tr[i];
                tr[i] = tr[i - 1];
                tr[i - 1] = tmp;
                swapped = 1;
            }
    } while (swapped);
}

/* n - количество структур */
int main() {
    int n;
    scanf("%d", &n);
    triangle* tr = malloc(n * sizeof(triangle));
    for (int i = 0; i < n; i++) {
        scanf("%d%d%d", &tr[i].a, &tr[i].b, &tr[i].c);
    }
    sort_by_area(tr, n);
    for (int i = 0; i < n; i++) {
        printf("%d %d %d\n", tr[i].a, tr[i].b, tr[i].c);
    }
    free(tr);
    return 0;
}