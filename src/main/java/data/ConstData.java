package data;

public class ConstData {


    public static String URL = "https://boardgamegeek.com/";
    public static String XMLApi = "https://boardgamegeek.com/xmlapi/boardgame/";
    public static String descriptionXMLPath = "boardgames.boardgame.description";
    public static String nameXMLPath = "boardgames.boardgame.name";
    public static String totalvotesXMLPath = "boardgames.boardgame.poll.findAll { it.@name == 'language_dependence' } .@totalvotes";

    public static String numvotesXMLPath(int valueNumber) {
        return "boardgames.boardgame.poll.findAll { it.@name == 'language_dependence' }.results.result.findAll {it.@level == '" + valueNumber + "'}.@numvotes";
    }

    public static String valueXMLPath(int valueNumber) {
        return "boardgames.boardgame.poll.findAll { it.@name == 'language_dependence' }.results.result.findAll {it.@level == '" + valueNumber + "'}.@value";
    }
}
