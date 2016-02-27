#include<stdio.h>
 
/* Function to calculate x raised to the power y */
int power(int x, unsigned int y)
{
    if( y == 0)
        return 1;
    else if (y%2 == 0)
        return power(x, y/2)*power(x, y/2);
    else
        return x*power(x, y/2)*power(x, y/2);
 
}
 
/* Program to test function power */
int main()
{
    int x = 2;
    unsigned int y = 3;
 
    printf("%d", power(x, y));
    getchar();
    return 0;
}

/* ---------------------- */
/* Time Complexity: O(n)  */
/* Space Complexity: O(1) */
/* ---------------------- */

/* Extended version of power function that can work
 for float x and negative y*/
#include<stdio.h>
 
float power(float x, int y)
{
    float temp;
    if( y == 0)
       return 1;
    temp = power(x, y/2);       
    if (y%2 == 0)
        return temp*temp;
    else
    {
        if(y > 0)
            return x*temp*temp;
        else
            return (temp*temp)/x;
    }
}  
 
 
/* ----------------------- */
/* Time Complexity: O(logn)*/
/* Space Complexity: O(1)  */
/* ----------------------- */

