package homework.netcracker.homework2;

import java.util.Random;

public class OperatorSwitch {

    public enum Sounds { JAPANESE, CAT, PIKACHU, JOHNSINA, MONK };
    Sounds sounds;
    public void Enum(Sounds sounds) {
        long begin = System.nanoTime();
        switch (sounds) {
            case CAT:
                System.out.println("meow");
                break;
            case JAPANESE:
                System.out.println("Omae wa mou shindeiru !");
                break;
            case MONK:
                System.out.println("OOM");
                break;
            case PIKACHU:
                System.out.println("pika-pika");
                break;
            case JOHNSINA:
                System.out.println("AAAAAAA");
                break;
        }
        long end = System.nanoTime();
        long time = end - begin;
        System.out.println("switch time " + time + " nano sec");
    }

    public void ElseIf(Sounds sounds) {
        long begin = System.nanoTime();

        if (sounds == Sounds.CAT) {
            System.out.println("meow");
        }

        if (sounds == Sounds.JAPANESE) {
            System.out.println("Omae wa mou shindeiru !");
        }

        if (sounds == Sounds.MONK) {
            System.out.println("OOM");
        }

        if (sounds == Sounds.PIKACHU) {
            System.out.println("pika-pika");
        }

        if (sounds == Sounds.JOHNSINA) {
            System.out.println("AAAAAAA");
        }
        long end = System.nanoTime();
        long time = end - begin;
        System.out.println("Else-if time " + time + " nano sec");

    }

    public void testSwitchIf(Sounds sounds) {
        Enum(sounds);
        System.out.println();
        ElseIf(sounds);

    }

    public void testArrayWithSwitchIf() {

        Random random = new Random();
        int[] array = new int[50];
        for (int i=0; i < 50; i++) {
            array[i] = random.nextInt(10);
        }
        int[] arrayCount = new int[10];
        int[] arrayCount2 = new int[10];
        long begin = System.nanoTime();

        for (int i: array){
            switch (i) {
                case 0:
                    arrayCount[0] += 1;
                    break;
                case 1:
                    arrayCount[1] += 1;
                    break;
                case 2:
                    arrayCount[2] += 1;
                    break;
                case 3:
                    arrayCount[3] += 1;
                    break;
                case 4:
                    arrayCount[4] += 1;
                    break;
                case 5:
                    arrayCount[5] += 1;
                    break;
                case 6:
                    arrayCount[6] += 1;
                    break;
                case 7:
                    arrayCount[7] += 1;
                    break;
                case 8:
                    arrayCount[8] += 1;
                    break;
                case 9:
                    arrayCount[9] += 1;
                    break;
            }
        }

        long end = System.nanoTime();
        long timeSwitch = end - begin;
        System.out.println("time switch " + timeSwitch + " nano sec");
        long begin2 = System.nanoTime();
        for (int i: array) {
            if (i == 0) {
                arrayCount2[0] += 1;
            }
            if (i == 1) {
                arrayCount2[1] += 1;
            }
            if (i == 2) {
                arrayCount2[2] += 1;
            }
            if (i == 3) {
                arrayCount2[3] += 1;
            }
            if (i == 4) {
                arrayCount2[4] += 1;
            }
            if (i == 5) {
                arrayCount2[5] += 1;
            }
            if (i == 6) {
                arrayCount2[6] += 1;
            }
            if (i == 7) {
                arrayCount2[7] += 1;
            }
            if (i == 8) {
                arrayCount2[8] += 1;
            }
            if (i == 9) {
                arrayCount2[9] += 1;
            }
        }
        long end2 = System.nanoTime();
        long timeIf = end2 - begin2;
        System.out.println();
        System.out.println("time else-if " + timeIf + " nano sec");
        System.out.print("[ ");
        for (int i = 0; i < arrayCount2.length; i++){
            System.out.print(i + ": " + arrayCount2[i] + ", ");
        }
        System.out.println("]");
    }

}
