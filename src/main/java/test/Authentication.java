package test;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authentication implements EmailService1 {
	
	HashMap<String, String> mp = new HashMap<>();
	
	public boolean sendEmail(String to,String subject,String body) {
		if(to!="" && subject!="" && body!="") {
		System.out.println("Email sent successfully") ;
		return true;
		}
		else {
			System.out.println("Could not send the email.Kindly fill the details correctly");
		}
		return false;
	}
	
	public boolean alreadyPresentUser(String email) {
		mp.put("simran292002@gmail.com","12345678");
		if(mp.containsKey(email)) {
			return true;
		}
		return false;
	}
	public boolean loginOnValidCredentials(String email,String password) {
		mp.put("simran292002@gmail.com","12345678");
		if(password.equals(mp.get(email))){
			System.out.println(mp.get(email)+" Valid creadentials");
			return true;
		}
		else {
			System.out.println(mp.get(email)+" Invalid credentials");
			return false;
		}
	}
	public void login() {
		System.out.println("Enter an email address");
		Scanner s=new Scanner(System.in);
		String email=s.nextLine();
		if(!alreadyPresentUser(email)) {
			System.out.println("Kindly register first, this email address is not registered");
			start();
		}
		else {
			System.out.println("Choose a option");
			System.out.println("1. Password");
			System.out.println("2. ForgotPassword");
			int choice=s.nextInt();
			if(choice==1)
			{
				Scanner t=new Scanner(System.in);
				System.out.println("Enter your password");
				String password=t.nextLine();
				if(loginOnValidCredentials(email,password)) {
					System.out.println("Successfully logged into the system");
				}
				else {
					System.out.println("Could not log in due to invalid credentials");
					login();
				}
			}
			else if(choice==2) {
				forgotPassword();
			}
		}
		start();
	}
	public boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
		Pattern pat = Pattern.compile(emailRegex); 
			if (email == null) 
				return false; 
		if(pat.matcher(email).matches()) {
			System.out.println("This is a valid mail");
			return true;
		}
		else {
			System.out.println("This is an invalid mail");
		}
		return false; 
	}
	public boolean isValidPassword(String password) {
		if(password.length()<8) {
			System.out.println("This is an invalid password");
			return false;
		}
		else {
			System.out.println("This is a valid password");
		}
		return true;
	}
	public void forgotPassword() {
		System.out.println("Enter your email");
		Scanner s=new Scanner(System.in);
		String email=s.nextLine();
		if(!alreadyPresentUser(email)) {
			System.out.println("The user is not registered. Kindly register first");
			start();
		}
		if(isValidEmail(email)) {
			sendEmail(email,"Forgot Password: New credentials","You new password is <12345678>. Kindly register the next time with this password. Email sent successfully.");
			mp.put(email, "12345678");
		}
	}
	public boolean registerOnValidPassword(String password,String confirmPassword) {
		if(!password.equals(confirmPassword)) {
			return false;
		}
		else {
			return true;
		}
	}
	public void register() {
		System.out.println("Enter your email");
		Scanner s=new Scanner(System.in);
		String email=s.nextLine();
		if(!isValidEmail(email))
		{
			System.out.println("The email is invalid");
		}
		else 
		if(mp.containsKey(email)){
			System.out.println("Already registered");
			start();
		}
		else {
			System.out.println("Enter a password");
			String password=s.nextLine();
			if(!isValidPassword(password)) {
				System.out.println("Please enter a password of minimum length 8. Kindly register again");
				start();
			}
			System.out.println("Confirm password");
			String confirmPassword=s.nextLine();
			if(registerOnValidPassword(password,confirmPassword))
			{
				System.out.println("registered successfully");
				mp.put(email, password);
			}
			else {
				System.out.println("Passwords don't match");
			}
			
		}
		start();
	}
	public void start() {
		System.out.println("Choose a valid opertaion by selecting an option");
		System.out.println("1. Register");
		System.out.println("2. Login");
		Scanner s=new Scanner(System.in);
		int input=s.nextInt();
		if(input==1) {
			register();
		}
		else if(input==2) {
			login();
		}
		else
		{
			start();
		}
	}
	public static void main(String[] args) {
		Authentication a=new Authentication();
		a.start();
	}
}