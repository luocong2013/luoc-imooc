package com.algorithm.drill.day8;

import java.text.MessageFormat;

public class MyMessageFormat {

    public static final String MYSQL_SQL = "select * from ({0}) sel_tab00 limit {1},{2}";

    public static void main(String[] args) {
        String sql = "SELECT DISTINCT aht.PROC_INST_ID_ " +
                "FROM act_hi_taskinst aht " +
                "INNER JOIN s_xy_absence s ON aht.PROC_INST_ID_ = s.flow_inst_id " +
                "WHERE aht.NAME_ = '人事部' AND aht.ASSIGNEE_ = ? AND aht.END_TIME_ IS NOT NULL";
        sql = MessageFormat.format(MYSQL_SQL, sql, "0", "20");
        System.out.println(sql);
    }

}
