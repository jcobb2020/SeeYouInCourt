package Commands;

public enum Commands {
    rubrum, // - wyświetlenie metryki jednego lub wielu orzeczeń, na podstawie sygnatury (pierwsza wartość w polu courtCases lub ciąg "II SA/OI 472/18" w przypadku orzeczeń sądów administracyjnych)
    content, // - wyświetlenie uzasadnienia (czyli treści pola textContent lub treść od słowa "UZASADNIENIE")
    judge, // - wyświetlał liczbę orzeczeń dla wybranego sędziego
    judges, // - wyświetla 10 sędziów, którzy wydali najwięcej orzeczeń
    months, // - wyświetlał liczbę orzeczeń w poszczególnych miesiącach (rozkład statystyczny)
    courts, // - wyświetlał liczbę orzeczeń ze względu na typ sądu (rozkład statystyczny)
    regulations, // - wyświetlał 10 najczęściej przywoływanych ustaw
    jury// - wyświetlał liczbę spraw przypadających na określony skład sędziowski (określoną liczbę sędziów)
}
