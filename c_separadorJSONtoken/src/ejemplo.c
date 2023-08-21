#include <string.h>
#include <stdio.h>

int main () {

   char strDatos[80] = "{\"dato1\":\"23\",\"dato2\":\"texto\"}"; // array de datos en formato Json
   const char s[5] = ",\":"; // separadores de datos
   char arrayDatos[2][10]; // array de datos recibidos
   char *token; // varable aux para guardar los datos

   /* get the first token */
   token = strtok(strDatos, s);
   int i=0;// index para sacar todos los campos separados por los caracteres de separación
   int indexDatos=0;// index para guardar los datos útiles

   /* walk through other tokens */
   while( token != NULL ) {
   printf( " %s\n", token );
   		if((i % 2 == 0) & (i!=0)){ // solo guardamos los datos si el index es par y además con i distinto de 0
   		  strcpy(arrayDatos[indexDatos], token);
   		  indexDatos++;
   		  }
   token = strtok(NULL, s);
   i++;
   }

  // verificamos que los datos se cargaron
  for(int j=0;j<2;j++){
      printf( " datos en arrayDatos  %s\n", arrayDatos[j] );
  }
  printf( "\n");
  printf( "Ejemplo de como convertir dato 1 en int %i\n", (atoi(arrayDatos[1])-5));
  return(0);
}
