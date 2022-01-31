package com.shop;

/*
    ENUM 객체는 키워드 뒤에 열거할 항목을 대문자로만 사용하고 콤마를 통해 구분.


 */
enum ServerLanguage {
    C, JAVA, PHP, ASP
}

enum ClientLanguage {
    JAVASCRIPT, VISUALSCRIPT
}

enum DBLANGUAGE {
    ORACLE, DB2, MSSQL
}

public class Language {
    public static void main(String[] args) {
        // 모든값을 가지고 올때
        for(ServerLanguage serverLanguage : ServerLanguage.values()) {
            System.out.println("Server Language values=->" + serverLanguage);
        }

        // 특정값을 가지고 올때
        System.out.println("Server Language values=->" + ServerLanguage.valueOf("JAVA"));
    }
}
