package com.imooc.thread.synchroized;

/**
 * @author luoc
 * @version V0.0.1
 * @package com.imooc.thread.synchroized
 * @description: 题目：张飞和李逵买电影票，售票员只有两张5元的钱，电影票5元钱一张。张飞拿20元一张的人民币排在李逵的前面
 * 买票，李逵拿一张5元的人民币买票。因此张飞必须等待（李逵比张飞先买到票）。
 * @date 2017/11/11 16:43
 */
public class StageTicketHouse {

    public static void main(String[] args) {
        TicketHouse ticketHouse = new TicketHouse();

        Thread zhangfei = new Thread(ticketHouse, "张飞");
        Thread likui = new Thread(ticketHouse, "李逵");

        zhangfei.start();
        likui.start();
    }
}
