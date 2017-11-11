package com.algorithm.poker;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.algorithm.poker
 * @description: TODO
 * @date 2017/11/11 17:31
 */
public class Player implements Comparable<Player> {
    private int id;
    private String name;
    private ArrayList<PokerCard> cards;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<PokerCard> getCards() {
        return cards;
    }

    public void setCards(PokerCard card) {
        cards.add(card);
    }

    @Override
    public int compareTo(Player o) {
        if (cards.size() == 0 || o.cards.size() == 0) {
            System.out.println("&&&&& 发牌未完成，无法比较 &&&&&");
            return 0;
        }
        Collections.sort(cards);
        Collections.sort(o.cards);
        for (int i = cards.size() - 1, j = o.cards.size() - 1; i >= 0 && j >= 0; i--, j--) {
            if (cards.get(i).compareTo(o.cards.get(i)) != 0) {
                return cards.get(i).compareTo(o.cards.get(i));
            }
        }
        return cards.size() - o.cards.size();
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
