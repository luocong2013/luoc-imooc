package com.algorithm.poker;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.algorithm.poker
 * @description: TODO
 * @date 2017/11/11 17:27
 */
public class PokerCard implements Comparable<PokerCard> {
    private String color;
    private String point;

    public PokerCard() {
    }

    public PokerCard(String color, String point) {
        this.color = color;
        this.point = point;
    }

    public String getColor() {
        return color;
    }

    public String getPoint() {
        return point;
    }

    /**
     * 比较点数，大/平/小，分别返回1/0/-1
     */
    public int comparePoint(String p1, String p2) {
        //至少有一张牌的点数为A的情况
        if (p1.equals("A") || p2.equals("A")) {
            if (p1.equals(p2)) {
                return 0;
            } else if (p1.equals("A")) {
                return 1;
            } else {
                return -1;
            }
        }
        //至少有一张牌的点数为10的情况
        if (p1.equals("10") || p2.equals("10")) {
            if (p1.equals(p2)) {
                return 0;
            } else if (p1.equals("10")) {
                if ('0' <= p2.charAt(0) && p2.charAt(0) <= '9') {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                if ('0' <= p1.charAt(0) && p1.charAt(0) <= '9') {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
        //没有牌A和牌10的情况
        return p1.compareTo(p2);
    }

    /**
     * 比较花色，大/平/小，分别返回1/0/-1
     */
    public int compareColor(String c1, String c2) {
        //至少有一张牌的花色为Club的情况
        if (c1.equals("Club") || c2.equals("Club")) {
            if (c1.equals(c2)) {
                return 0;
            } else if (c1.equals("Club")) {
                if (c2.equals("Diamond")) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                if (c1.equals("Diamond")) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
        //没有花色为Club的情况
        return c1.compareTo(c2);
    }

    @Override
    public int compareTo(PokerCard arg0) {
        if (comparePoint(point, arg0.point) == 0) {
            return comparePoint(color, arg0.color);
        }
        return comparePoint(point, arg0.point);
    }

    @Override
    public String toString() {
        return color + point;
    }
}
