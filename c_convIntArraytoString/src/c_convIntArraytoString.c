#include <stdio.h>
#include <string.h>


int main( void )
{
    int array[10]; // Array de datos en formato int
    // simulamos array de datos

    for(int i=0;i<10;i++){
    array[i]=2042;
    }
    char string[40] = {0}; // Convertimos a String el array de datos

    strcpy( string, "[" ); // Agregamos al principio un caracter
    for( size_t i = 0; i < (sizeof(array)/sizeof(int)) -1; i++ ){
        sprintf( &string ,  "%d, ", array[i] );  // Recorremos el array, agregamos "," y convertimos a char
    }
    sprintf( &string[ strlen(string) ],  "%d", array[(sizeof(array)/sizeof(int)-1)] ); // El último dato debe agregarse a mano
    strcat( string, "]" );  // Agregamos al final el caracter de terminación

    //printf("%i\n", sizeof(int)); // Vemos el string generado a enviar
    //printf("%i\n", sizeof(array)); // Vemos el string generado a enviar
    //printf("%i\n", sizeof(char)); // Vemos el string generado a enviar
    //printf("%i\n", strlen(string)); // Vemos el string generado a enviar
    printf("%s\n", string); // Vemos el string generado
}
