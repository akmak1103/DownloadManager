package src.validator;
import src.exception.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Java program to validate an url in Java
class ValidateUrl
{
	public static boolean urlValidator(String url)
	{
		try {
			new URL(url).toURI();
			emptyUrlName(url);
			missingDot(url);
			urlFormat(url);
			specialCharacter(url);
		}
		catch (URISyntaxException exception e) {    // if URL cannot be converted into URI
			System.out.println(e);			
			return false;
		}
		catch (MalformedURLException exception e) {      // if protocol or address given in the url is incorrect
			System.out.println(e);				
			return false;
		}
		catch (EmptyUrlNameException exception e) {     
				System.out.println(e);	
				return false;
		}
		catch (MissingExtensionException exception e) {      
				
			System.out.println(e);	
			return false;
		}
		catch (SpecialCharacterException exception e) {     
			System.out.println(e);	
			return false;
		}




void urlFormat(String filename) throws InvalidExtensionException
{
String [] ext=filename.split("\\.");
if(ext.length<=1)
throw new InvalidExtensionException(" ");
}



void emptyUrlName(String url) throws EmptyUrlNameException
{
if(url=="") 
{
throw new EmptyUrlNameException(" EmptyurlName ");
}
}


void  missingDot(String url) throws MissingExtensionException
{
Pattern costPattern=Pattern.compile("[.]");
Matcher costMatcher =costPattern.matcher(url);
boolean value=costMatcher.find();
if(!value)
{
throw new MissingExtensionException(" DotMissing ");
}
}


void specialCharacter(String url) throws SpecialCharacterException
{
filename=filename.split("\\.")[0];
Pattern patternget=Pattern.compile("[@#$^&*(),_]");
Matcher check =patternget.matcher(url);
boolean value=check.find();
if(value==true)
throw new SpecialCharacterException(" special character present");
}



return true;


}
}

class TestValidateUrl
{

ValidatorUrl obj1 =new ValidatorUrl();
	public static void main(String[] args)
	{
		ValidatorUrl obj1 =new ValidatorUrl();
		String url = "http://www.javased.com/index.php?api=java.net.URISyntaxException";

		// Validate an url

		boolean check=urlValidator(url);
		if (check) {
			System.out.print("The URL " + url + " is valid");
		}
		else {
			system.out.print(check);
			System.out.print("The URL " + url + " isn't valid");
			system.out.print(check);
		}
	}
}
