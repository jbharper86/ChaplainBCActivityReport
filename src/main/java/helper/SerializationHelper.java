package helper;

import data.ActivitySheet;
import data.Agent;
import data.Office;
import org.joda.time.LocalDate;

import java.io.*;

public class SerializationHelper {

	/**
	 * Helper method for retrieving a serializable object from a file.
	 *
	 * @param file
	 * @param <SerializableObject>
	 * @return
	 */
	private static <SerializableObject extends Serializable> SerializableObject deserialize(File file) {
		InputStream fileStream;
		InputStream buffer;
		ObjectInput input;
		try {
			fileStream = new FileInputStream(file);
			buffer = new BufferedInputStream(fileStream);
			input = new ObjectInputStream(buffer);
			try {
				return (SerializableObject) input.readObject();
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

	/**
	 * Helper method for saving a serializable object to a file.
	 *
	 * @param file
	 * @param object
	 * @param <SerializableObject>
	 */
	private static <SerializableObject extends Serializable> void serialize(File file, SerializableObject object) {
		OutputStream fileStream;
		OutputStream buffer;
		ObjectOutput output;
		try {
			fileStream = new FileOutputStream(file);
			buffer = new BufferedOutputStream(fileStream);
			output = new ObjectOutputStream(buffer);
			try {
				output.writeObject(object);
			} finally {
				output.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ActivitySheet deserializeActivitySheet(LocalDate date) {
		return deserialize(FileHelper.getActivityFile(date));
	}

	public static ActivitySheet deserializeActivitySheet() {
		return deserializeActivitySheet(new LocalDate());
	}

	public static void serializeActivitySheet(ActivitySheet activitySheet) {
		serialize(FileHelper.getActivityFile(activitySheet), activitySheet);
	}

	public static Agent deserializeAgent() {
		return deserialize(FileHelper.getAgentFile());
	}

	public static void serializeAgent(Agent agent) {
		serialize(FileHelper.getAgentFile(), agent);
	}

	public static Office deserializeOffice() {
		return deserialize(FileHelper.getOfficeFile());
	}

	public static void serializeOffice(Office office) {
		serialize(FileHelper.getOfficeFile(), office);
	}
}
