package com.csc;
import java.util.Scanner;

public class Payroll {
    int hours = 0;
    int children = 0;
    double grossPay = 0.0;
    double netPay = 0.0;
    double deductions = 0.0;
    double ss = 0.0;
    double fit = 0.0;
    double sit = 0.0;
    double union = 10.0;
    double ins = 0.0;
    double payRate = 0.0;
    public double calcGrossPay(int hrs){
        if (hours<=40) {
            return hrs*payRate;
        } else {
            int sum = 0;
            sum += 40*payRate;
            int ot = hrs%40;
            sum += ot*(payRate*1.5);
            return sum;
        }
    }
    public double calcInsurance(){
        if(children>=3){
            return 35.00;
        } else {
            return 15.00;
        }
    }

    public double calcDeductions(double gp){
        ss += (gp*.06);
        deductions += ss;
        fit += (gp*.14);
        deductions += fit;
        sit += (gp*.05);
        deductions += sit;
        deductions += union;
        ins = calcInsurance();
        deductions += ins;
        return deductions;
    }
    public double calcNetPay(double gp, double ded){
        return (gp-deductions);

    }

    public void callMenu(){
        Scanner newScanner = new Scanner(System.in);
        boolean val = false;
        System.out.println("Welcome to the Payroll Program!\n");
        //hours loop
        while(val != true){
            System.out.println("What is your pay rate?\n");
            try {
                String boo = newScanner.nextLine();
                double i = Double.valueOf(boo);
                payRate = i;
                if (payRate < 0){
                    System.out.println("Invalid Value");
                } else {
                    val = true;

                }
            }
            catch (NumberFormatException ex){
                System.out.println("Invalid Value\n");
            }
        }
        val = false;

        while(val != true){
        System.out.println("How many hours did you work this week?\n");
        try { 
            String boo = newScanner.nextLine();
            int i = Integer.valueOf(boo);
            hours = i;
            if (hours < 0){
                System.out.println("Invalid Value");
            } else {
                val = true;

            }
            }    
        catch (NumberFormatException ex){
            System.out.println("Invalid Value\n");
            }
        }
        val = false;
        //children loop
        while(val != true){
            System.out.println("How many children do you have?\n");
            try { 
                String boo = newScanner.nextLine();
                int i = Integer.valueOf(boo);
                children = i;
                if (children < 0){
                    children = 0;
                    val = true;
                } else {
                    val = true;
                }
                }   
            catch (NumberFormatException ex){
                System.out.println("Invalid Value\n");
                }
            }
        grossPay = calcGrossPay(hours);
        deductions = calcDeductions(grossPay);
        netPay = calcNetPay(grossPay, deductions);

        System.out.println("\nPayroll Stub: \n");
        String s = "Hours: " + String.format("%.1f",(double)hours);
        System.out.println(s);
        s = "Rate: $" + String.format("%.2f",(double)payRate) + " /hr";
        System.out.println(s);
        s = "Gross: $" + String.format("%.2f",(double)grossPay) + "\n";
        System.out.println(s);
        s = "SocSec: $" + String.format("%.2f",(double)ss);
        System.out.println(s);
        s = "FedTax: $" + String.format("%.2f",(double)fit);
        System.out.println(s);
        if(netPay<0){
            s = "StTax: $" + String.format("%.2f",(double)sit)+"\n";
        System.out.println(s);

            netPay += union;
            netPay += ins;
            s = "Net: $" + String.format("%.2f",(double)netPay)+"\n";
            System.out.println(s);
            s = "The employee still owes: \n";
            System.out.println(s);
            s = "Ins: $" + String.format("%.2f",(double)ins);
            System.out.println(s);
            s = "Union: $10.00\n";
            System.out.println(s);


        } else {
            s = "StTax: $" + String.format("%.2f",(double)sit)+"";
            System.out.println(s);
            s = "Union: $10.00";
            System.out.println(s);
            s = "Ins: $" + String.format("%.2f", (double) ins) + "\n";
            System.out.println(s);
            s = "Net: $" + String.format("%.2f", (double) netPay) + "\n";
            System.out.println(s);
        }

        s = "Thank you for using the Payroll Program!";
        System.out.println(s);
        


    }
}
