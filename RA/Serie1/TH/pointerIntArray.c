int a[10];
int getAt(int *a , int);

int main(int argc, char **argv)
{
	int *pointer;
	int pointerWert =255;
	pointer=&pointerWert;
	getAt(pointerWert, 1);
	return 0;
	
}

int getAt(int *a, int i)
{
	return *(a+i);
}


