package ampere.qa.customerconnect.factory;

import java.io.File;
import java.util.Date;
import java.util.Map;

public class FolderFactory {
	
	public  static File folder;
	
	
	public FolderFactory(File folder) {
		this.folder=folder;
	}


	public static File CreateFolder()
	{
		Date now = new Date();
		//SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String time = now.toString().replace(":", "-");
		folder= new File(time);
		folder.mkdir();
		return folder;
	}
	

}
