import java.util.Arrays;
import java.util.Scanner;

public class CRUD {
    //Todo : CRUD -> Create R->Read U->Update D-> Delete
    public static String[] programmers = new String[8];
            public static void main(String[]args) {
                Scanner scanner = new Scanner(System.in);
                Scanner scannerForNumber = new Scanner(System.in);
                defaultAddProgrammers();
                while (true) {
                    System.out.print("""
                            Commands:
                            Press 1: Find All Programmers      (READ)
                            Press 2: Add new Programmer       (CREATE)
                            Press 3: Update Programmer by index (UPDATE)
                            Press 4: Delete Programmer by index (DELETE)
                            Press 5: Find Programmer by name (Find by name)
                            Press 6: Stop application
                            Wtite command:
                            """);
                    String command = scanner.nextLine();
                    switch (command.toLowerCase()) {
                        case "1", "read" -> {
                            System.out.println(Arrays.toString(findAllProgrammers()));
                        }
                        case "2","Create" ->{
                            System.out.println("Write new Programmers name:");
                            String name = scanner.nextLine(); //name
                            addProgrammer(name);
                        }
                        case  "3","Update" ->{
                            System.out.println("Write index to update:");
                            int index = scannerForNumber.nextInt();
                            System.out.println("Write new programmer:");
                            String newName = scanner.nextLine();
                            String result = updateProgrammer(index,newName);
                            System.out.println(result);
                        }
                        case "4","Delete" ->{
                            System.out.println("Write index to delete:");
                            int index = scannerForNumber.nextInt();
                            deleteProgrammerByIndex(index);
                        }
                        case "5","Find" ->{
                            System.out.println("Write name to find:");
                            String findName = scanner.nextLine();
                            String[] programmerByName = findProgrammerByName(findName);
                            System.out.println(Arrays.toString(programmerByName));
                        }
                        case "6","Stop" ->{
                            return;
                        }
                        default -> System.out.println("Invalid command");
                    }
                }

            }
            public static void defaultAddProgrammers(){
                programmers[0]="Atai";
                programmers[1]="Bektur";
                programmers[2]="Adilet";
                programmers[3]="Babakhan";
                programmers[4]="Askat bayke";
                programmers[5]="Baisalbek";
                programmers[6]="Nuradil";
                programmers[7]="Mukhammed";
            }
            public static void addProgrammer(String newName){
                programmers=Arrays.copyOf(programmers,programmers.length+1);
                programmers[programmers.length-1]=newName;
            }
            public static String[] findAllProgrammers(){
                return  programmers;
            }
            public static String updateProgrammer(int index,String programmerName){
                if (index>=0 && index< programmers.length) {
                    programmers[index] = programmerName;
                    return "Successfilly updated programmer";
                }
                else {return "Invalid index";
                }
            }
            public static void deleteProgrammerByIndex (int index){
                if (index>=0 && index< programmers.length){
                    for (int i =index; i< programmers.length-1; i++){
                        programmers[i] = programmers[i+1];
                    }
                    programmers=Arrays.copyOf(programmers,programmers.length-1);
                } else {
                    System.out.println("Invalid index");
                }
            }
            public static String[] findProgrammerByName (String name){
                String[] newArray = new String[0];
                for (String programmer : programmers){
                    if (programmer.equals(name)){
                        newArray=Arrays.copyOf(newArray,newArray.length+1);
                        newArray[newArray.length-1]=name;
                    }
                }
                return newArray;
            }
}
