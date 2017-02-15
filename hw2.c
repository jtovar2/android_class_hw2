#include <stdio.h>
#include <math.h>
#include <stdlib.h>


void vector_input(float v[],int n);
void vector_output(float v[],int n);
void vector_add(float v1[],float v2[],float v3[],int n); //v3=v1+v2
void vector_multiply(float v[],int n,float x); //v=v*x
float inner_product(float v1[],float v2[],int n); //return v1.v2
float length(float v[],int n);

int main()
{
	return 0;
}

void vector_input(float v[],int n)
{
  static int *ptr_to_array = NULL;
  static int local_array_size = 0;

  free(ptr_to_array);
  ptr_to_array = malloc(n * sizeof(float)/sizeof(int));

  int *temp = ptr_to_array;
  int index = 0;
  for(index = 0; index < n; index++)
    {
      *temp = v[index];
      temp++;
    }
  local_array_size = n;
}

void vector_output(float v[],int n)
{
  int index = 0;
  printf("( ");
  for(index = 0; index < n; index++)
    {
      printf("%f ", *v[index]);
    }
  printf(")\n");
  
}

void vector_add(float v1[],float v2[],float v3[],int n) //v3=v1+v2
{
  int index = 0;
  for(index = 0; index < n; index++)
    {
      v3[index] = v1[index] + v2[index];
    }
}

void vector_multiply(float v[],int n,float x) //v=v*x
{
  pint index = 0;
  for(index = 0; index < n; index++)
    {
      v[index] = v[index] * x;
    }
}

float inner_product(float v1[],float v2[],int n) //return v1.v2
{
  int index = 0;
  float product = 0.0;
  for(index = 0; index < n; index++)
    {
      product = v1[index] + v2[index];
    }
  return product;
}

float length(float v[],int n)
{
  int index = 0;
  float length = 0.0;
  for(index = 0; index < n; index++)
    {
      length = v[index]*v[index] + length;
    }
  length = sqrt(length);
  return length;
}
