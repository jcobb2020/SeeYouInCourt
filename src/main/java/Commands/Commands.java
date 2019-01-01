package Commands;

public enum Commands {
    rubrum, // - wyświetlenie metryki jednego lub wielu orzeczeń, na podstawie sygnatury (pierwsza wartość w polu courtCases lub ciąg "II SA/OI 472/18" w przypadku orzeczeń sądów administracyjnych)
    content, // - wyświetlenie uzasadnienia (czyli treści pola textContent lub treść od słowa "UZASADNIENIE")
    judge, // - wyświetlał liczbę orzeczeń dla wybranego sędziego
    judges, // - wyświetla 10 sędziów, którzy wydali najwięcej orzeczeń
    months, // - wyświetlał liczbę orzeczeń w poszczególnych miesiącach (rozkład statystyczny)
    courts, // - wyświetlał liczbę orzeczeń ze względu na typ sądu (rozkład statystyczny)
    regulations, // - wyświetlał 10 najczęściej przywoływanych ustaw
    jury, // - wyświetlał liczbę spraw przypadających na określony skład sędziowski (określoną liczbę sędziów)
    save,
    WRONG;

    public static String generateHelp() {
        StringBuilder builder = new StringBuilder();
        builder.append("rubrum,  - wyświetlenie metryki jednego lub wielu orzeczeń, na podstawie sygnatury (pierwsza wartość w polu courtCases lub ciąg \"II SA/OI 472/18\" w przypadku orzeczeń sądów administracyjnych"+"\n");
        builder.append("content,  - wyświetlenie uzasadnienia (czyli treści pola textContent lub treść od słowa \"UZASADNIENIE\""+"\n");
        builder.append("judge,  - wyświetla liczbę orzeczeń dla wybranego sędziego"+"\n");
        builder.append("judges,  - wyświetla 10 sędziów, którzy wydali najwięcej orzeczeń"+"\n");
        builder.append("months,  - wyświetla liczbę orzeczeń w poszczególnych miesiącach (rozkład statystyczny)"+"\n");
        builder.append("courts,  - wyświetla liczbę orzeczeń ze względu na typ sądu (rozkład statystyczny"+"\n");
        builder.append("regulations,  - wyświetla 10 najczęściej przywoływanych ustaw"+"\n");
        builder.append("    jury - wyświetla liczbę spraw przypadających na określony skład sędziowski (określoną liczbę sędziów)"+"\n");
        builder.append("save - zapisuje stworzony dokument i opuszcza program");
        return builder.toString();
    }

    public static void displayHelp() {
        String help = generateHelp();
        System.out.println(help);
    }

    public static Commands parser(String toParse) {
        switch (toParse.toLowerCase()) {
            case ("rubrum"):
                return Commands.rubrum;
            case ("content"):
                return Commands.content;
            case ("judge"):
                return Commands.judge;
            case ("judges"):
                return Commands.judges;
            case ("months"):
                return Commands.months;
            case ("courts"):
                return Commands.courts;
            case ("regulations"):
                return Commands.regulations;
            case ("jury"):
                return Commands.jury;
            case("save"):
                return  Commands.save;
            default:
                return Commands.WRONG;
        }
    }
}
