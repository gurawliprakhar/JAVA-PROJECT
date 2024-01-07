package org.oopChallange;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
       Patient  patient = new Patient("Parul",21,
               new Eye("Left Eye","Short sight", "blue", true),
               new Eye("Right Eye","Normal", "blue", true),
               new Heart("Heart", "Normal", 65),
               new Stomach("Stomach", "PUD", false),
               new Skin("skin", "burnerd","white",40));

        System.out.println("Name: " + patient.getName());
        System.out.println("Age: " +patient.getAge());

        Scanner scan =  new Scanner(System.in);

        boolean shouldFinish = false;
        while(!shouldFinish){
            System.out.println("Choose an Organ: " +
                    "\n\t1. Left Eye" +
                    "\n\t2. Rightt Eye +" +
                    "\n\t3. Heart" +
                    "\n\t4. Stomach" +
                    "\n\t5. Skin" +
                    "\n\t6. Quit");

            int choice = scan.nextInt();
            switch  (choice){
                case 1:
                    patient.getLeftEye().getDetails();
                    if(patient.getLeftEye().isOpen()){
                        System.out.println("\t\t1. Close the Eye");
                        if(scan.nextInt() == 1){
                          patient.getLeftEye().close();
                        }else{
                            continue;
                        }
                    }else{
                        System.out.println("\t\t1. Open the Eye");
                        if(scan.nextInt() == 1){
                            patient.getLeftEye().open();
                        }else{
                            continue;
                        }
                    }
                    break;
                case 2:
                    patient.getRightEye().getDetails();
                    if(patient.getRightEye().isOpen()){
                        System.out.println("\t\t1. Close the Eye");
                        if(scan.nextInt() == 1){
                            patient.getRightEye().close();
                        }else{
                            continue;
                        }
                    }else{
                        System.out.println("\t\t1. Open the Eye");
                        if(scan.nextInt() == 1){
                            patient.getRightEye().open();
                        }else{
                            continue;
                        }
                    }
                    break;
                case 3:
                    patient.getHeart().getDetails();
                    System.out.println("\t\t1. change the heart rate");
                    if(scan.nextInt() == 1){
                        System.out.println("Enter the new Heart rate: ");
                        int newHeartRate = scan.nextInt();
                        patient.getHeart().setRate(newHeartRate);
                        System.out.println("Heart rate changed to: " + patient.getHeart().getRate());
                    }else{
                        continue;
                    }
                    break;
                case 4:
                   patient.getStomach().getDetails();
                    System.out.println("\t\t1. Digest");
                    if(scan.nextInt() == 1){
                        patient.getStomach().digest();
                    }else{
                        continue;
                    }
                    break;
                case 5:
                   patient.getSkin().getDetails();
                   break;
                default:
                  shouldFinish = true;
                  break;
            }
        }
    }
}
