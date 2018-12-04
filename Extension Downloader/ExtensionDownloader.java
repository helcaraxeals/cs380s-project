import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.*;
import java.util.Scanner;


public class ExtensionDownloader {

	
	public static void main(String args[]) throws Exception {
		
		
//		Scanner s = new Scanner(new File("app-8.xml"));
//		
//		int counter = 0;
//		//https://clients2.google.com/service/update2/crx?response=redirect&prodversion=49.0&x=id%3D~~~~%26installsource%3Dondemand%26uc
//
//		while (s.hasNextLine()) {
//			String line = s.nextLine();
//			//System.out.println(line);
//			
//			String token = "https://www.crx4chrome.com/extensions/";
//			int begin = line.indexOf(token);
//			int end = line.indexOf("/", begin + token.length());
//			if (begin != -1) {
//				String id = line.substring(begin + token.length(), end);
//				counter++;
//				System.out.println(counter + " " + id);
//				
//				//String address = "https://clients2.google.com/service/update2/crx?response=redirect&prodversion=49.0&x=id%3D"
//				//		+ id + "%26installsource%3Dondemand%26uc";
//				//URL url = new URL(address);
//				//getData(url, "downloads/" + id + ".zip");
//				
//				//if (counter == 1000) break;
//				
//			}
//		}
//		
//		s.close();
		
		Scanner s = new Scanner(new File("extensions.txt"));
		
		int counter = 0;
		//https://clients2.google.com/service/update2/crx?response=redirect&prodversion=49.0&x=id%3D~~~~%26installsource%3Dondemand%26uc

		while (s.hasNextLine()) {
			String line = s.nextLine();
			String id = line;
			String address = "https://clients2.google.com/service/update2/crx?response=redirect&prodversion=49.0&x=id%3D"
					+ id + "%26installsource%3Dondemand%26uc";
			URL url = new URL(address);
			getData(url, "downloads2/" + id + ".zip");
			
			counter++;
			System.out.println(counter + " " + id);

		}
		
		s.close();
	}
	
	
    public static void getData(URL url, String outputFile) {
    	try {
	    	ReadableByteChannel rbc = Channels.newChannel(url.openStream());
	    	FileOutputStream fos = new FileOutputStream(outputFile);
	    	fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    	}
    	catch (Exception e) {
    		System.out.println("Exception: " + e.getMessage());
    	}
//        URLConnection conn = null;
//        InputStreamReader in;
//        BufferedReader data;
//        String line;
//        StringBuffer buf = new StringBuffer();
//        try {
//            conn = url.openConnection();
//            conn.connect();
//            in = new InputStreamReader(conn.getInputStream());
//            data = new BufferedReader(in);
//            int counter = 0;
//            while ((line = data.readLine()) != null) {
//            	if (counter == 0) {
//            		buf.append(line);
//            		counter++;
//            	}
//            	else {
//            		buf.append("\n" + line);
//            	}
//            }
//            
//            BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(outputFile)));
//    		bwr.write(buf.toString());
//    		bwr.flush();
//    		bwr.close();
//
//        } catch (Exception e) {
//            System.out.println("IO Error:" + e.getMessage());
//        }
    }
	
}
