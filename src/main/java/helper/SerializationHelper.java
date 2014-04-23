package helper;

import data.ActivitySheet;
import org.joda.time.LocalDate;

import java.io.*;

public class SerializationHelper {

	public static ActivitySheet deserializeActivitySheet(LocalDate date) {
		File file = FileHelper.getActivityFile(date);

		InputStream fileStream;
		InputStream buffer;
		ObjectInput input;
		try {
			fileStream = new FileInputStream(file);
			buffer = new BufferedInputStream(fileStream);
			input = new ObjectInputStream(buffer);
			try {
				return (ActivitySheet) input.readObject();
			} finally {
				input.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ActivitySheet deserializeActivitySheet() {
		return deserializeActivitySheet(new LocalDate());
	}

	public static void serializeActivitySheet(ActivitySheet activitySheet) {
		File file = FileHelper.getActivityFile(activitySheet);

		OutputStream fileStream;
		OutputStream buffer;
		ObjectOutput output;
		try {
			fileStream = new FileOutputStream(file);
			buffer = new BufferedOutputStream(fileStream);
			output = new ObjectOutputStream(buffer);
			try {
				output.writeObject(activitySheet);
			} finally {
				output.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
