package test;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class testLogin {
	@Test
	public void testValidEmail() {
		Authentication validator = new Authentication();
        Assert.assertTrue("This is a valid mail",validator.isValidEmail("simran292002@gmail.com"));
        Assert.assertTrue("This is a valid mail",validator.isValidEmail("simran@gmail.com"));
	}
	@Test
	public void testInvalidEmail() {
		Authentication validator = new Authentication();
        Assert.assertFalse("This is an invalid mail", validator.isValidEmail("simran"));
        Assert.assertFalse("This is an invalid mail",validator.isValidEmail("simran 292002@gmail.com"));
        Assert.assertFalse("This is an invalid mail",validator.isValidEmail("simran@@gmail.com"));
	}
	@Test
	public void testValidPassword() {
		Authentication validator = new Authentication();
        Assert.assertTrue("This is a valid password",validator.isValidPassword("12345678"));
	}
	@Test
	public void testInvalidPassword() {
		Authentication validator = new Authentication();
        Assert.assertFalse("This is a invalid password", validator.isValidPassword("simran"));
	}
	@Test
	public void registerOnValidPassword() {
		Authentication validator = new Authentication();
		Assert.assertTrue("",validator.registerOnValidPassword("12345678","12345678"));
	}
	@Test
	public void registerOnInvalidPassword() {
		Authentication validator = new Authentication();
		Assert.assertFalse("",validator.registerOnValidPassword("1234","12345678"));
	}
	@Test
	public void loginOnValidCredentials() {
		Authentication validator = new Authentication();
		Assert.assertTrue("12345678 Valid credentials",validator.loginOnValidCredentials("simran292002@gmail.com","12345678"));
	}
	@Test
	public void loginFailOnInvalidCredentials() {
		Authentication validator = new Authentication();
		Assert.assertFalse("12345678 Invalid credentials",validator.loginOnValidCredentials("simran292002@gmail.com","12345"));
	}
	@Test
	public void sendEmailTest() {
		Authentication validator = new Authentication();
		String email="test@test.com";
		String subject="Test Subject";
		String body="Test Body";
		Assert.assertTrue("Email sent successfully",validator.sendEmail(email,subject,body));
		Assert.assertFalse("Could not send the email.Kindly fill the details correctly",validator.sendEmail("","",body));
	}
	@Test
	public void userAlreadyPresentTest() {
		Authentication validator = new Authentication();
		Assert.assertTrue("",validator.alreadyPresentUser("simran292002@gmail.com"));
		Assert.assertFalse("",validator.alreadyPresentUser("simran@gmail.com"));
	}
	@Test
	public void sendEmailOnValidEmail() {
		Authentication validator = new Authentication();
		Assert.assertTrue("",validator.alreadyPresentUser("simran292002@gmail.com"));
		Assert.assertFalse("",validator.alreadyPresentUser("simran@gmail.com"));
	}
	
	
}
