import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocReader {

//    static Scanner input;

    public static void main(String[] args) {
//        input = new Scanner(System.in);
//        System.out.println("Укажите путь к файлу:");
//        String fileWay = input.nextLine();
//        System.out.println("Укажите Имя файла:");
//        String fileName = input.nextLine();
        String p = "docnum(\\W[0-9]9)";
        Pattern pattern = Pattern.compile(p);




        try (
                BufferedReader in = new BufferedReader(new FileReader("E:\\Git\\HomeWork_11_TMS\\files\\docNumbers.txt"));
                BufferedWriter outValid = new BufferedWriter(new FileWriter("E:\\Git\\HomeWork_11_TMS\\files\\docValid.txt"));
        BufferedWriter outNotValid = new BufferedWriter(new FileWriter("E:\\Git\\HomeWork_11_TMS\\files\\docNotValid.txt"))) {


            String docNum;
            while ((docNum = in.readLine()) != null) {
                Matcher matcher = pattern.matcher(docNum);
                    if (matcher.find()) {
                        outValid.write("Договор " + docNum);
                        outValid.write("\n");
                        System.out.println(docNum);
                        System.out.println("Верно");
                    } else {
                        outNotValid.write(docNum);
                        outNotValid.write("\n");
                        System.out.println(docNum);

                    }

            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
