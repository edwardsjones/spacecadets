import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class NameFinder {
	public static void main(String[] args) {
	
		System.getProperties().put("proxySet", "true");
		System.getProperties().put("proxyHost", "152.78.128.51");
		System.getProperties().put("proxyPort", "3128");		

		NameFinder nameFinder = new NameFinder();

		String address = null;
		address = nameFinder.getAddress(address);
		System.out.println(address);

		String nameLine = nameFinder.getLine(address);
		
		String finalName = nameFinder.cleanUp(nameLine);
	}	

	public String getAddress(String address) {
		
		System.out.println("Please enter your email ID now:");

		try
		{
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			String id = bufferRead.readLine();
			address = "http://www.ecs.soton.ac.uk/people/" + id + "/";
		}

		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return address;
	}

	public String getLine(String address) {
	
		String nameLine = null;

		try
		{
			URL person = new URL(address);
			URLConnection yc = person.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null)
			{
				int charNumber = inputLine.indexOf("<title>");
				if (charNumber != -1) { 
					nameLine = inputLine;
				}
			}
			in.close();
		}

		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		return nameLine;
	}

	public String cleanUp(String nameLine) {

		int nameStart = nameLine.indexOf(">") + 1;
		int nameEnd = nameLine.indexOf("|");
			
		String name = nameLine.substring(nameStart, nameEnd);

		System.out.println(name);	
		return null;
	}
}
