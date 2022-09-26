import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ceasar {
    public static void main(String[] args) {
        String data = "";
        try {
            File myObj = new File("F:\\Fourth year\\Project Information System\\src\\Text.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Please select: E for encryption, D for decryption");
        Scanner c=new Scanner(System.in);
        String s1=c.nextLine();
        if(s1.equalsIgnoreCase("E")) {
            System.out.println("Please select key: ");
            Scanner sc1=new Scanner(System.in);
            int key=sc1.nextInt();
            Encryption(data,key);
        }else if(s1.equalsIgnoreCase("D")) {
            System.out.println("Please select key:");
            Scanner sc1=new Scanner(System.in);
            int key=sc1.nextInt();
            Decrypt(data,key);
        }
    }
    public static void Decrypt(String str, int n) {

        int k=Integer.parseInt("-"+n);
        String string="";
        String rus1 = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String rus2 = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

        for(int i=0;i<str.length();i++) {
            char c=str.charAt(i);
            if(c>='a'&&c<='z')
            {
                c+=k%26;
                if(c<'a')
                    c+=26;
                if(c>'z')
                    c-=26;
            }else if(c>='A'&&c<='Z')
            {
                c+=k%26;
                if(c<'A')
                    c+=26;
                if(c>'Z')
                    c-=26;
            }
            else if(rus1.contains(Character.toString(c)))
            {
                int index = rus1.indexOf(Character.toString(c));

                if((index + k) <0 ) c=rus1.charAt((index + k) +33);
                else  c=rus1.charAt((index + k));
            }
            else if(rus2.contains(Character.toString(c)))
            {
                int index = rus2.indexOf(Character.toString(c));
                if((index + k) <0 )c=rus2.charAt((index + k) +33);
                else c=rus2.charAt(index + k);
            }
            string +=c;
        }
        System.out.println(str + " After decode: " + string);
    }

    public static void Encryption(String str, int k) {
        String string = "";
        String rus1 = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String rus2 = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z')
            {
                c += k % 26;
                if (c < 'a')
                    c += 26;
                if (c > 'z')
                    c -= 26;
            } else if (c >= 'A' && c <= 'Z')
            {
                c += k % 26;
                if (c < 'A')
                    c += 26;
                if (c > 'Z')
                    c -= 26;
            }
            else if(rus1.contains(Character.toString(c)))
            {
                int index = rus1.indexOf(Character.toString(c));

                if((index + k) <0 ) c=rus1.charAt((index + k) +33);
                else  c=rus1.charAt((index + k));
            }
            else if(rus2.contains(Character.toString(c)))
            {
                int index = rus2.indexOf(Character.toString(c));
                if((index + k) <0 )c=rus2.charAt((index + k) +33);
                else c=rus2.charAt(index + k);
            }
            string += c;
        }
        System.out.println(str + " After encode: " + string);
    }
}

