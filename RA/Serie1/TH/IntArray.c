int a[10];
int getAt(int);

int main(int argc, char **argv)
{
	int i=getAt(1);
	return i;
}

int getAt(int i)
{
	return a[i];
}


