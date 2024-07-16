//Write a C program that contains a string (char pointer) with a value Hello World'. 
//The program should AND or and XOR 2 each character in this string with 127 and display the result.

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void main()
{
    char str[]="Hello World";
    int i,len;
    len = strlen(str);
    for(i=0;i<len;i++)
    {
        printf("%c",str[i]&127);
    }
    printf("\n");
    for(int i=0;i<len;i++)
    {
        printf("%c",str[i]^127);
    }
    printf("\n");
}