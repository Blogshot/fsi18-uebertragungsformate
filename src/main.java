import java.io.*;
import java.util.ArrayList;

public class main {

    // create instance to avoid static functions
    public static void main(String[] args) throws IOException {
        new main();
    }

    Evaluation evaluation = new Evaluation();
    FileWriter fw;
    SerializationHelper serializationHelper = new SerializationHelper();
    ArrayList<Float> graph = new ArrayList<>();

    public main() throws IOException {

        init();

        doXML();

        doYAML();

        doJSON();

        createGraph();
    }

    private void init() {

        int anzahl = 15;

        for (int i = 0; i < anzahl; i++) {
            Kriterium neu = new Kriterium();

            neu.init(i);

            this.evaluation.addKriterium(neu);
        }
    }

    private void print(String result) {
        System.out.println(result);
        System.out.println("Länge: " + result.length() + "\n");
    }

    private void createGraph() throws IOException {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<graph.size(); i++) {

            switch (i) {
                case 0:
                    sb.append("XML ");
                    break;
                case 1:
                    sb.append("YAML");
                    break;
                case 2:
                    sb.append("JSON");
                    break;
            }
            sb.append("  \t");
            sb.append((int)(graph.get(i)*10));
            sb.append("  \t\t");

            for (int j = 0; j<graph.get(i); j++) {
                if (j%10 == 0) {
                    sb.append("|");
                } else {
                    sb.append("-");
                }

            }

            sb.append("\n");
        }

        String result = sb.toString();

        FileWriter fw = new FileWriter("graph.txt", false);
        fw.write(result);
        fw.close();

        System.out.println(result);


    }

    private void doXML() throws IOException {
        String result = serializationHelper.serializeAsXML(evaluation);
        print(result);

        graph.add(result.length()/10f);

        writeToFile("xml", serializationHelper.serializeAsXMLPretty(evaluation));
    }

    private void doYAML() throws IOException {
        String result = serializationHelper.serializeAsYAML(evaluation);
        print(result.substring(0, result.length()-1));

        graph.add(result.length()/10f);

        writeToFile("yml", result);
    }

    private void doJSON() throws IOException {
        String result = serializationHelper.serializeAsJSON(evaluation);
        print(result);

        graph.add(result.length()/10f);

        writeToFile("json", serializationHelper.serializeAsJSONPretty(evaluation));
    }

    private void writeToFile(String fileType, String input) throws IOException {
        fw = new FileWriter("result." + fileType, false);
        fw.write(input);
        fw.close();
    }
}

