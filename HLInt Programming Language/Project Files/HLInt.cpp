#include <iostream>
#include <fstream>
#include <regex>
#include <vector>
#include <algorithm>
#include <string>
#include <unordered_map>
#include <cstdlib>
using namespace std;

void removeWhitespace(const std::string& inputFileName, const std::string& outputFileName){
    std::ifstream input(inputFileName);
    std::ofstream output(outputFileName);

    if (!input.is_open()){
        std:cerr << "ERROR opening file."<<std::endl;
        return;
    }
    
    char ch;
    while (input.get(ch)){
        if(!std::isspace(ch)){
            output<<ch;
        }
    }
    input.close();
    output.close();

    //std::cout<<"Whitespace removed."<<std::endl;
}

enum TokenType {
    IDENTIFIER, // variable names
    KEYWORD,    // if integer double
    INT_VALUE,
    DOUBLE_VALUE,    
    OPERATOR,   // + - < > == !=
    DELIMITER,  // ( ) ; :
    UNKNOWN
};

struct Token {
    string value;
    TokenType type;
    size_t position;
};

vector<Token> tokens;
int line = 0;
int totalChecks = 0;
int checker1 = 0;
int checker2 = 0;
int checker3 = 0;
int checker4 = 0;
int checker5 = 0;
int checker6 = 0;
int initialTokenIndex = 0;
int size;
std::string file;
std::string outputValue;


double lhsValue = 0.0;
double rhsValue = 0.0;

bool conditionMet = false;

std::string getTokenTypeName(TokenType type) {
    switch (type) {
        case TokenType::KEYWORD:
            return "KEYWORD";
        case TokenType::IDENTIFIER:
            return "IDENTIFIER";
        case TokenType::INT_VALUE:
            return "INT_VALUE";
        case TokenType::DOUBLE_VALUE:
            return "DOUBLE_VALUE";
        case TokenType::DELIMITER:
            return "DELIMITER";
        case TokenType::OPERATOR:
            return "OPERATOR";
        case TokenType::UNKNOWN:
            return "UNKNOWN";
        // Add more cases for other token types if needed
        default:
            return "INVALID"; // Handle unknown or invalid types
    }
}

void tokenizeAndProcess(std::string inputFileName, std::string outputFileName) {
    std::regex keyword_regex("\\b(if|integer|double|output)\\b");
    std::regex identifier_regex("[a-zA-Z_][a-zA-Z0-9_]*");
    std::regex int_regex("\\b\\d(?!\\d|\\.)\\b");
    std::regex double_regex("\\d\\.\\d{2}");
    std::regex operator_regex("==|!=|<=|>=|<<|[=+<>-]");
    std::regex delimiter_regex("[()\\:;]");

    std::ifstream inputFile(inputFileName);
    std::ofstream outputFile(outputFileName);
    std::string line;

    while (std::getline(inputFile, line)) {
        

        // Tokenize the line
        std::sregex_iterator it(line.begin(), line.end(), keyword_regex);
        std::sregex_iterator end;

        while (it != end) {
            Token token{it->str(), KEYWORD, static_cast<size_t>(it->position())};
            tokens.push_back(token);
            ++it;
        }

        it = std::sregex_iterator(line.begin(), line.end(), int_regex);
        while (it != end) {
            Token token{it->str(), INT_VALUE, static_cast<size_t>(it->position())};
            tokens.push_back(token);
            ++it;
        }

        it = std::sregex_iterator(line.begin(), line.end(), double_regex);
        while (it != end) {
            Token token{it->str(), DOUBLE_VALUE, static_cast<size_t>(it->position())};
            tokens.push_back(token);
            ++it;
        }

        it = std::sregex_iterator(line.begin(), line.end(), operator_regex);
        while (it != end) {
            Token token{it->str(), OPERATOR, static_cast<size_t>(it->position())};
            tokens.push_back(token);
            ++it;
        }

        it = std::sregex_iterator(line.begin(), line.end(), identifier_regex);
        while (it != end) {
        std::string token_str = it->str();
    
        // Check if the token is "integer," "if," or "double" and skip it if it is
        if (token_str != "integer" && token_str != "if" && token_str != "double" && token_str != "output") {
            Token token{token_str, IDENTIFIER, static_cast<size_t>(it->position())};
            tokens.push_back(token);
        }
    
        ++it;
        }

        it = std::sregex_iterator(line.begin(), line.end(), delimiter_regex);
        while (it != end) {
            Token token{it->str(), DELIMITER, static_cast<size_t>(it->position())};
            tokens.push_back(token);
            ++it;
        }

        // Sort the tokens based on their positions in the input line
        sort(tokens.begin(), tokens.end(), [](const Token& a, const Token& b) {
            return a.position < b.position;
        });

        // Output the sorted tokens
        for (const Token& token : tokens) {
            switch (token.type) {
                case KEYWORD:
                    outputFile << "Keyword: " << token.value << std::endl;
                    break;
                case INT_VALUE:
                    outputFile << "Int: " << token.value << std::endl;
                    break;
                case DOUBLE_VALUE:
                    outputFile << "Double: " << token.value << std::endl;
                    break;
                case OPERATOR:
                    outputFile << "Operator: " << token.value << std::endl;
                    break;
                case IDENTIFIER:
                    outputFile << "Identifier: " << token.value << std::endl;
                    break;
                case DELIMITER:
                    outputFile << "Delimiter: " << token.value << std::endl;
                    break;
                default:
                    break;
            }
        }
    }

    

    inputFile.close();
    outputFile.close();
    /*std::cout << "Lexer complete. \n" << std::endl;
    std::cout<<"--------------LEXEMES-------------"<<std::endl;
    for (const Token& token : tokens){
    std::cout << "\nValue: " << token.value << "\nType: " << getTokenTypeName(token.type) << std::endl;
    }*/	
}

/////////////////////// PARSER/////////////////////


// Function to get the next token
Token getNextToken(std::vector<Token>& tokens, size_t& currentTokenIndex) {
    if (currentTokenIndex < tokens.size()) {
        return tokens[currentTokenIndex++];
    } else {
        // Return an EOF token or handle errors as needed
        return {"", TokenType::UNKNOWN};
    }
}

enum class DataType { INTEGER, DOUBLE };
struct Variable {
    DataType type;
    std::string name;
    double value;  // Use double for both integers and doubles
};

std::vector<Variable> variables;  // Store declared variables


// Function to parse a variable declaration
bool parseVariableDeclaration(std::vector<Token>& tokens, size_t& currentTokenIndex) {
    // Parse the variable name
    Token varName = getNextToken(tokens, currentTokenIndex);

    if (varName.type == TokenType::IDENTIFIER) {
        // Check for the ':' delimiter
        Token colon = getNextToken(tokens, currentTokenIndex);
        //std::cout<<"Variable Declaration Identifier Parsed"<<std::endl;
        checker1 ++;

        if (colon.type == TokenType::DELIMITER && colon.value == ":") {
            // Check for the data type (integer or double)
            Token dataType = getNextToken(tokens, currentTokenIndex);
            //std::cout<<"Variable Declaration Colon Parsed"<<std::endl;
            checker1 ++;

            if (dataType.type == TokenType::KEYWORD && (dataType.value == "integer" || dataType.value == "double")) {
                // Check for the ';' delimiter
                Token semicolon = getNextToken(tokens, currentTokenIndex);
                //std::cout<<"Variable Declaration Integer/Double Parsed"<<std::endl;
                checker1 ++;

                if (semicolon.type == TokenType::DELIMITER && semicolon.value == ";") {
                	//std::cout<<"Variable Declaration Semicolon Parsed"<<std::endl;
                	Variable newVariable;
                    newVariable.name = varName.value;
                    newVariable.type = (dataType.value == "integer") ? DataType::INTEGER : DataType::DOUBLE;
                    variables.push_back(newVariable);
                	checker1 ++;                	
                }
            }
        }
    }
    
    if (checker1 == 4){
    	initialTokenIndex = currentTokenIndex;    	
    	return true;
	}else{
		currentTokenIndex =  initialTokenIndex;
		//std::cout<<"ERROR PARSING VARIABLE DECLARATION \n"<<std::endl;
		checker1 = 0;
		return false;
	}
	
	//return false;
}


// Function to parse an assignment statement
bool parseAssignment(std::vector<Token>& tokens, size_t& currentTokenIndex) {
    // Parse the variable name
    Token varName = getNextToken(tokens, currentTokenIndex);

    if (varName.type == TokenType::IDENTIFIER) {
        // Check for the ':=' delimiter
        Token colonDel = getNextToken(tokens, currentTokenIndex);
        //std::cout<<"Assignment Identifier Parsed"<<std::endl;
        checker2 ++;

        if (colonDel.type == TokenType::DELIMITER && colonDel.value == ":") {
        	// Parse the '=' operator
            Token equalOp = getNextToken(tokens, currentTokenIndex);
            //std::cout<<"Assignment Colon Parsed"<<std::endl;
            checker2 ++;
            
            if (equalOp.type == TokenType::OPERATOR && equalOp.value == "=") {
            
            	// Parse the expression (integer or double)
            	Token expression = getNextToken(tokens, currentTokenIndex);
            	//std::cout<<"Assignment Equal Parsed"<<std::endl;
            	checker2 ++;

	            if (expression.type == TokenType::INT_VALUE || expression.type == TokenType::DOUBLE_VALUE) {
	                // Check for the ';' delimiter
	                Token semicolon = getNextToken(tokens, currentTokenIndex);
	                //std::cout<<"Assignment Integer/Double Parsed"<<std::endl;
	                checker2 ++;
	
	                if (semicolon.type == TokenType::DELIMITER && semicolon.value == ";") {
	                    // Successfully parsed an assignment statement
	                    //std::cout<<"Assignment SemiColon Parsed"<<std::endl;
	                    // Search for the variable in the list of declared variables
	                    for (Variable& variable : variables) {
	                        if (variable.name == varName.value) {
	                            if (expression.type == TokenType::INT_VALUE) {
	                                if (variable.type == DataType::INTEGER) {
	                                    variable.value = std::stoi(expression.value);
	                                } else if (variable.type == DataType::DOUBLE) {
	                                    // You can convert int to double
	                                    std::cout<<"INCORRECT DATATYPE"<<std::endl;
	                                    break;
	                                }
	                            } else if (expression.type == TokenType::DOUBLE_VALUE) {
	                                if (variable.type == DataType::INTEGER) {
	                                    std::cout<<"INCORRECT DATATYPE"<<std::endl;
	                                    break;
	                                } else if (variable.type == DataType::DOUBLE) {
	                                    variable.value = std::stod(expression.value);
	                                }
	                            }
	
	                        }
	                    }
	                    checker2 ++;
						} 
					}
				}
			}	
        }

    if (checker2 == 5){
    	initialTokenIndex = currentTokenIndex;
    	return true;
	}else{
		currentTokenIndex =  initialTokenIndex;
		//std::cout<<"ERROR PARSING ASSIGNMENT \n"<<std::endl;
		checker2 = 0;
		return false;
	}
}
	//return false;
	


// Function to parse a print statement
bool parsePrint(std::vector<Token>& tokens, size_t& currentTokenIndex) {
    // Check for the "output" keyword
    Token outputKeyword = getNextToken(tokens, currentTokenIndex);
    

    if (outputKeyword.type == TokenType::KEYWORD && outputKeyword.value == "output") {
        // Check for the "<<" operator
        Token outputOperator = getNextToken(tokens, currentTokenIndex);
        //std::cout<<"Print Output Parsed"<<std::endl;
        checker3 ++;

        if (outputOperator.type == TokenType::OPERATOR && outputOperator.value == "<<") {
            // Parse the expression (which can be a string or a variable)
            Token expression = getNextToken(tokens, currentTokenIndex);
            //std::cout<<"Print << Parsed"<<std::endl;
            checker3 ++;

            if (expression.type == TokenType::DOUBLE_VALUE || expression.type == TokenType::INT_VALUE || expression.type == TokenType::IDENTIFIER) {
                // Check for the ';' delimiter
                Token semicolon = getNextToken(tokens, currentTokenIndex);
                //std::cout<<"Print Value Parsed"<<std::endl;
                checker3 ++;

                if (semicolon.type == TokenType::DELIMITER && semicolon.value == ";") {
                    // Successfully parsed a print statement
                    //std::cout<<"Print Semicolon Parsed"<<std::endl;
                    checker3 ++;          
					
					if (expression.type == TokenType::DOUBLE_VALUE || expression.type == TokenType::INT_VALUE) {
                    // Print integer or double value
                    std::cout << expression.value<<std::endl;
                		} else if (expression.type == TokenType::IDENTIFIER) {
                    // Find the variable by name and print its value
                    	for (const Variable& variable : variables) {
                        if (variable.name == expression.value) {
                            std::cout << variable.value<<std::endl;
                            //outputValue = variable.value;
                            break;
                       		 }
                   		 }
               			 }         
                	}
            	}
			}
        }
    

    if (checker3 == 4){
    	initialTokenIndex = currentTokenIndex;
    	return true;
	}else{
		currentTokenIndex =  initialTokenIndex;
		//std::cout<<"ERROR PARSING PRINT \n"<<std::endl;
		checker3 = 0;
		return false;
		
	}
}
		
		

	
// Function to parse an if statement
bool parseIf(std::vector<Token>& tokens, size_t& currentTokenIndex) {
    // Check for the "if" keyword
    Token ifKeyword = getNextToken(tokens, currentTokenIndex);

    if (ifKeyword.type == TokenType::KEYWORD && ifKeyword.value == "if") {
        // Check for the opening parenthesis '('
        Token openParenthesis = getNextToken(tokens, currentTokenIndex);
        //std::cout<<"If if Parsed"<<std::endl;
        checker4 ++;

        if (openParenthesis.type == TokenType::DELIMITER && openParenthesis.value == "(") {
            // Parse the condition
            Token lhsToken = getNextToken(tokens, currentTokenIndex);
            //std::cout<<"If open paren Parsed"<<std::endl;
            checker4 ++;

            if (lhsToken.type == TokenType::IDENTIFIER || lhsToken.type == TokenType::INT_VALUE || lhsToken.type == TokenType::DOUBLE_VALUE) {
                Token comparisonOperator = getNextToken(tokens, currentTokenIndex);
                //std::cout<<"If first operand Parsed"<<std::endl;
                checker4 ++;
					if(lhsToken.type == TokenType:: IDENTIFIER){
					    for (const Variable& variable : variables) {
		                    if (variable.name == lhsToken.value) {
					        	lhsValue = variable.value;
					        	break;
					        }
					    }
						}else{
							lhsValue = std::stod(lhsToken.value);
						}

                if (comparisonOperator.type == TokenType::OPERATOR &&
                    (comparisonOperator.value == ">" || comparisonOperator.value == "<" ||
                     comparisonOperator.value == "==" || comparisonOperator.value == "!=")) {
                    // Parse the right-hand value for the comparison (which can be an identifier)
                    Token rhsToken = getNextToken(tokens, currentTokenIndex);
                    //std::cout<<"If operator Parsed"<<std::endl;
                    checker4 ++;
                    
                    	if (rhsToken.type == TokenType::IDENTIFIER || rhsToken.type == TokenType::INT_VALUE || rhsToken.type == TokenType::DOUBLE_VALUE) {
                    	Token closeParenthesis = getNextToken(tokens, currentTokenIndex);
                		//std::cout<<"If second operand Parsed"<<std::endl;
                		checker4 ++;
                		if(rhsToken.type == TokenType:: IDENTIFIER){
					    for (const Variable& variable : variables) {
		                    if (variable.name == rhsToken.value) {
					        	rhsValue = variable.value;
					        	break;
					        }
					    }
						}else{
							rhsValue = std::stod(rhsToken.value);
						}
                			
                			if (closeParenthesis.type == TokenType::DELIMITER && closeParenthesis.value == ")") {
            				// Parse the condition
            				//std::cout<<"If close paren Parsed"<<std::endl;
            				checker4 ++;
            				
            				
            				if (comparisonOperator.value == "<") {
            					conditionMet = lhsValue < rhsValue;
			                // Compare for greater than
			            		} else if (comparisonOperator.value == ">"){
			            			conditionMet = lhsValue > rhsValue;
								} else if (comparisonOperator.value == "=="){
									conditionMet = lhsValue == rhsValue;
								} else if (comparisonOperator.value == "!="){
									conditionMet = lhsValue != rhsValue;
								}
							if (conditionMet == false){
							while(true){
								Token stop = getNextToken(tokens, currentTokenIndex);
								size -= 1;
								if (stop.value == ";"){
									break;
							}
							}
							}
                        }
                    }
                }
            }
        }
    }
    

    if (checker4 == 6){
    	initialTokenIndex = currentTokenIndex;
    	return true;
	}else{
		currentTokenIndex =  initialTokenIndex;
		//std::cout<<"ERROR PARSING IF \n"<<std::endl;
		checker4 = 0;
		return false;
	}
	}
	//return false;
	
// Function to parse mathematical operations
bool parseMathOp(std::vector<Token>& tokens, size_t& currentTokenIndex) {
    // Check for the integer or double
    Token varName = getNextToken(tokens, currentTokenIndex);
    
    if (varName.type == TokenType::IDENTIFIER) {
        // Check for equals
        Token equals = getNextToken(tokens, currentTokenIndex);
        //std::cout<<"Print first num parsed"<<std::endl;
        checker5 ++;
        
        if (equals.type == TokenType::OPERATOR && equals.value == "=") {
        double result = 0.0;
        // Check for equals
        Token num = getNextToken(tokens, currentTokenIndex);
        //std::cout<<"Print first num parsed"<<std::endl;
        checker5 ++;
        
		    if (num.type == TokenType::INT_VALUE || num.type == TokenType::DOUBLE_VALUE || num.type == TokenType::IDENTIFIER) {
		    	if (num.type == TokenType::INT_VALUE) {
                	result = std::stod(num.value);
            		} else if (num.type == TokenType::DOUBLE_VALUE) {
                		result = std::stod(num.value);
            		} else if (num.type == TokenType::IDENTIFIER) {
                // Find the variable by name and use its value
               	 	for (const Variable& variable : variables) {
                    if (variable.name == num.value) {
                        result = variable.value;
                        break;
                    }
                }
            	}
		        // Check for operator
		        Token mathOp = getNextToken(tokens, currentTokenIndex);
		        //std::cout<<"Print first num parsed"<<std::endl;
		        checker5 ++;
		        
		        if (mathOp.type == TokenType::OPERATOR && (mathOp.value == "+" || mathOp.value == "-")) {
		            // Check next integer or double
		            Token num2 = getNextToken(tokens, currentTokenIndex);
		            //std::cout<<"Print math operator parsed"<<std::endl;
		            checker5 ++;
		
				    if (num2.type == TokenType::INT_VALUE || num2.type == TokenType::DOUBLE_VALUE || num.type == TokenType::IDENTIFIER) {
				        // Check for semicolon
				        Token finalColon = getNextToken(tokens, currentTokenIndex);
				        //std::cout<<"Print second num parsed"<<std::endl;
				        checker5 ++;
				         if (num2.type == TokenType::INT_VALUE) {
                    double num2Value = std::stod(num2.value);

                    if (mathOp.value == "+") {
                        result += num2Value;
                    } else {
                        result -= num2Value;
                    }
                } else if (num2.type == TokenType::DOUBLE_VALUE) {
                    double num2Value = std::stod(num2.value);

                    if (mathOp.value == "+") {
                        result += num2Value;
                    } else {
                        result -= num2Value;
                    }
                } else if (num2.type == TokenType::IDENTIFIER) {
                    // Find the variable by name and use its value
                    for (const Variable& variable : variables) {
                        if (variable.name == num2.value) {
                            if (mathOp.value == "+") {
                                result += variable.value;
                            } else {
                                result -= variable.value;
                            }
                            break;
                        }
                    }
                }
                // Assign the result back to the variable
            for (Variable& variable : variables) {
                if (variable.name == varName.value) {
                    variable.value = result;
                    break;
                }
            }
		
		                if (finalColon.type == TokenType::DELIMITER && finalColon.value == ";") {
		                    // Successfully parsed a print statement
		                    //std::cout<<"Print Semicolon Parsed"<<std::endl;
		                    checker5 ++;   
								}
		        	        }
		    	        }                   
			
		        	}
		    	}
		    }
    

   if (checker5 == 6){
    	initialTokenIndex = currentTokenIndex;
    	return true;
	}else{
		currentTokenIndex =  initialTokenIndex;
		//std::cout<<"ERROR PARSING MATH \n"<<std::endl;
		checker5 = 0;
		return false;
	}
}
	
	
bool parsePrint2(std::vector<Token>& tokens, size_t& currentTokenIndex) {
    // Check for the "output" keyword
    Token outputKeyword = getNextToken(tokens, currentTokenIndex);
    

    if (outputKeyword.type == TokenType::KEYWORD && outputKeyword.value == "output") {
        // Check for the "<<" operator
        Token outputOperator = getNextToken(tokens, currentTokenIndex);
        //std::cout<<"Print2 Output Parsed"<<std::endl;
        checker6 ++;

        if (outputOperator.type == TokenType::OPERATOR && outputOperator.value == "<<") {
            // Parse the expression 
            Token operand1 = getNextToken(tokens, currentTokenIndex);
            //std::cout<<"Print2 << Parsed"<<std::endl;
            checker6 ++;

            if (operand1.type == TokenType::IDENTIFIER || operand1.type == TokenType::INT_VALUE || operand1.type == TokenType::DOUBLE_VALUE) {
            	double result = 0;
                // Parse the expression 
            	Token operator1 = getNextToken(tokens, currentTokenIndex);
            	//std::cout<<"Print2 operand1 Parsed"<<std::endl;
            	checker6 ++;
            	
            		if (operator1.type == TokenType::OPERATOR && (operator1.value == "+" || operator1.value == "-")) {
                	// Parse the expression 
            		Token operand2 = getNextToken(tokens, currentTokenIndex);
            		//std::cout<<"Print2 operator1 Parsed"<<std::endl;
            		checker6 ++;
            		
	            		if (operand2.type == TokenType::IDENTIFIER || operand2.type == TokenType::INT_VALUE || operand2.type == TokenType::DOUBLE_VALUE) {
	            			double value1 = 0;
                    		double value2 = 0;
                    		
                    		
	                	// Parse the expression 
	            		Token semicolon = getNextToken(tokens, currentTokenIndex);
	            		//std::cout<<"Print2 operand2 Parsed"<<std::endl;
	            		checker6 ++;
	            		
	            			if (semicolon.type == TokenType::DELIMITER && semicolon.value == ";") {
	            			//std::cout<<"Print2 Semicolon Parsed"<<std::endl;
	            			checker6 ++;
	            			}
	            	if (operand1.type == TokenType::IDENTIFIER) {
                        // Get the value of the variable
                        for (const Variable& variable : variables) {
                        if (variable.name == operand1.value) {
                            value1 = variable.value;
                            break;
                        }
                    }
                    } else if (operand1.type == TokenType::INT_VALUE) {
                        value1 = std::stoi(operand1.value);
                    } else if (operand1.type == TokenType::DOUBLE_VALUE) {
                        value1 = std::stod(operand1.value);
                    }

                    if (operand2.type == TokenType::IDENTIFIER) {
                        // Get the value of the variable
                        for (const Variable& variable : variables) {
                        if (variable.name == operand2.value) {
                            value2 = variable.value;
                            break;
                        }
                    }
                    } else if (operand2.type == TokenType::INT_VALUE) {
                        value2 = std::stoi(operand2.value);
                    } else if (operand2.type == TokenType::DOUBLE_VALUE) {
                        value2 = std::stod(operand2.value);
                    }

                    if (operator1.value == "+") {
                        result = value1 + value2;
                    } else if (operator1.value == "-") {
                        result = value1 - value2;
                    }
                    std::cout << result << endl;
                    //outputValue = std::to_string(result);
            			}
            		}
            	}
			}
        }
    

    if (checker6 == 6){
    	initialTokenIndex = currentTokenIndex;
    	return true;
	}else{
		currentTokenIndex =  initialTokenIndex;
		//std::cout<<"ERROR PARSING PRINT \n"<<std::endl;
		checker6 = 0;
		return false;
	}
	}
	//return false;
	



	
// Main parsing function
bool parse(std::vector<Token>& tokens) {
    size_t currentTokenIndex = 0;  // Initialize the current token index
    int latestTokenIndex = 0;
	
	//std::cout<<"\n-----------PARSER----------\n"<<std::endl;
	
    while (currentTokenIndex < tokens.size()) {
        // Implement the main parsing logic here
        // You can check for variable declarations, assignments, print statements, if statements, etc.

        // Attempt to parse different statement types in the order of preference

        if(parseVariableDeclaration(tokens, currentTokenIndex)){
        	//line++;
        	//std::cout<<"Line: "<<line<<" VARIABLE DECLARATION PARSED \n"<<std::endl;
        	totalChecks += checker1;
        	checker1 = 0;
		} else if(parseAssignment(tokens, currentTokenIndex)){	
			//line++;
			//std::cout<<"Line: "<<line<<" ASSIGNMENT PARSED \n"<<std::endl;
			totalChecks += checker2;
        	checker2 = 0;
		} else if (parsePrint(tokens, currentTokenIndex)){
			//line++;
			//std::cout<<"Line: "<<line<<" PRINT PARSED \n"<<std::endl;
			totalChecks += checker3;
        	checker3 = 0;
		} else if (parseIf(tokens, currentTokenIndex)){
			//line++;
			/*if(conditionMet){
				std::cout<<"Condition True"<<std::endl;
			}else{
				std::cout<<"Condition False"<<std::endl;
			}*/
			//std::cout<<"Line: "<<line<<" IF PARSED \n"<<std::endl;
			totalChecks += checker4;
        	checker4 = 0;
		} else if (parseMathOp(tokens, currentTokenIndex)){
			//line++;
			//std::cout<<"Line: "<<line<<" MATH PARSED \n"<<std::endl;
			totalChecks += checker5;
        	checker5 = 0;
        } else if (parsePrint2(tokens, currentTokenIndex)){
        	//line++;
			//std::cout<<"Line: "<<line<<" PRINT2 PARSED \n"<<std::endl;
			totalChecks += checker6;
        	checker6 = 0;
        	checker5 = 0;
		}else{
			//std::cout<<"ERROR"<<std::endl;
			break;
		}
	}
    
	//std::cout<<"\n"<<totalChecks<<std::endl;
	//std::cout<<size<<std::endl;
    checker1 = 0;
    checker2 = 0;
    checker3 = 0;
    checker4 = 0;
    checker5 = 0;
    checker6 = 0;
    line = 0;
    
    
    if(totalChecks == size){
    	return true;
    } else {
    	return false;
	}
	}

int main() {
	std::cout<<"Enter filename of program (PROG1.HL/PROG2.HL/PROG3.HL): ";
	std::cin>>file;
	removeWhitespace(file, "NOSPACES.txt");
	                      
	tokenizeAndProcess("NOSPACES.txt", "RES_SYM.txt");
	size = tokens.size();
	std::cout<<"\n-------------OUTPUT-------------\n"<<std::endl;
	bool parsingResult = parse(tokens);
	
    if (parsingResult) {
        std::cout <<"\n\n--------------------------------\n\nNO ERROR(S)." << std::endl;
        totalChecks = 0;
    } else {
    	system("cls");
        std::cout <<"\n--------------------------------\n\nERROR" <<std::endl;
        totalChecks = 0;
    }                                               
    return 0;
}