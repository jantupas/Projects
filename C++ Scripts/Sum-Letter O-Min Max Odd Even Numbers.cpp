//Practical Exam 2 Jan Edgar Tupas CS126-8L/BM9 October 19, 2021
#include<iostream>
#include<iomanip>
using namespace std;
int main()
{
	//declaration
	char choice,ans;
	int n,a1,an,sum;//first choice
	int size,rowSize,row,col;//second choice
	int inputSize,num,even,odd,count,lowestEven,highestEven,lowestOdd,highestOdd;//third choice
	
	
	//executable
	do{
		do{
					//menu
					system("cls");
				cout<<"MENU OPTION"<<endl
					<<"[1]Sum of Integer Numbers"<<endl
					<<"[2]Letter O"<<endl
					<<"[3]Highest and Lowest Odd and Even Numbers"<<endl
					<<"Enter your choice: ";
					
				cin>>choice;
			
			  }while(choice<'1'||choice>'3');
			  
			  system("cls");
				switch(choice)
				{
					case '1'://first choice - sum of integer numbers
					{
						cout<<"Sum of Integer Numbers"<<endl;
						cout<<"Input the first number to be added (a1): ";
						cin>>a1;
						cout<<"Input the last number to be added (an): ";
						cin>>an;
						
						n = (an - a1) + 1;
						sum = n * (a1 + an) / 2;
						
						cout<<endl<<"The sum of "<<a1<<" to "<<an<<" = "<<sum<<endl;
						
					
					cout<<endl;
						do{//option to return to main menu or not
							cout<<"Return to Main Menu? [Y/N]:";
							cin>>ans;
						  }while(ans!='Y'&&ans!='N'&&ans!='y'&&ans!='n');
					}
					break;
					case '2'://second choice - letter O
					{
						cout<<"Letter O"<<endl;
						
						do{
							cout<<"Input size of letter O to generate (5-15) odd numbers only: ";
							cin>>size;
							
							if(size%2==0)
								cout<<"Size must be odd numbers only"<<endl;
							if(size<5||size>15)
								cout<<"Size must be from 5 - 15 only"<<endl;
							
							}while(size<5||size>15||size%2==0);
							
							rowSize = size + 2;
							{
								cout<<left;
								for(row=1;row<=rowSize;row++)
								{
									for(col=1;col<=size;col++)
									{
										if(row==1||row==rowSize)
										{
											if(col>1&&col<size)
												cout<<setw(2)<<"o";
											else
												cout<<setw(2)<<" ";
										}
										else if(row>1&&row<rowSize)
										{
											if(col==1||col==size)
												cout<<setw(2)<<"o";
											else
												cout<<setw(2)<<" ";
										}
					
									}
									cout<<endl;
								}
							}
						cout<<endl;
						do{//option to return to main menu or not
							cout<<"Return to Main Menu? [Y/N]:";
							cin>>ans;         	
						  }while(ans!='Y'&&ans!='N'&&ans!='y'&&ans!='n');
					}
					break;
					case '3'://third choice - highest and lowest odd and even numbers
					{
						cout<<"Highest and Lowest Odd and Even Numbers"<<endl;
						do{
							cout<<"How many numbers to input (1-100 only)?: ";
							cin>>inputSize;
							
							if(inputSize<1||inputSize>100)
								cout<<"Invalid range must only be from 1-100"<<endl;
								
						}while(inputSize<1||inputSize>100);	
						
						cout<<"Input "<<inputSize<<" numbers:"<<endl;
						odd=0;
						even=0;
						lowestEven = 1000000;
						highestEven = 0;
						lowestOdd = 999999;
						highestOdd = 1;
						count = 1;
						while(count<=inputSize)
						{
							do{
								cin>>num;
								
								if(num<1)
									cout<<"Invalid number must be positive"<<endl;
							}while(num<1);
								
								if(num%2==0)
								{
									even++;
						
									if(num<lowestEven)
										lowestEven = num;
									if(num>highestEven)
										highestEven = num;
								}
								
								else
								{
									odd++;
									
									if(num<lowestOdd)
										lowestOdd = num;
									if(num>highestOdd)
										highestOdd = num;	
								}
								count++;
							
						}
						cout<<"There is/are "<<even<<" EVEN numbers: "<<endl;
						if(even==0)
						{
							cout<<"The HIGHEST EVEN number is 0"<<endl
								<<"The LOWEST EVEN number is 0"<<endl
								<<endl;
						}
						else
						{
							cout<<"The HIGHEST EVEN number is "<<highestEven<<endl
								<<"The LOWEST EVEN number is "<<lowestEven<<endl
								<<endl;
						}	
							
						cout<<"There is/are "<<odd<<" ODD numbers: "<<endl;
						if(odd==0)
						{
							cout<<"The HIGHEST ODD number is 0"<<endl
								<<"The LOWEST ODD number is 0"<<endl
								<<endl;
						}
						else
						{
							cout<<"The HIGHEST ODD number is "<<highestOdd<<endl
								<<"The LOWEST ODD number is "<<lowestOdd<<endl
								<<endl;
						}
						cout<<endl;
							do{//option to return to main menu or not
								cout<<"Return to Main Menu? [Y/N]:";
								cin>>ans;         	
							  }while(ans!='Y'&&ans!='N'&&ans!='y'&&ans!='n');
					}
					break;
				
				}
	}while(ans=='Y'||ans=='y');
}
