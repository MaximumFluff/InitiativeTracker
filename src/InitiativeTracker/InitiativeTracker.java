package InitiativeTracker;

import java.util.*;

public class InitiativeTracker
{
    public static void main(String args[])
    {
        // TODO: try to find a better way to do this shit
        if (args[1].equals("")|| args[1].equals("0"))
        {
            System.out.println("Usage: java -jar initiative_tracker.jar <playerAmount> <enemyAmount>");
            System.exit(-1);
        }
        int playerAmount = Integer.parseInt(args[0]);
        int enemyAmount = Integer.parseInt(args[1]);
        HashMap<String, Creature> creatureList = new HashMap<String, Creature>();
        generateCreatures(creatureList, playerAmount, enemyAmount);
    }

    // TODO: try to clean this shit up
    public static void generateCreatures(HashMap<String, Creature> list, int players, int enemies)
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("--- Generate the characters! ---");
        for (int i = 0; i < (players + enemies); i++)
        {
            String name;
            int health, initiative, ac;
            boolean isPlayer = true;
            String yesNo;
            Creature newCritter;
            System.out.print("Is this creature a player?(Y/N) ");
            yesNo = reader.nextLine();
            if (yesNo.toUpperCase().equals("N"))
            {
                isPlayer = false;
            }
            System.out.print("Creature name: ");
            name = reader.nextLine();
            System.out.print("Creature hit points: ");
            health = Integer.parseInt(reader.nextLine());
            System.out.print("Creature armour class: ");
            ac = Integer.parseInt(reader.nextLine());
            System.out.print("Creature initiative score: ");
            initiative = Integer.parseInt(reader.nextLine());
            newCritter = new Creature(name, health, ac, initiative, isPlayer);
            list.put(name, newCritter);
        }

        combatRound(players, list);
        reader.close();
    }


    public static void combatRound(int playerAmount, HashMap<String, Creature> list)
    {
        Scanner reader = new Scanner(System.in);
        String query;
        // While all creatures not dropped from list, keep looping
        //Collections.sort(list);
        System.out.println("--- Combat starts! ---");
        while (list.size() != playerAmount)
        {
            for (Creature creatureObject : list.values())
            {
                System.out.println("---" + creatureObject.getName() + "---\n");
                updateHealth(list);
            }
        }
        System.out.print("--- All enemy combatants dead! ---");
        reader.close();
    }

    // TODO: fix this method, dynamically alter creatures health values and drop from list
    public static void updateHealth(HashMap<String, Creature> list)
    {
        String query;
        String findName;
        int newHp;
        Creature p;
        Scanner reader = new Scanner(System.in);
        System.out.println("Update a creatures health? (Y/N) ");
        query = reader.nextLine();
        if (query.toUpperCase().equals("Y"))
        {
            System.out.println("Input characters name: ");
            findName = reader.nextLine();
            System.out.print("New hit points: ");
            newHp = Integer.parseInt(reader.nextLine());
            p = list.get(findName);
            if (newHp == 0)
            {
                list.remove(findName);
            }
            else
            {
                p.setHealth(newHp);
            }

        }
    }
}
