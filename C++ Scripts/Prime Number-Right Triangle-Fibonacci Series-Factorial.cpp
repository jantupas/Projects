#include<iostream>
#include<iomanip>
using namespace std;

int main()
{
	//declaration
	char choice;
	int fact,count,num;//choice 1
	int size,row,col;//choice 2
	int number,counter,x,y,z;//choice 3
	int numb,factorial,countr;//choice 4
	char ans;
	
	//executable
	do{
		do{
				//menu
				system("cls");
			cout<<"**************MENU**************"<<endl
				<<"[1]PRIME NUMBER"<<endl
				<<"[2]RIGHT TRIANGLE"<<endl
				<<"[3]FIBONACCI SERIES"<<endl
				<<"[4]FACTORIAL"<<endl
				<<"[5]EXIT"<<endl
				<<"********************************"<<endl
				<<"ENTER THE NUMBER OF YOUR CHOICE: ";
				
			cin>>choice;
		
		  }while(choice<'1'||choice>'5');
		
			system("cls");
			switch(choice)
			{
				case '1'://first choice - prime number
					{
						cout<<"PRIME NUMBER"<<endl;
						fact=0;
						
						
							cout<<"Enter a Number: ";
							cin>>num;
							
							if(num>0)
						
							{
								for(count=1;count<=num;count++)
								{
									if(num%count==0)
										fact++;
								}
								if(fact==2)
									cout<<num<<" is a Prime Number"<<endl;
								else
									cout<<num<<" is not a Prime Number"<<endl;
							}
							else
							{
								cout<<"Invalid input . . . exiting the program . . . ";
								system("pause");
			            		exit(0);
			            	}
			            	cout<<endl;
						        do{//option to return to main menu or not
						         	cout<<"Return to Main Menu? [Y/N]:";
						         	cin>>ans;
						         	    
						         	
								}while(ans!='Y'&&ans!='N'&&ans!='y'&&ans!='n');
								
					}
				break;
				case '2'://second choice - right triangle
					{
						cout<<"RIGHT TRIANGLE"<<endl;
						
						
							cout<<"Enter a Number for the Size of Right Triangle: ";
							cin>>size;
							
						if(size>=5)
						{
							cout<<left;
							for(row=1;row<=size;row++)
							{
								for(col=1;col<=size;col++)
								{
									if(col<=row)
									cout<<setw(5)<<col;
									else
										cout<<setw(5)<<" ";
								}
								cout<<endl;
							}
						}
						else
						{
							cout<<"Invalid input . . . exiting the program . . . ";
							system("pause");
			            	exit(0);
			        	}
			        	cout<<endl;
						    do{//option to return to main menu or not
						        cout<<"Return to Main Menu? [Y/N]:";
						        cin>>ans;
						         	    
						         	
							}while(ans!='Y'&&ans!='N'&&ans!='y'&&ans!='n');
							
					}
				break;
				case '3'://third choice - fibonacci series
				{	
						cout<<"FIBONACCI SERIES"<<endl;
						
						
							cout<<"Enter a Number: ";
							cin>>number;
							
							if(number==1)
								cout<<1;
									
							else if(number>0)
				            {
								x=1;
								y=1;
								counter=2;
								cout<<x<<" "<<y<<" ";
								
								for(counter=2;counter<number;counter++)
								{
									z=x+y;
									cout<<z<<" ";
									x=y;
									y=z;
								}	
							}
							else
							{
								cout<<"Invalid input . . . exiting the program . . . ";
								system("pause");
			            		exit(0);
							}
							cout<<endl;
							    do{//option to return to main menu or not
							        cout<<"Return to Main Menu? [Y/N]:";
							        cin>>ans;
							         	    
							         	
								}while(ans!='Y'&&ans!='N'&&ans!='y'&&ans!='n');	  
				}
				break;
				case '4'://fourth choice - factorial
				{
						cout<<"FACTORIAL"<<endl;
						
						
							cout<<"Enter a Number: ";
							cin>>numb;
						if(numb>=0)
						{
							if(numb==0)
							   cout<<"Factorial of "<<numb<<" is 1"<<endl;
							else
							{
								cout<<"Factorial of ";
								countr=numb-1;
								cout<<numb<<"*"<<countr<<"*";
								factorial=numb*countr;
								while(countr>1)
								{
									countr-=1;
									cout<<countr;
									if(countr>1)
									cout<<"*";
									factorial=factorial*countr;
								}
								cout<<" is "<<factorial<<endl;
							}
						}
						else
						{
							cout<<"Invalid input . . . exiting the program . . . ";
							system("pause");
			            	exit(0);
						}
						cout<<endl;
						    do{//option to return to main menu or not
						        cout<<"Return to Main Menu? [Y/N]:";
						        cin>>ans;
						         	    
						         	
							}while(ans!='Y'&&ans!='N'&&ans!='y'&&ans!='n');
				}
				break;
				case '5'://fifth choice - exit program
				{
					cout<<"Terminating the program . . . ";
	      	        	system("pause");
			            exit(0);
				}
				
			}
		  
		
	  }while(ans=='Y'||ans=='y');		
}
