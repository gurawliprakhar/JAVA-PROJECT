package com.peicode.org;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    private static ArrayList<Contact> contacts;
    private static Scanner scan;
    private static int id = 0;


    public static void main(String[] args) {

        contacts = new ArrayList<>();
        System.out.println("Welcome to my world ");
        showIntialOptions();
    }
    private static void showIntialOptions(){
        System.out.println("Please select one: " +
                "\n\t1. Manage Contacts" +
                "\n\t2. Messages" +
                "\n\t3. Quit");

        scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
                break;
            default:
                break;
        }
    }
    private static void manageContacts(){
        System.out.println("Please select one: " +
                "\n\t1. Show all contacts" +
                "\n\t2. add a new contacts" +
                "\n\t3. Add a new contacts" +
                "\n\t4. Search for contacts" +
                "\n\t5. Go Back");

        int choice = scan.nextInt();
        switch (choice){
            case 1:
               showAllContacts();
               break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showIntialOptions();
                break;
        }
    }

    private static void manageMessages(){
        System.out.println("Please select one: "+
                "\n\t1. show all messages" +
                "\n\t2. send a new message" +
                "\n\t3. get Back");
        int choice = scan.nextInt();
        switch (choice){
            case 1 :
                showAllMessages();
                break;
            case 2 :
                sendNewMessage();
                break;
            default:
                showIntialOptions();
                break;
        }
    }

    private static void sendNewMessage(){
        System.out.println("Who are you going to send a new message");
        String name = scan.next();
        if(name.equals("")){
            System.out.println("Please enter the name of contact");
            sendNewMessage();
        }else {
            boolean doesExist = false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExist = true;
                }else{

                }
            }
            if(doesExist){
                System.out.println("What are you going to say?");
                String text = scan.next();
                if(text.equals("")){
                    System.out.println("Please enter some messages");
                    sendNewMessage();
                }else{
                    id++;
                    Message newMessage = new Message(text,name,id);
                    for(Contact c: contacts){
                        if(c.getName().equals(name)){
                            ArrayList<Message> newMessages = c.getMessages();
                            newMessages.add(newMessage);
                            c.setMessages(newMessages);
                        }
                    }
                }
            }else{
                System.out.println("There is no such a contact");
            }
        }
       showIntialOptions();
    }

    private static void showAllMessages(){
        ArrayList<Message> allMessages = new ArrayList<>();
        for(Contact c: contacts){
            allMessages.addAll(c.getMessages());
        }
        if(allMessages.size()>0){
           for(Message m: allMessages){
               m.getDetails();
               System.out.println("**********");
           }
        }else{
            System.out.println("You don't have any message");
        }
        showIntialOptions();
    }
    private static void deleteContact(){
        System.out.println("Please enter the contact's name:");
        String name = scan.next();
        if(name.equals("")){
            System.out.println("Please enter the name");
            deleteContact();
        }else{
            boolean doesExist = false;
            for (Contact c: contacts){
                if (c.getName().equals(name)){
                    doesExist = true;
                    contacts.remove(c);
                }
            }
            if (!doesExist){
                System.out.println("There are no such contact");
            }
        }
        showIntialOptions();
    }
    private static void searchForContact(){
        System.out.println("Please enter the contact name");
        String name = scan.next();
        if(name.equals("")){
            System.out.println("Please enter the name");
            searchForContact();
        }else{
            boolean doesExist = false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                doesExist = true;
                c.getDetails();
            }
        }
        if(!doesExist) {
            System.out.println("There is no such a contact in your phone");
          }
        }
        showIntialOptions();
    }
    private static void addNewContact(){
        System.out.println("Adding a new contact..." +
                "\nPlease enter the contact's name: ");
        String name = scan.next();
        System.out.println("Please enter the contact's number: ");
        String number = scan.next();
        System.out.println("Please entwe the contact's email: ");
        String email = scan.next();

        if(name.equals("") || number.equals("") || email.equals("")){
            System.out.println("Please enter all the information");
            addNewContact();
        }else{
            boolean doesExist = false;
            for (Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExist = true;
                }
            }
            if(!doesExist){
                System.out.println("We have contact named " + name + "saved on this device");
                addNewContact();
            }else {
                Contact contact = new Contact(name, number, email);
                contacts.add(contact);
                System.out.println((name + "added successfully"));
            }
        }
        showIntialOptions();
    }
    private static void showAllContacts(){
        if(contacts.size()>0){
            for(Contact c : contacts){
                c.getDetails();
                System.out.println("********** ");
            }
            showIntialOptions();
        }else{
            System.out.println("You do not have any contacts");
            showIntialOptions();
        }
    }
}
