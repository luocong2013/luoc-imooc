package com.algorithm.poker;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.algorithm.poker
 * @description: TODO
 * @date 2017/11/11 17:35
 */
public class Game {
    private static Scanner in = new Scanner(System.in);

    public static Player[] createPlayers(int n) {
        System.out.println("##### 创建玩家 #####");
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            System.out.println("请输入第" + (i + 1) + "个玩家的ID和姓名：");
            int id;
            String name;
            while (true) {
                try {
                    System.out.println("输入ID：");
                    id = in.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("请输入整数类型的ID！");
                    in = new Scanner(System.in);
                }
            }
            System.out.println("输入姓名：");
            name = in.next();
            players[i] = new Player(id, name);
        }
        return players;
    }

    public static void comparePlayers(Player p1, Player p2) {
        int result = p1.compareTo(p2);
        if (result > 0) {
            System.out.println("$$$$$ Player : " + p1.getName() + " wins! $$$$$");
        } else if (result < 0) {
            System.out.println("$$$$$ Player : " + p2.getName() + " wins! $$$$$");
        } else {
            System.out.println("@@@@@ The two persons draw @@@@@");
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PokerCardList cardList = new PokerCardList();
        System.out.println(cardList.getCardList().toString());
        new Shuffle().shuffle(cardList);
        int n = 2;    //创建两个玩家
        Player[] players = createPlayers(n);
        for (int i = 0; i < players.length; i++) {
            System.out.println("欢迎玩家：" + players[i].getName());
        }
        int nums = 2;    //每个玩家发两张牌
        new Deal().deal(players, cardList, nums);
        System.out.println("-----$$$$$ Game Start $$$$$-----");
        for (Player player : players) {
            Collections.sort(player.getCards());
        }
        for (int i = 0; i < n; i++) {
            int size = players[i].getCards().size();
            PokerCard card = players[i].getCards().get(size - 1);
            System.out.println("Player : " + players[i].getName() + "最大的手牌为：" + card.getColor() + card.getPoint());
        }
        comparePlayers(players[0], players[1]);
        System.out.println("玩家各自的手牌为：");
        for (int i = 0; i < n; i++) {
            System.out.println(players[i].getName() + ":" + players[i].toString());
        }
    }
}
