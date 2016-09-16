import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created: 16/09/2016 11:26 AM.
 */
public
class XMLReadLargeFileWriteSmall {
    public static
    void main(String[] args) {
        if (args.length == 4) {
            List<String> verifyIds    = readEachXMLSnippetToString(args[0] + args[1], "<CDPAllocationId>");
            List<String> multipleXMLs = readEachXMLSnippetToString(args[0] + args[2], "<?xml");

            List<String> missing = findMissing(verifyIds, multipleXMLs);
            writeToMultipleXMFiles(multipleXMLs, args[3]);
        } else {
            System.err.println("2 arguments expected.");
        }
    }

    private static
    List<String> findMissing(final List<String> verifyIds, final List<String> multipleXMLs) {
        List<String> missingSnippet = new ArrayList<>();
        next_verify:
        for(String verifyStr: verifyIds) {
            for(String xmlSnippet: multipleXMLs) {
                if(xmlSnippet.contains(verifyStr.trim())) {
                    //System.err.println("found: " + verifyStr + "in " + xmlSnippet);
                    continue next_verify;
                }
            }
            missingSnippet.add(verifyStr);
            System.err.println("did not find: " + verifyStr);
        }
        return missingSnippet;
    }

    private static
    void writeToMultipleXMFiles(final List<String> multipleXMLs, final String prefix) {
        int counter = 0;
        for (String xmlSnippet : multipleXMLs) {
            try (FileWriter fw = new FileWriter(prefix + "_" + (counter++) + ".xml")) {
                fw.write(xmlSnippet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static
    List<String> readEachXMLSnippetToString(final String arg, final String rolloverPattern) {
        List<String> xmlSnippets = new ArrayList<>();
        try (BufferedReader bis = new BufferedReader(new FileReader(arg))) {
            String xmlSnippet = bis.readLine() + System.lineSeparator();
            String line;
            while (bis.ready()) {
                line = bis.readLine() + System.lineSeparator();
                if (line.contains(rolloverPattern)) {
                    xmlSnippets.add(xmlSnippet);
                    xmlSnippet = line;
                } else {
                    xmlSnippet += line;
                }
            }
            xmlSnippets.add(xmlSnippet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlSnippets;
    }
}
