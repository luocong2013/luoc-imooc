package com.algorithm.poker;

import java.util.ArrayList;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.algorithm.poker
 * @description: TODO
 * @date 2017/11/11 17:32
 */
public class PokerCardList {
    private ArrayList<PokerCard> cardList = new ArrayList<>();

    {
        System.out.println("——————————创建扑克牌——————————");
        String[] colors = {"Diamond", "Club", "Heart", "Spade"};
        String[] points = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "A"};
        for (String color : colors) {
            for (String point : points) {
                cardList.add(new PokerCard(color, point));
            }
        }
        System.out.println("——————————扑克牌创建成功！——————————");
    }

    public ArrayList<PokerCard> getCardList() {
        return cardList;
    }
}
