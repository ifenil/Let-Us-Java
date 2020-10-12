import java.util.Scanner;

class PasswordException extends Exception{
	void Message(){
		System.out.println("The password should be atleast 5 characters long and atmost 12 characters long");
		System.out.println("The password should contain at least one capital letter,one small letter"+"\n"+"one numeric value and one special character");
	}
}

public class Password{
String password;

	Password(String password){
		this.password=password;
	}

void PasswordValidation() throws PasswordException{
String alphabetsLower="";
String alphabetsUpper="";
String numbers="";
String specialCharacters="";
if(password.length()>=5 && password.length()<=12){
for(char a:password.toCharArray()){
	if(a>=65 && a<=90){
		alphabetsUpper+=Character.toString(a);
	}
	else if(a>=97 && a<=122){
		alphabetsLower+=Character.toString(a);
	}
	else if(a>=48 && a<=57){
		numbers+=Character.toString(a);
	}
	else{
		specialCharacters+=Character.toString(a);
	}
}
if((alphabetsLower.length()==0) || (alphabetsUpper.length()==0) || (numbers.length()==0) || (specialCharacters.length()==0)){
	throw new PasswordException();
}
else{
	System.out.println("You have entered a valid password");
}
}
else{
	throw new PasswordException();
}
}

public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a password");
		String pass = s.nextLine();
		Password p = new Password(pass);
		try{
			p.PasswordValidation();
		}
		catch(PasswordException e){
			e.Message();
			e.printStackTrace();
		}
	}	
}