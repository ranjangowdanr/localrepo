#include<stdio.h>
#include<stdlib.h>
void bubblesort(int a[],int n)
{
 for(int i=0;i<n-1;i++)
  { 
  for(int j=0;j<n-1-i;j++)
  { 
   if(a[j]>a[j+1])
   {
   int temp=a[j];
   a[j]=a[j+1];
   a[j+1]=temp;
   }
  }
  } 
}
void display(int a[], int n)
{
 for(int i=0;i<n;i++)
 {
 printf("%d ",a[i]);
 }
 printf("\n");

}

int main()
{
 int a[5]={5,4,3,2,1};
 printf("Before Sorting\n");
 display(a,5);
 bubblesort(a,5);
 printf("After sorting\n");
 display(a,5);
 
 return 0;
}
