#include<iostream>
using namespace std;

int main()
{
	//declaration
	int num,time,hours,minutes;
	
	//executable
	//main menu
	cout<<"=============================="<<endl
		<<endl
		<<"        CONVERSION"<<endl
		<<endl
		<<"=============================="<<endl
		<<endl
		<<"[1] Numbers to Roman Numeral"<<endl
		<<"[2] Military to 12-Hour Clock"<<endl
		<<"[3] Exit"<<endl
		<<endl
		<<"=============================="<<endl
		<<endl
		<<"Enter your choice: ";
	cin>>num;
	
	
	switch (num)
	{
		//first choice - number to roman numeral
		case 1: cout<<"===================================="<<endl
					<<endl
					<<"Numbers to Roman Numeral Conversion"<<endl
					<<endl
					<<"===================================="<<endl
					<<endl
					<<"Enter a number from 1 to 3000: ";
  				cin>>num;
					//process of converting number to roman numeral
					if(num>0&&num<=3000)//number must be from 1 to 3000 only
					  	{
					  		cout<<"Roman Numeral is: ";	
					  			if (num>=2000)
					  			{
					  				cout<<"MM";
					  				num=num-2000;
							    }
					  			if (num>=1000)
					  			{
							  		cout<<"M";
							  		num=num-1000;
								}
								if (num>=900)
								{
									cout<<"CM";
									num=num-900;
								}
								if (num>=500)
								{
									cout<<"D";
									num=num-500;
								}
								if (num>=400)
								{
									cout<<"CD";
									num=num-400;
								}
								if (num>=300)
								{
									cout<<"CCC";
									num=num-300;
								}
								if (num>=200)
								{
									cout<<"CC";
									num=num-200;
								}
								if (num>=100)
								{
									cout<<"C";
									num=num-100;
								}
								if (num>=90)
								{
									cout<<"XC";
									num=num-90;
								}
								if (num>=50)
								{
									cout<<"L";
									num=num-50;
								}
								if (num>=40)
								{
									cout<<"XL";
									num=num-40;
								}
								if (num>=30)
								{
									cout<<"XXX";
									num=num-30;
								}
								if (num>=20)
								{
									cout<<"XX";
									num=num-20;
								}
								if (num>=10)
								{
									cout<<"X";
									num=num-10;
								}
								if (num>=9)
								{
									cout<<"IX";
									num=num-9;
								}
								if  (num>=5)
								{
									cout<<"V";
									num=num-5;
								}
								if (num>=4)
								{
									cout<<"IV";
									num=num-4;
								}
								if (num>=3)
								{
									cout<<"III"<<endl;
									num=num-3;
								}
								if (num>=2)
								{
									cout<<"II"<<endl;
									num=num-2;
								
								}
									if (num>=1)
								{ 
									cout<<"I"<<endl;
									num=num-1;
								}
						}
					else
					  	cout<<"Invalid!"<<endl;
		break;//end of first choice
		//second choice - military to 12-hour clock
		case 2: cout<<"====================================="<<endl
					<<endl
					<<"Military to 12-Hour Clock Conversion"<<endl
					<<endl
					<<"====================================="<<endl
					<<endl
					<<"Enter military time: ";
			  		cin>>time;
					  		//process of converting military time to 12-hour time 
					  		if(time>=0&&time<=2400)//time must be from 0 to 2400 only
					  			    {
					  					//extract hours and minutes
									  	hours=time/100;
									  	minutes=time%100;
									  	
									  	if(hours==0 || hours==24) //for hours 00 and 24
									  		{
											  hours=12;
												if(minutes>=0&&minutes<=59)
											  	{
												  	if(minutes<=9)
											  			cout<<"Time in 12 hour clock: "<<hours<<":0"<<minutes<<" A.M."<<endl;
											  		else
											  			cout<<"Time in 12 hour clock: "<<hours<<":"<<minutes<<" A.M."<<endl;
											  	}
											  	else
											  		cout<<"Invalid!"<<endl;
										    }
									  	else if(hours>0&&hours<12) //for hours 1 to 11
									  		{
									  			hours=hours;
									  				if(minutes>=0&&minutes<=59)
									  				{
									  					if(minutes<=9)
											  				cout<<"Time in 12 hour clock: "<<hours<<":0"<<minutes<<" A.M."<<endl;
											  			else
									  						cout<<"Time in 12 hour clock: "<<hours<<":"<<minutes<<" A.M."<<endl;
									  				}
									  				else
									  					cout<<"Invalid!"<<endl;
									  	    }
									  	else if(hours==12) //for hour 12
									  		{	
											  	hours=12;
											  		if(minutes>=0&&minutes<=59)
											  		{	  
											  			if(minutes<=9)
											  				cout<<"Time in 12 hour clock: "<<hours<<":0"<<minutes<<" P.M."<<endl;
									  					else
												  			cout<<"Time in 12 hour clock: "<<hours<<":"<<minutes<<" P.M."<<endl;
												  	}
												  	else
												  		cout<<"Invalid!"<<endl;
									  	    }
									  	else if(hours>12 && hours<24) //for hours 13 to 23
									  		{
									  			hours=hours-12;
									  				if(minutes>=0&&minutes<=59)
									  				{	  
									  					if(minutes<=9)
											  				cout<<"Time in 12 hour clock: "<<hours<<":0"<<minutes<<" P.M."<<endl;
									  					else
												  			cout<<"Time in 12 hour clock: "<<hours<<":"<<minutes<<" P.M."<<endl;
												  	}
												  	else
												  		cout<<"Invalid!"<<endl;
									  	    }
									  	else
									  		cout<<"Invalid!"<<endl;
									}
							else
								cout<<"Invalid!"<<endl;
		break;//end of second choice
		//third choice - exit 
		case 3: cout<<endl
					<<"Goodbye!"<<endl;
				exit(0);
		break;//end of third choice
		default: cout<<"Choice is invalid!"<<endl;//error handler
	}
}
