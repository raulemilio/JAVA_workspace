    #include <stdio.h>
    #include<string.h>
    int main()
    {
       char *str1;  // declaration of char array
       printf("Enter string : ");
       scanf("%s",str1);
       // comparing both the strings using strcmp() function
       if(strcmp(str1,"dato")==0)
       printf("strings are same");
       else
       printf("strings are not same");
       return 0;
    }
