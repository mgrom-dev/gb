#include <assert.h>
#include <ctype.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *readline();
char *ltrim(char *);
char *rtrim(char *);
char **split_string(char *);

int parse_int(char *);

/**
Objective
Today, we're working with regular expressions. Check out the Tutorial tab for learning materials and an instructional video!

Task
Consider a database table, Emails, which has the attributes First Name and Email ID. Given  rows of data simulating the Emails table, print an alphabetically-ordered list of people whose email address ends in .

Input Format

The first line contains an integer, , total number of rows in the table.
Each of the  subsequent lines contains  space-separated strings denoting a person's first name and email ID, respectively.

Constraints

Each of the first names consists of lower case letters  only.
Each of the email IDs consists of lower case letters ,  and  only.
The length of the first name is no longer than 20.
The length of the email ID is no longer than 50.
Output Format

Print an alphabetically-ordered list of first names for every user with a gmail account. Each name must be printed on a new line.

Sample Input

6
riya riya@gmail.com
julia julia@julia.me
julia sjulia@gmail.com
julia julia@gmail.com
samantha samantha@gmail.com
tanya tanya@gmail.com
Sample Output

julia
julia
riya
samantha
tanya
*/

/** Block with solution */

#define MAX_N 30

struct User {
    char* firstName;
    char* emailID;
};

struct {
    int length;
    struct User* array;
} Users;

void add_user(char* firstName, char* emailID);
int compare_users_by_name(const void* a, const void* b);
void sort_users_by_name();
void remove_duplicate_users();
void print_users_name();
void delete_users();

/** -------------------- */

int main()
{
    int N = parse_int(ltrim(rtrim(readline())));

    for (int N_itr = 0; N_itr < N; N_itr++) {
        char** first_multiple_input = split_string(rtrim(readline()));

        char* firstName = *(first_multiple_input + 0);

        char* emailID = *(first_multiple_input + 1);
        
        add_user(firstName, emailID);
    }
    
    remove_duplicate_users();
    sort_users_by_name();
    print_users_name();
    delete_users();
    
    return 0;
}

void add_user(char* firstName, char* emailID) {
    if (Users.array == NULL) {
        Users.array = malloc(sizeof(struct User) * MAX_N);
        Users.length = 0;
    }
    int index = Users.length;
    Users.array[index].firstName = firstName;
    Users.array[index].emailID = emailID;
    Users.length++;
}

void print_users_name() {
    for (int i = 0, l = Users.length; i < l; i++)
        printf("%s\n", Users.array[i].firstName);
}

int compare_users_by_name(const void* a, const void* b) {
    char* user1 = strtok(((struct User *)a)->firstName, "@");
    char* user2 = strtok(((struct User *)b)->firstName, "@");
    return strcmp(user1, user2);
}

void sort_users_by_name() {
    qsort(Users.array, Users.length, sizeof(struct User), compare_users_by_name);
}

/** remove users hwo email address not ends in @gmail.com */
void remove_duplicate_users() {
    for (int i = 0; i < Users.length; i++) {
        if (!strstr(Users.array[i].emailID, "@gmail.com")) {
            for (int j = i + 1; j < Users.length; j++)
                Users.array[i] = Users.array[j];
            i--;
            Users.length--;
        }
    }
}

void delete_users() {
    for (int i = 0, l = Users.length; i < l; i++)
        free(Users.array[i].firstName);
    free(Users.array);
    Users.length = 0;
}

char *readline()
{
    size_t alloc_length = 1024;
    size_t data_length = 0;

    char *data = malloc(alloc_length);

    while (true)
    {
        char *cursor = data + data_length;
        char *line = fgets(cursor, alloc_length - data_length, stdin);

        if (!line)
        {
            break;
        }

        data_length += strlen(cursor);

        if (data_length < alloc_length - 1 || data[data_length - 1] == '\n')
        {
            break;
        }

        alloc_length <<= 1;

        data = realloc(data, alloc_length);

        if (!data)
        {
            data = '\0';

            break;
        }
    }

    if (data[data_length - 1] == '\n')
    {
        data[data_length - 1] = '\0';

        data = realloc(data, data_length);

        if (!data)
        {
            data = '\0';
        }
    }
    else
    {
        data = realloc(data, data_length + 1);

        if (!data)
        {
            data = '\0';
        }
        else
        {
            data[data_length] = '\0';
        }
    }

    return data;
}

char *ltrim(char *str)
{
    if (!str)
    {
        return '\0';
    }

    if (!*str)
    {
        return str;
    }

    while (*str != '\0' && isspace(*str))
    {
        str++;
    }

    return str;
}

char *rtrim(char *str)
{
    if (!str)
    {
        return '\0';
    }

    if (!*str)
    {
        return str;
    }

    char *end = str + strlen(str) - 1;

    while (end >= str && isspace(*end))
    {
        end--;
    }

    *(end + 1) = '\0';

    return str;
}

char **split_string(char *str)
{
    char **splits = NULL;
    char *token = strtok(str, " ");

    int spaces = 0;

    while (token)
    {
        splits = realloc(splits, sizeof(char *) * ++spaces);

        if (!splits)
        {
            return splits;
        }

        splits[spaces - 1] = token;

        token = strtok(NULL, " ");
    }

    return splits;
}

int parse_int(char *str)
{
    char *endptr;
    int value = strtol(str, &endptr, 10);

    if (endptr == str || *endptr != '\0')
    {
        exit(EXIT_FAILURE);
    }

    return value;
}
