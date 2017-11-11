package com.algorithm.poker;

import java.util.Random;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.algorithm.poker
 * @description: TODO
 * @date 2017/11/11 17:35
 */
public class Shuffle {
    public void shuffle(PokerCardList cardList) {
        System.out.println("——————————开始洗牌——————————");
        Random random = new Random();
        if (cardList.getCardList().isEmpty()) {
            System.out.println("##### 未创建扑克牌，请先创建一副扑克牌 #####");
            return;
        }
        for (int i = 0; i < cardList.getCardList().size(); i++) {
            int index = random.nextInt(cardList.getCardList().size());
            PokerCard card = cardList.getCardList().get(i);
            card = cardList.getCardList().set(index, card);
            cardList.getCardList().set(i, card);
        }
        System.out.println("——————————洗牌结束——————————");
    }
}
