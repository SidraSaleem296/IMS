import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
public class testing_8 {
    public static ArrayList<String> pdtName = new ArrayList<>();// I have used arraylists to store data here
    public static ArrayList<String> getPdtName() {
        pdtName.add("Panaddol");
        pdtName.add("Brufen");
        pdtName.add("Amoxil");
        pdtName.add("Oxydil");
        pdtName.add("Citalopram (Celexa)");
        pdtName.add("Escitalopram (Lexapro)");
        return pdtName;
    }
    public static ArrayList<Double> pdtCost = new ArrayList<>();
    public static ArrayList<Double> getPdtCost() {
        pdtCost.add(50.0);
        pdtCost.add(50.0);
        pdtCost.add(50.0);
        pdtCost.add(50.0);
        pdtCost.add(50.0);
        pdtCost.add(50.0);
        return pdtCost;
    }
    public static ArrayList<Integer> pdtQuan = new ArrayList<Integer>();
    public static ArrayList<Integer> getPdtQuan() {
        pdtQuan.add(40);
        pdtQuan.add(40);
        pdtQuan.add(40);
        pdtQuan.add(40);
        pdtQuan.add(40);
        pdtQuan.add(40);
        return pdtQuan;
    }
    public static ArrayList<String> pdtCode = new ArrayList<String>();
    public static ArrayList<String> getPdtCode() {
        pdtCode.add("1");
        pdtCode.add("2");
        pdtCode.add("3");
        pdtCode.add("4");
        pdtCode.add("5");
        pdtCode.add("6");
        return pdtCode;
    }
    public static ArrayList<String> cpName = new ArrayList<String>();
    public static ArrayList<Integer> Qcart = new ArrayList<Integer>();
    public static ArrayList<String> cart1 = new ArrayList<String>();
    public static ArrayList<String> c1name = new ArrayList<String>();
    public static ArrayList<Double> cCost = new ArrayList<Double>();
    public static Date date = new Date(); // The date and time is generated here
    public static SimpleDateFormat sdf = new SimpleDateFormat(" E MM, dd, yyyy   HH:mm:ss"); // date format has been generated day name at E
    public static boolean check = false; //boolean checks will be used ahead
    public static boolean check2 = false;
    public static void main(String[] args) {
        getPdtCode();
        getPdtQuan();
        getPdtName();
        getPdtCost();
        menu(); // in the main menu has been called that will trigger the menu to start program
    }
    public static void menu() {
        while (true) {
            try {
                String menu; // string will store menu statement
                menu = "\n**WELCOME TO OUR STORE*" +
                        " \n-----PLease select your option by pressing one of the digits" +
                        " given on the left of the entities.-----" +
                        "\n 1-Admin\n " +
                        "2-Customer\n " +
                        "3-Billings\n " +
                        "4-Exit";
                Scanner input = new Scanner(System.in);
                System.out.println(menu);
                int x = input.nextInt();  // value at x will decide what option is selected
                if (x == 1) {
                    admin();
                } else if (x == 2) {
                    customer();
                } else if (x == 3) {
                    // check 2 will ensure that user has updated his cart
                    billings();
                } else if (x == 4) {
                    System.exit(0); // This will end the program with code zero so that user can end the program when he wants
                }
                else {
                    System.out.print("Please select a valid option.");
                    break;
                }
            } catch (InputMismatchException e) {
//                System.out.print("Please enter a valid value");
            }
        }
        menu(); // call has been put in place to handle breaks at different points that take you back to recent menus
    }
    public static void admin() {
        String ch;
        while (true) {
            try {
                String str1 = "\nWelcome Admin\n Please select one of the following actions\n 1-Add Products to Inventory\n 2-View Inventory\n 3-Update Inventory\n 4-Delete Products from Inventory\n 5-Go Back to Main menu ";
                Scanner input = new Scanner(System.in);
                System.out.print(str1);
                int a1 = input.nextInt();  // value will decide what option is selected
                if (a1 == 1) {
                    Scanner Input = new Scanner(System.in);
                    System.out.print("Do you want to proceed with \"Add Product\"?\n (y/n)\n Press \"y\" for yes and Press \"n\" for no	: ");
                    ch = input.next();
                    if (ch.trim().toLowerCase().equals("y")) {
                        //The int i is at zero at the beginning
                        while (true) {    // this acts as an infinite loop
                            System.out.print("Please enter the name of the product.");
                            addString(pdtName); // This triggers the add Datatype method with the respective datatype at the operation
                            System.out.print("Please enter the code of the product.");
                            addString(pdtCode); // This triggers the add Datatype method with the respective datatype at the operation
                            System.out.print("Please enter the price of the product.");
                            addDouble(pdtCost); // This triggers the add Datatype method with the respective datatype at the operation
                            System.out.print("Please enter the quantity of the product.");
                            addInt(pdtQuan); // This triggers the add Datatype method with the respective datatype at the operation
                            // check = true;  // Updates when something has been added
//                                input = new Scanner(System.in);
                            System.out.print("Do you want to enter another product?\n (y/n)\n Enter \"y\" for yes Enter \"n\" for no");
                            String chara = input.next();
                            if (chara.trim().toLowerCase().equals("n")) {
                                break;  // counter is updated and the loop breaks
                            }
                        }
                    } else if (ch.trim().toLowerCase().equals("n")) {
                        System.out.print("Back");
                    }
//                    else {
//                        System.out.print("Please enter a valid input");
//                    }
                } else if (a1 == 2) {
                    for (int i = 0; i < pdtCode.size(); i++) {
                        System.out.print("\nProduct's name: ");
                        System.out.print(pdtName.get(i) + " ");
                        System.out.print("Product's code: ");
                        System.out.print(pdtCode.get(i) + " ");
                        System.out.print("Product's price: ");
                        System.out.print("Rs" + pdtCost.get(i) + " ");
                        System.out.print("Product's Quantity: ");
                        System.out.print(pdtQuan.get(i) + " ");
                    }
                }
                if (a1 == 3) {
                    // check  and arraylists are used make available
                    Scanner Input = new Scanner(System.in);
                    System.out.print("Enter the code of the product you want to update: ");
                    String str = input.next();
                    int i = 0;
                        while (i < pdtCode.size()) {
                            if (pdtCode.get(i).equals(str)) {
                                /**
                                 The index at i will work as pointer at which the entries will be updated
                                 the index will keep count in directory
                                 **/
                                pdtName.remove(i);
                                Input = new Scanner(System.in);
                                System.out.print("\n Enter new Product name: ");
                                String tmp1 = input.next();
                                pdtName.add(i, tmp1); // item at i will be replaced by tmp1 value
                                pdtCode.remove(i);
                                Input = new Scanner(System.in);
                                System.out.print("\n Enter new Product code: ");
                                String tmp2 = input.next();
                                pdtCode.add(i, tmp2);
                                pdtCost.remove(i);
                                Input = new Scanner(System.in);
                                System.out.print("\n Enter new Product price: ");
                                double tmp3 = input.nextDouble();
                                pdtCost.add(i, tmp3);
                                pdtQuan.remove(i);
                                Input = new Scanner(System.in);
                                System.out.print("\n Enter new Product quantity: ");
                                int tmp4 = input.nextInt();
                                pdtQuan.add(i, tmp4);
                                i = i + (pdtCode.size()); // break will be added in while loop
                            }
                            else if (!pdtCode.get(i).equals(str)) {
                                i++;
////                                System.out.println("Product with this code is not present in the inventory");// counter will search through the values of arraylist and also acts as a break
//
                            }
                            else {
                                System.out.print(" Product code invalid ");
                                i = i + (pdtCode.size());
                            }

                        }



                } else if (a1 == 4) {
                    // check  and arraylists are used make available
                    input = new Scanner(System.in);
                    System.out.print("Please enter the code of product you want to delete");
                    String remov = input.next();
                    int i = 0;
                    while (i < pdtCode.size()) {
                        if (pdtCode.get(i).equals(remov)) {
                            pdtCode.remove(i);
                            pdtName.remove(i);
                            pdtQuan.remove(i);
                            pdtCost.remove(i);
                            if (pdtName.isEmpty()) {
                                check = false;   // if admin has deleted entire inventory then check becomes false so inventory doesn't work abnormally
                            }
                            System.out.print("The product with product code " + remov + " has been deleted successfully");
                            i = i + (pdtCode.size());// acts as a break in while loop
                        }
                        else if (!pdtCode.get(i).equals(remov)) {
                            i++; // counter will help to search
                        }
                        else {
                            System.out.print("The product with product code " + remov + " not found");
                            i = i + (pdtCode.size());
                        }
                    }
                } else if (a1 == 5) {

                    menu(); // calls menu
                } else {

                    System.out.print("\nPlease select a valid option.");
                }
                admin();
            }
            // call has been put in place to handle breaks at different points that take you back to recent menus
            catch (InputMismatchException e) {
                System.out.println("Please enter a valid input");
            }
        }
    }
    public static void customer() {
        while (true) {
            try {
                String st2 = "\nDear customer welcome to our store. Please select one of the following actions\n 1-View our Catalogue\n 2-Check your Cart\n 3-Check Total Bill\n 4-Go Back to Main menu";
                Scanner input = new Scanner(System.in);
                System.out.print(st2);
                int a2 = input.nextInt();  // value will decide what option is selected
                if (a2 == 1 && !pdtName.isEmpty()) {
                    // check  and arraylists are used make available
                    for (int i = 0; i < pdtName.size(); i++) {
                        System.out.print("\nProduct's name: ");
                        System.out.print(pdtName.get(i) + " ");
                        System.out.print("Product's code: ");
                        System.out.print(pdtCode.get(i) + " ");
                        System.out.print("Product's price: ");
                        System.out.print("Rs" + pdtCost.get(i) + " ");
                        System.out.print("Product's Quantity: ");
                        System.out.print(pdtQuan.get(i) + " ");
                    }
                    input = new Scanner(System.in);
                    System.out.print("\nDo you want to add products to your cart ? \n(y/n)\nPress \"y\" for yes and Press \"n\" for no");
                    String chr1 = input.next();
                    if (chr1.trim().toLowerCase().equals("y")) {
                        while (true) {
                            input = new Scanner(System.in);
                            System.out.println("\nPlease Enter the code of the product you want to add to your cart: ");
                            String cd = input.next();
                            int j = 0;
                            while (j < pdtCode.size()) {
                                if (pdtCode.get(j).equals(cd)) {
                                    cart1.add(pdtCode.get(j));
                                    System.out.println("Please Enter the quantity of the product you want to add to your cart: ");
                                    minusQuan(pdtQuan, Qcart, j); // This triggers the add Datatype method with the respective datatype at the operation
                                    System.out.print("Please Enter your name or an alias: ");
                                    addString(c1name); // This triggers the add Datatype method with the respective datatype at the operation
                                    cpName.add(pdtName.get(j));
                                    cCost.add(pdtCost.get(j));
                                    check2 = true;  // Updates when something has been added and check 2 will ensure that user has updated his cart
                                    j = j + pdtCode.size();
                                } else if (!pdtCode.get(j).equals(cd)) {
                                    j++;
                                } else {
                                    System.out.print("Product code invalid");
                                    j = j + pdtCode.size();
                                }
                            }
                            input = new Scanner(System.in);
                            System.out.print("Do you want to enter another product?\n (y/n)\n Enter \"y\" for yes Enter \"n\" for no");
                            String chara = input.next();
                            if (chara.trim().toLowerCase().equals("y")) {
                                System.out.println("Enter...");
                            } else if (chara.trim().toLowerCase().equals("n")) {
                                break;
                            } else {
                                System.out.print("Please enter a valid input");
                                break;
                            }
                        }
                    } else if (chr1.trim().toLowerCase().equals("n")) {
                        customer();
                    } else {
                        System.out.print("Please Enter a valid input");
                        customer();
                    }
                    customer();
                } else if (a2 == 2 && !c1name.isEmpty()) {
                    input = new Scanner(System.in);
                    System.out.print("\nPlease Enter the Name or the Alias that you registered your cart with :");
                    String na = input.next();  // This will ask the user to enter his alias that he used before to store data
                    int i = 0;
                    while (i < cpName.size()) {
                        if (c1name.get(i).equals(na)) {
                            System.out.print("\nProduct's name: ");
                            System.out.print(cpName.get(i) + " ");
                            System.out.print("Product's code: ");
                            System.out.print(cart1.get(i) + " ");
                            System.out.print("Product's price: ");
                            System.out.print("Rs" + cCost.get(i) + " ");
                            System.out.print("Product's Quantity: ");
                            System.out.print(Qcart.get(i) + " ");
                            i++;
                        } else if (!c1name.get(i).equals(na)) {
                            i++; // counter will help to search through the arraylists
                        } else {
                            System.out.print("Name or Alias invalid.");
                            i = i + cpName.size(); // breaks while loop
                        }
                    }
                } else if (a2 == 3 && !c1name.isEmpty()) {
                    // check  and arraylists are used make available
                    input = new Scanner(System.in);
                    System.out.print("\nPlease Enter the Name or the Alias that you registered your cart with :");
                    String na = input.next();  // This will ask the user to enter his alias that he used before to store data
                    int i = 0;
                    while (i < c1name.size()) {
                        if (c1name.get(i).equals(na)) {
                            double sum = 0;
                            sum = sum + (cCost.get(i) * Qcart.get(i));
                            System.out.print("\n Your total bill for :");
                            System.out.print(" " + Qcart.get(i) + " units of " + " " + cpName.get(i) + " is " + "$" + sum);
                            i++;
                        } else if (!c1name.get(i).equals(na)) {
                            System.out.println("Cart is empty");
                            i++;
                        } else {
                            System.out.print("Name or Alias invalid.");
                            i = i + c1name.size();
                        }
                    }
                    while (true) {
                        try {
                            input = new Scanner(System.in);
                            System.out.print("\nWhere do you want to go now?\n 1-Back to Customer menu\n 2-Back to main menu\n Please select one");
                            int y = input.nextInt();
                            if (y == 1) {
                                break;
                            } else if (y == 2) {
                                menu();
                            } else {
                                System.out.print("Please select a valid input");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a valid value");
                        }
                    }
                } else if (a2 == 4) {
                    menu(); // calls menu
                } else {
                    System.out.print("Inventory maybe empty");
                    System.out.print("\nPlease select a valid option.");
                }
                customer(); // call has been put in place to handle breaks at different points that take you back to recent menus
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid value");
            }
        }
    }
    public static void billings() {

        try {
            FileWriter myFile1 = new FileWriter("billings.txt");
            if (!cart1.isEmpty()) {
                int cost = 0;
                for (int i = 0; i < cart1.size(); i++) {
                    System.out.print("\nClient : " + c1name.get(i)); // outputs the name of client according to the order of purchase
                    myFile1.append("\nClient : " + c1name.get(i));
                    System.out.print(" \n  made a purchase of;  Product name:  " + cpName.get(i));
                    myFile1.append("\n  made a purchase of;  Product name:  " + cpName.get(i));// outputs the product's name of client according to the order of purchase
                    System.out.print(" \n Product code:  " + cart1.get(i));
                    myFile1.append(" \n Product code:  " + cart1.get(i));// outputs the code of client's product according to the order of purchase
                    System.out.print(" \n Product's Quantity:  " + Qcart.get(i));
                    myFile1.append(" \n Product's Quantity:  " + Qcart.get(i));// outputs the quantity of client's product according to the order of purchase
                    System.out.print(" \n Product's Cost:  " + "Rs" + +cCost.get(i) + " per Unit ");
                    myFile1.append(" \n Product's Cost:  " + "Rs" + +cCost.get(i) + " per Unit ");// outputs the cost of product according to the order of purchase
                    System.out.print("      " + sdf.format(date));
                    myFile1.append(" \n Product's Cost:  " + "Rs" + +cCost.get(i) + " per Unit ");//outputs date in above set format
                }
                {
                    for (int j = 0; j < Qcart.size(); j++) {
                        for (int i = 0; i < Qcart.size(); i++) {
                            cost += cCost.get(i) * Qcart.get(i);
                            System.out.println("Total cost of client's purchase is " + cost);
                            myFile1.append("Total cost of client's purchase is " + cost);

                        }
                        break;
                    }
//                        break;
                    //outputs date in above set format
                }
            }
        else
                System.out.println("Customer cart is empty");
            while (true) {
                Scanner input = new Scanner(System.in);
                System.out.print("\nDo you want to go back to main menu?\n (y/n)\n Press \"y\" for yes or Press \"n\" for no.");
                String opt = input.next();
                if (opt.trim().toLowerCase().equals("y")) {
                    System.out.print("Back...");
                    menu();
                } else if (opt.trim().toLowerCase().equals("n")) {
                    break;
                } else {
                    System.out.print("Please Select a valid input");
                    break;
                }
            }
            myFile1.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void addInt(java.util.ArrayList<Integer> list) {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter value :");
                int n = input.nextInt();
                if (n < 0) {
                    System.out.println("Your entered a negative value. Please enter a valid value again.");
                } else {
                    list.add(n);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid value");
            }
        }
    }
    public static void addString(ArrayList<String> list) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter :");
        String n = input.nextLine();
        list.add(n);
    }
    public static void addDouble(java.util.ArrayList<Double> list) {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter value :");
                double n = input.nextDouble();
                if (n < 0) {
                    System.out.println("Your entered a negative value. Please enter a valid value again.");
                } else {
                    list.add(n);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid value");
            }
        }
    }
    public static void minusQuan(ArrayList<Integer> list, ArrayList<Integer> list1, int n) {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("\nEnter value :");
                int m = input.nextInt();
                if (m < 0) {
                    System.out.println("Your entered a negative value. Please enter a valid value again.");
                } else { // calculating the remaining value of the product's quantity
                    int mean = list.get(n);
                    int left = mean - m;
                    if (left < 0) {
                        System.out.println("\nNot enough product in the Inventory. Please try again with new amount.");
                    } else { // adds the values once all conditions are met
                        list1.add(m);
                        list.remove(n);
                        list.add(n, left);
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer");
            }
        }
    }
}
