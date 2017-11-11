package com.algorithm.poker;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.algorithm.poker
 * @description: TODO
 * @date 2017/11/11 17:33
 */
public class Deal {
    public void deal(Player[] players, PokerCardList cardList, int nums) {
        System.out.println("——————————开始发牌——————————");
        if (players.length == 0) {
            System.out.println("##### 没有玩家，请先创建玩家 #####");
            return;
        }
        if (cardList.getCardList().isEmpty()) {
            System.out.println("##### 未创建扑克牌，请先创建一副扑克牌 #####");
            return;
        }
        int index = 0;
        for (int i = 0; i < nums; i++) {
            for (int j = 0; j < players.length; j++) {
                System.out.println("Player : " + players[j].getName() + " take a card.");
                players[j].setCards(cardList.getCardList().get(index++));
            }
        }
        System.out.println("——————————发牌结束！——————————");
    }
}
