
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Reader_Extraction{

	public static void main(String[] args) {
		boolean maincat = false;
		boolean first_time = true;

		String xml_result = "";
		String xml_document = "";
		
		File file = null;
		FileReader reader = null;
		BufferedReader buffer = null;

		FileWriter file_writer = null;
		PrintWriter p_writer = null;
		long time_init, time_final;
		time_init = System.currentTimeMillis();
		
		try {
			file = new File("C:\\Users\\José Carlos\\Downloads\\FullOct2007.xml");
			reader = new FileReader(file);
			buffer = new BufferedReader(reader);
			file_writer = new FileWriter("filtrado_xml.xml");
			p_writer = new PrintWriter(file_writer);

			String line;
			while ((line = buffer.readLine()) != null) {
				// VESPAADD
				if (line.contains("<vespaadd>")) {
					xml_document += line;
				} else if (line.contains("</vespaadd")) {
					xml_document += line;
					if (maincat) {
						if (first_time) {
							p_writer.println(xml_result);
							p_writer.println(xml_document);
							first_time = false;
						} else {
							p_writer.println(xml_document);
						}
					}
					xml_document = "";
				// CATEGORIAS
				} else if (line.contains("<maincat>")) {
					xml_document += line;
					// Categorias que queremos en el nuevo xml
					if(line.contains("Politics &amp; Government") || line.contains("Sports") || line.contains("Education &amp; Reference") || line.contains("Social Science"))
						maincat = true;
					else
						maincat = false;
				} else {
					// Arreglo para incluir las lineas iniciales del XML
					if (line.contains("<?xml version"))
						xml_result += "<?xml version='1.0' encoding='ISO-8859-1'?>\n";
					else if (line.contains("<ystfeed>"))
						xml_result += line;
					else
						xml_document += line;
				}
				
			}
			// Arreglo para cerrar el ystfeed
			p_writer.println("</ystfeed>");
		} catch (Exception ex1) {
			ex1.printStackTrace();
		} finally {
			// Cierre del fichero
			try {
				if (null != reader) {
					reader.close();
					file_writer.close();
				}
			} catch (Exception ex2) {
				ex2.printStackTrace();
			}
		}
		// Tiempo de ejecucion final
		time_final = System.currentTimeMillis();
		System.out.println("Tiempo de ejecución: " + (time_final - time_init) + " milisegundos.");
	}
}
